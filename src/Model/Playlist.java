package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import Model.interfaces.IMusic;
import Model.interfaces.IPlaylist;

/**
 *
 * @author mateus
 */
public class Playlist implements IPlaylist {

    private long Id;
    private String title;
    private String description;  
    private List<IMusic> musics = new ArrayList<>();
    private LocalDate createDate;
    
    public Playlist(){
        
    }
    
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
    
    public Playlist(String[] atributes){
        this.Id = Long.valueOf(atributes[0]);
        this.title = atributes[1];
        this.description = atributes[2];
        this.createDate = LocalDate.parse(atributes[3]);
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

    @Override
    public long getId() {
        return this.Id;
    }
    
    
    @Override
    public void setId(long id) {
        this.Id = id;
    }

    @Override
    public String serialize() {
        return String.format("%d:{%s,%s,%s}", this.getId(), this.getTitle(), this.getDescription(), this.getCreateData().toString());
    }

    
 
}
