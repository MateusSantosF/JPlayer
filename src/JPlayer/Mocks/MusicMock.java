/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JPlayer.Mocks;

import java.util.ArrayList;
import java.util.List;
import model.Music;
import model.interfaces.IMusic;

/**
 *
 * @author mateus
 */
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
