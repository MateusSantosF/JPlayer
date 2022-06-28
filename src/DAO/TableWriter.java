package DAO;

import Utils.Constants;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.interfaces.IMusic;
import Model.interfaces.IPlaylist;
import Model.interfaces.IUser;
import Utils.StringExtensions;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author mateus
 * @param <T>
 */
public class TableWriter <T>{
    
    private final T type;
   
    public TableWriter(T type){
        this.type = type;
    }
    
    public boolean writeInTable(T data){
        
        File tableCSV = getTableFile();
      
        
        if(!tableCSV.exists() || !tableCSV.canRead() ||!tableCSV.isFile()){
            System.out.println("FAIL READ TABLE");
            return false;
        }
        
        FileWriter writer;
        BufferedWriter buffer;
        
        try {
            writer = new FileWriter(tableCSV, true);
            buffer = new BufferedWriter(writer);            
            buffer.append("\n"+serializeLine(data));
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
    
    public boolean DeleteRegister(T removeData) {
        
        File tableCSV = getTableFile();
        
        long id = getIdFromData(removeData);
        
        if(id == 0){
            return false;
        }
        
        String lineUpdate = readSpecifLine(id); //actual line
        String formated = "";
        
        if (!tableCSV.exists() || !tableCSV.canRead() || !tableCSV.isFile()) {
            System.out.println("FAIL READ TABLE");
            return false;
        }

        Path path = Paths.get(tableCSV.getPath());

        try ( Stream<String> stream = Files.lines(path, StandardCharsets.UTF_8)) {

            List<String> list = stream.map(line -> line.equals(lineUpdate) ? formated : line)
                    .collect(Collectors.toList());

            Files.write(path, list, StandardCharsets.UTF_8);
        } catch (IOException e) {
            Logger.getLogger(TableReader.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return true;
    }
    
    public boolean UpdateRegister(T updateData) {
        
        File tableCSV = getTableFile();
        
        long id = getIdFromData(updateData);
        
        if(id == 0){
            return false;
        }

        String lineUpdate = readSpecifLine(id); //actual line   
        String formated = serializeLine(updateData); //new line

 
        
        if (!tableCSV.exists() || !tableCSV.canRead() || !tableCSV.isFile()) {
            System.out.println("FAIL READ TABLE");
            return false;
        }

        Path path = Paths.get(tableCSV.getPath());

        try ( Stream<String> stream = Files.lines(path, StandardCharsets.UTF_8)) {

            List<String> list = stream.map(line -> line.equals(lineUpdate) ? formated : line)
                    .collect(Collectors.toList());

            Files.write(path, list, StandardCharsets.UTF_8);
        } catch (IOException e) {
            Logger.getLogger(TableReader.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return true;
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

   
    
    private String serializeLine(T obj){
       
        if( type instanceof IMusic){
            return ((IMusic)obj).serialize();
        }
        
        if( type instanceof IPlaylist){
            return ((IPlaylist)obj).serialize();
        }
        
        if( type instanceof IUser){
            return ((IUser)obj).serialize();
        }
                 
        return "";
    }
    
    private long getIdFromData(T data){
        
        long id = 0;
        
        if(type instanceof IMusic){
            id = ((IMusic) data).getId();
        }
        
        if(type instanceof IPlaylist){
            id = ((IPlaylist) data).getId();
        }
        
        
        if(type instanceof IUser){
            id = ((IUser) data).getId();
        }
        
        return id;
    }
    
    private File getTableFile(){
              
        if( type instanceof IMusic){
            return new File(Constants.MUSIC_TABLE);
        }
        
        if( type instanceof IPlaylist){
            return new File(Constants.PLAYLIST_TABLE);
        }
        
        if( type instanceof  IUser) {
            return new File(Constants.USER_TABLE);
        }
        return null;
    }

    
}
