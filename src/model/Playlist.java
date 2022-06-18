package model;

import java.util.List;
import model.interfaces.IMusic;
import model.interfaces.IPlaylist;

/**
 *
 * @author mateus
 */
public class Playlist implements IPlaylist {

    private final String title;
    private final String description;
    
    private final List<IMusic> musics;
    
    public Playlist(List<IMusic> musics, String title, String description){
        this.musics = musics;
        this.title = title;
        this.description = description;
    }
    
    @Override
    public List<IMusic> getMusics() {
        return this.musics;
    }
    
    @Override
    public String getTitle(){
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }
    
    
    
    
}
