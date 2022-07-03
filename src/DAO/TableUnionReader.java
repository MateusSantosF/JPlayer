package DAO;

import Utils.Constants;
import Utils.StringExtensions;
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
public class TableUnionReader<T, E> {

    private final T father;
    private final E children;

    public TableUnionReader(T father, E children) {
        this.father = father;
        this.children = children;
    }

    public List<Long> readTable() {

        File tableCSV = getTableFile();
        List<Long> objectList = new ArrayList<>();

        if (!tableCSV.exists() || !tableCSV.canRead() || !tableCSV.isFile()) {
            System.out.println("FAIL READ TABLE");
            return null;
        }

        FileReader reader;
        BufferedReader buffer;

        try {
            reader = new FileReader(tableCSV);
            buffer = new BufferedReader(reader);
            String line = "";

            while ((line = buffer.readLine()) != null) {
                if (!line.isBlank()) {
                    if (father instanceof IPlaylist) {
                        if (StringExtensions.getIdInLine(line) == ((IPlaylist) father).getId()) {
                            
                            objectList.addAll(StringExtensions.formatLine(line));
                            break;
                        }
                    }
                    
                    if (father instanceof IUser) {
                        if (StringExtensions.getIdInLine(line) == ((IUser) father).getId()) {
                            
                            objectList.addAll(StringExtensions.formatLine(line));
                            break;
                        }
                    }
                }
            }
            buffer.close();
            reader.close();
            return objectList;

        } catch (FileNotFoundException ex) {
            Logger.getLogger(TableUnionReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TableUnionReader.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

   

    private String getIdForNewRegisters(List<E> registers) {

        StringBuilder serialized = new StringBuilder();
        int size = registers.size();

        for (int i = 0; i < size; i++) {

            E current = registers.get(i);
            if (current instanceof IMusic) {
                serialized.append(((IMusic) current).getId());
                if (i < size - 1) {
                    serialized.append(",");
                }
            }
        }

        return serialized.toString();
    }

    private String readSpecifLine(long id) {

        File tableCSV = getTableFile();
        String lineSearch = "";

        if (!tableCSV.exists() || !tableCSV.canRead() || !tableCSV.isFile()) {
            System.out.println("FAIL READ TABLE");
            return null;
        }

        FileReader reader;
        BufferedReader buffer;

        try {
            reader = new FileReader(tableCSV);
            buffer = new BufferedReader(reader);
            String line = "";

            while ((line = buffer.readLine()) != null) {

                if (!line.isBlank()) {
                    if (StringExtensions.getIdInLine(line) == id) {
                        lineSearch = line;
                        break;
                    }
                }

            }

            buffer.close();
            reader.close();

            return lineSearch;

        } catch (FileNotFoundException ex) {
            Logger.getLogger(TableReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TableReader.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lineSearch;
    }

    private File getTableFile() {

        if (children instanceof IMusic) {
            return new File(Constants.PLAYLIST_MUSIC_TABLE);
        }
        
        if (children instanceof IPlaylist) {
            return new File(Constants.USER_PLAYLIST_TABLE );
        }

        return null;
    }

}
