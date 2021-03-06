package DAO;

import Utils.Constants;
import Utils.StringExtensions;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
 * @param <T>
 */
public class TableUnionWriter<T, E> {

    private final T father;
    private final E children;

    public TableUnionWriter(T father, E children) {
        this.father = father;
        this.children = children;
    }

    public boolean writeInTable(List<E> data) {

        File tableCSV = getTableFile();

        if (!tableCSV.exists() || !tableCSV.canRead() || !tableCSV.isFile()) {
            System.out.println("FAIL READ TABLE");
            return false;
        }

        FileWriter writer;
        BufferedWriter buffer;

        long id = 0;
        if (father instanceof IPlaylist) {
            id = ((IPlaylist) father).getId();
        }

        if (father instanceof IUser) {
            id = ((IUser) father).getId();
        }

        String newLine = id + ":{" + getIdForNewRegisters(data) + "}";

        try {
            writer = new FileWriter(tableCSV, true);
            buffer = new BufferedWriter(writer);
            buffer.newLine();
            buffer.append(newLine);
            buffer.close();
            writer.close();

            return true;

        } catch (FileNotFoundException ex) {
            Logger.getLogger(TableWriter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TableWriter.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
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

    public boolean DeleteOneRegister(long id, List<E> newRegisters) {

        File tableCSV = getTableFile();

        String lineUpdate = readSpecifLine(id); //actual line
        String newRegisterId = getIdForNewRegisters(newRegisters); //ids new line      
        List<String> union = new ArrayList<>(Arrays.asList(newRegisterId.split(",")));

        int lenght = union.size();
        StringBuilder formated = new StringBuilder();
        if (!newRegisterId.isEmpty()) {
            formated.append(id + ":{");
            for (int i = 0; i < lenght; i++) {
                formated.append(union.get(i));

                if (i < lenght - 1) {
                    formated.append(",");
                }
            }
            formated.append("}");
        }

        formated.append("");

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

    public boolean DeleteMultiplesRegisters(List<E> deletedRegisters) {

        File tableCSV = getTableFile();

        String newRegisterId = getIdForNewRegisters(deletedRegisters); //ids new line 

        List<String> removedIdString = new ArrayList<>(Arrays.asList(newRegisterId.split(",")));
        List<Long> removedIdLong = null;

        if (removedIdString.size() > 1) {
            removedIdLong = removedIdString.stream().map(Long::parseLong).collect(Collectors.toList());
        } else {
            removedIdLong = new ArrayList<>();
            removedIdLong.add(Long.parseLong(newRegisterId));
        }

        if (!tableCSV.exists() || !tableCSV.canRead() || !tableCSV.isFile()) {
            System.out.println("FAIL READ TABLE");
            return false;
        }

        Path path = Paths.get(tableCSV.getPath());

        try ( Stream<String> stream = Files.lines(path, StandardCharsets.UTF_8)) {

            List<String> list = stream.collect(Collectors.toList());
            List<String> newList = new ArrayList<>();

            for (int i = 0; i < list.size(); i++) {
                String currentLine = list.get(i);
                if (currentLine.isBlank() || currentLine.isEmpty()) {
                    continue;
                }
                long lineId = StringExtensions.getIdInLine(currentLine); // current line ID
                List<Long> listLineId = StringExtensions.formatLine(currentLine); // current line IDs
                listLineId.removeAll(removedIdLong);
                List<String> currentNewLine = listLineId.stream().map(String::valueOf).collect(Collectors.toList());

                if (currentNewLine.size() > 0) {
                    StringBuilder formated = new StringBuilder();
                    int length = currentNewLine.size();
                    formated.append(lineId + ":{");

                    for (int j = 0; j < length; j++) {
                        formated.append(currentNewLine.get(j));

                        if (j < length - 1) {
                            formated.append(",");
                        }
                    }
                    formated.append("}");
                    newList.add(formated.toString());
                }
            }

            Files.write(path, newList, StandardCharsets.UTF_8);
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
            } else if (current instanceof IPlaylist) {
                serialized.append(((IPlaylist) current).getId());
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

        if (children instanceof IUser) {
            return new File(Constants.USER_PLAYLIST_TABLE);
        }

        if (children instanceof IPlaylist) {
            return new File(Constants.USER_PLAYLIST_TABLE);
        }

        return null;
    }

}
