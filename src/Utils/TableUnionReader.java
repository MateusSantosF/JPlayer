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
import model.interfaces.IUser;

/**
 *
 * @author mateus
 * @param <T>
 */
public class TableUnionReader <T, E>{
    
    private final T father;
    private final E children;
   
    public TableUnionReader(T father, E children){
        this.father = father;
        this.children = children;
    }
    
    public List<Long> readTable(){
        
        File tableCSV = getTableFile();
        List<Long> objectList = new ArrayList<>();
        
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
                if( father instanceof IPlaylist){
                   if(StringExtensions.getIdInLine(linha) == ((IPlaylist) father).getId()){                 
                       objectList.addAll(StringExtensions.formatLine(linha));
                       break;
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
    

    
    private File getTableFile(){
              
        if( children instanceof IMusic){
            return new File(Constants.PLAYLIST_MUSIC_TABLE);
        }
        
        return null;
    }

    
}
