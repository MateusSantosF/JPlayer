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
