
package View.Mocks;

import java.util.ArrayList;
import java.util.List;
import Model.Music;
import Model.interfaces.IMusic;

public class MusicMock {
    
    
    public static List<IMusic> musicsList(){
        List<IMusic> list = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            Music current = new Music();
            current.setId(i);
            current.setName("Title"+i);
            current.setDuration("02:53");
            current.setSelected(false);
            current.setAuthor("Author"+i);
            list.add(current);
        }
        
        return list;        
    }
    
      public static List<IMusic> musicsListTwo(){
         List<IMusic> list = new ArrayList<>();
        
        for (int i = 10; i < 20; i++) {
            Music current = new Music();
            current.setId(i);
            current.setName("Title"+i);
            current.setDuration("03:52");
            current.setSelected(false);
            current.setAuthor("Author"+i);
            list.add(current);
        }
        
        return list;        
    }
}
