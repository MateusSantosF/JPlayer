
package Utils;

import Model.Music;
import Model.Playlist;
import Model.User;


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
