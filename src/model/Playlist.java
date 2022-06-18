package model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import model.interfaces.IMusic;
import model.interfaces.IPlaylist;

/**
 *
 * @author mateus
 */
public class Playlist implements IPlaylist {

    private  String title;
    private  String description;  
    private  List<IMusic> musics;
    private  LocalDate createDate;
    
    public Playlist(List<IMusic> musics, String title, String description){
        this.musics = musics;
        this.title = title;
        this.description = description;
    }
    
     public Playlist(List<IMusic> musics, String title, String description, LocalDate createDate){
        this.musics = musics;
        this.title = title;
        this.description = description;
        this.createDate = createDate;
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
    
    @Override
    public void addMusics(List<IMusic> musics){
        this.musics.addAll(musics);
    }

    @Override
    public LocalDate getCreateData() {
        return createDate;
    }

    @Override
    public void setCreateData(LocalDate createData) {
        this.createDate = createData;
    }
    
    
    
    
}
