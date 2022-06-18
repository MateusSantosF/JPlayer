/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facades;

import JPlayer.Mocks.MusicMock;
import java.util.List;
import model.Music;
import model.interfaces.IMusic;



/**
 *
 * @author mateus
 */
public class MusicFacade {
    
    
    public List<IMusic> GetAllMusics(){
        return MusicMock.musicsList();
    }
    
     public List<IMusic> GetAllMusicsTwo(){
        return MusicMock.musicsListTwo();
    }
}
