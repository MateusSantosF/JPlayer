/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import model.Music;
import model.Playlist;
import model.User;

/**
 *
 * @author mateus
 */
public class TableFactory {
    
    
    private final Object type;
    
    public TableFactory(Object type){
        this.type = type;
    }
     
    public Object CreateObject(String[] atributes){
        
        if( type instanceof Music){
            return (Object) new Music(atributes);
        }
        
        if(type instanceof Playlist){
            return (Object) new Playlist(atributes);
        }
        
        if(type instanceof User){
            return (Object) new User(atributes);
        }
       return null;
    }
}
