package model;

import java.util.List;
import model.interfaces.IPlaylist;

/**
 *
 * @author mateus
 */
public class Playlist implements IPlaylist {

    private final String title;
    private final String description;
    
    private final List<Music> musics;
    
    public Playlist(List<Music> musics, String title, String description){
        this.musics = musics;
        this.title = title;
        this.description = description;
    }
    
    @Override
    public List<Music> getMusics() {
        return this.musics;
    }
    
    public String getTitle(){
        return title;
    }

    public String getDescription() {
        return description;
    }
    
    
    
    
}
