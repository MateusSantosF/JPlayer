/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JPlayer.Mocks;

import java.util.ArrayList;
import java.util.List;
import model.Music;
import model.Playlist;
import model.interfaces.IPlaylist;

/**
 *
 * @author mateus
 */
public class PlaylistMock {
    
    public static List<IPlaylist> playlistList(){
         List<IPlaylist> list = new ArrayList<>();
        
        for (int i = 0; i < 16; i++) {
            IPlaylist current = new Playlist(MusicMock.musicsList(), "Playlist"+i, "Any description"+i);
            list.add(current);
        }
        
        return list;        
    }
}
