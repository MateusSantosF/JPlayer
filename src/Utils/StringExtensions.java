
package Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class StringExtensions {
 
    
    /**
     * Return id's from line of Unions Tables
     * @param line
     * @return 
    */
    public static List<Long> formatLine(String line){
       
        int indexId = line.indexOf(":{");
        String[] atributes = line.substring( indexId+2, line.lastIndexOf("}")).trim().split(",");
        List<String> concat = new ArrayList<>(Arrays.asList(atributes));
        
        List<Long> convert = new ArrayList<>();
        
        concat.forEach( item ->{
            if(!item.isEmpty())
                convert.add(Long.valueOf(item));
        });
                 
        return convert;
    }
    
    public static String[] formatLineAndGetAtributes(String line){
       
        int indexId = line.indexOf(":{");
        String id = line.substring(0, indexId);
        String[] atributes = line.substring(indexId+2, line.lastIndexOf("}")).trim().split(",");
        List<String> concat = new ArrayList<>(Arrays.asList(atributes));
        concat.add(0, id);
                 
        return concat.toArray(String[]::new);
    }
    
    /**
     * Extract id from line
     * @param line
     * @return ID current line
     */
    public static long getIdInLine(String line){
        return Long.valueOf(line.substring(0, line.indexOf(":{")));
    }
    
    
    
    
    
    
}
