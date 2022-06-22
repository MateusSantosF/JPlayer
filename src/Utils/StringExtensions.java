/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author mateus
 */
public class StringExtensions {
 
    
    public static long getIdInLine(String line){
        return Long.valueOf(line.substring(0, line.indexOf(":{")));
    }
    
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
    
    public static long deserializeId(String line){
        return Long.valueOf(line.substring(0, line.indexOf(":{")));
    }
    
    
    
    
    
    
}
