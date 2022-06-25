package DAO;

import Utils.Constants;
import Utils.StringExtensions;
import Utils.TableFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import Model.interfaces.IMusic;
import Model.interfaces.IPlaylist;
import Model.interfaces.IUser;

/**
 *
 * @author mateus
 * @param <T>
 */
public class TableReader<T> {

    private final T type;

    public TableReader(T type) {
        this.type = type;
    }

    public List<T> readTable() {

        File tableCSV = getTableFile();
        List<T> objectList = new ArrayList<>();

        if (!tableCSV.exists() || !tableCSV.canRead() || !tableCSV.isFile()) {
            System.out.println("FAIL READ TABLE");
            return null;
        }

        FileReader reader;
        BufferedReader buffer;

        try {
            reader = new FileReader(tableCSV);
            buffer = new BufferedReader(reader);
            String linha = "";

            while ((linha = buffer.readLine()) != null) {

                if (!linha.isBlank()) {
                    String[] formated = StringExtensions.formatLineAndGetAtributes(linha);
                    TableFactory objFactory = new TableFactory(type);
                    objectList.add((T) objFactory.CreateObject(formated));
                }

            }

            buffer.close();
            reader.close();

            return objectList;

        } catch (FileNotFoundException ex) {
            Logger.getLogger(TableReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TableReader.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public long getLastIdInTable() {

        File table = getTableFile();

        if (!table.exists() || !table.canRead() || !table.isFile()) {
            System.out.println("FAIL READ TABLE");
            return -1;
        }

        FileReader reader;
        BufferedReader buffer;
        long lastId = 0;

        try {
            reader = new FileReader(table);
            buffer = new BufferedReader(reader);
            String line = "";

            while ((line = buffer.readLine()) != null) {
                if (!line.isBlank()) {
                    long currentId = StringExtensions.getIdInLine(line);
                    lastId = currentId > lastId ? currentId : lastId;
                }

            }

            return lastId;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TableReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TableReader.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lastId;
    }

    private File getTableFile() {

        if (type instanceof IMusic) {
            return new File(Constants.MUSIC_TABLE);
        }

        if (type instanceof IPlaylist) {
            return new File(Constants.PLAYLIST_TABLE);
        }

        if (type instanceof IUser) {
            return new File(Constants.USER_TABLE);
        }
        return null;
    }

}
