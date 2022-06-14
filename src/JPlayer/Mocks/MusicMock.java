/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JPlayer.Mocks;

import java.util.ArrayList;
import java.util.List;
import model.Music;

/**
 *
 * @author mateus
 */
public class MusicMock {
    
    
    public static List<Music> musicsList(){
         List<Music> list = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            Music current = new Music();
            current.setTitle("Title"+i);
            current.setAlbum("Album"+i);
            current.setDuration(i*20L);
            current.setAuthor("Author"+i);
            list.add(current);
        }
        
        return list;        
    }
}
