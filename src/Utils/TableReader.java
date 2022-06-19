package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.interfaces.IMusic;
import model.interfaces.IPlaylist;

/**
 *
 * @author mateus
 * @param <T>
 */
public class TableReader <T>{
    
    private final T type;
   
    public TableReader(T type){
        this.type = type;
    }
    
    public List<T> readTable(){
        
        File tableCSV = getTableFile();
        List<T> objectList = new ArrayList<>();
        
        if(!tableCSV.exists() || !tableCSV.canRead() ||!tableCSV.isFile()){
            System.out.println("FAIL READ TABLE");
            return null;
        }
        
        FileReader reader;
        BufferedReader buffer;
        
        try {
            reader = new FileReader(tableCSV);
            buffer = new BufferedReader(reader);
            String linha = "";
            
            while( (linha = buffer.readLine()) != null){
                String[] formated = formatLine(linha);
                TableFactory objFactory = new TableFactory(type);
                objectList.add((T)objFactory.CreateObject(formated));
            }
            
            return objectList;
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TableReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TableReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
        
    }
    
    public long getLastIdInTable(){
        return 0L;
    }
    
    private String[] formatLine(String line){
       
        int indexId = line.indexOf(":{");
        String id = line.substring(0, indexId);
        String[] atributes = line.substring(indexId+2, line.lastIndexOf("}")).trim().split(",");
        List<String> concat = new ArrayList<>(Arrays.asList(atributes));
        concat.add(0, id);
                 
        return concat.toArray(new String[0]);
    }
    
    private File getTableFile(){
              
        if( type instanceof IMusic){
            return new File(Constants.MUSIC_TABLE);
        }
        
        if( type instanceof IPlaylist){
            return new File(Constants.PLAYLIST_TABLE);
        }
        return null;
    }

    
}
