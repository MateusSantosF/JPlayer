package model;

import model.interfaces.IMusic;

/**
 *
 * @author mateus
 */
public class Music implements IMusic{
    
    private long Id;
    private String title;
    private String author;
    private String album;
    private long duration;
    private boolean selected;


    
    public Music(){
        
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
        public boolean isSelected() {
        return selected;
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
    
    
}
