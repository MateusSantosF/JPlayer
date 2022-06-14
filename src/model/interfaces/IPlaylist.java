package model.interfaces;

import java.util.List;
import model.Music;

/**
 *
 * @author mateus
 */
public interface IPlaylist {
    
    List<Music> getMusics();
    
    public String getTitle();
}
