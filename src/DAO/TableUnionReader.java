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
                }

//                if( father instanceof IUser){
//                   if(getIdInLine(linha) == ((IPlaylist) father).getId()){                 
//                       objectList.addAll(formatLine(linha));
//                       break;
//                   }
//               }
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

    public boolean UpdateRegister(long id, List<E> newRegisters) {

        File tableCSV = getTableFile();
        String lineUpdate = readSpecifLine(id); //actual line
        String oldRegisterId = "";

        oldRegisterId = lineUpdate.substring(lineUpdate.indexOf(":{") + 2, lineUpdate.lastIndexOf("}")); //actual ids

        String newRegisterId = getIdForNewRegisters(newRegisters); //ids new line

        List<String> union = new ArrayList<>(Arrays.asList(oldRegisterId.split(",")));
        List<String> newRegister = new ArrayList<>(Arrays.asList(newRegisterId.split(",")));

        union.addAll(newRegister);

        List<String> intersection = Arrays.stream(union.toArray(new String[0])).distinct().toList();

        int lenght = intersection.size();
        StringBuilder formated = new StringBuilder();

        formated.append(id + ":{");
        for (int i = 0; i < lenght; i++) {
            formated.append(intersection.get(i));

            if (i < lenght - 1) {
                formated.append(",");
            }
        }
        formated.append("}");

        if (!tableCSV.exists() || !tableCSV.canRead() || !tableCSV.isFile()) {
            System.out.println("FAIL READ TABLE");
            return false;
        }

        Path path = Paths.get(tableCSV.getPath());

        try ( Stream<String> stream = Files.lines(path, StandardCharsets.UTF_8)) {

            List<String> list = stream.map(line -> line.equals(lineUpdate) ? formated.toString() : line)
                    .collect(Collectors.toList());

            Files.write(path, list, StandardCharsets.UTF_8);
        } catch (IOException e) {
            Logger.getLogger(TableReader.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return true;
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

        return null;
    }

}
