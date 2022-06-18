package model.interfaces;

import java.util.List;

/**
 *
 * @author mateus
 */
public interface IPlaylist {
    
    List<IMusic> getMusics();
    
    public String getTitle();
    
    public String getDescription();
    
    public void addMusics(List<IMusic> musics);
}
