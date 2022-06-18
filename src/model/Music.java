package model;

import model.interfaces.IMusic;

/**
 *
 * @author mateus
 */
public class Music implements IMusic{
    
    private long Id;
    private String name;
    private String author;
    private long duration;
    private boolean selected;


    
    public Music(){
        
    }

    @Override
    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }
    
    @Override
    public String getName() {
        return name;
    }

    public void setName(String title) {
        this.name = title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
    @Override
        public boolean isSelected() {
        return selected;
    }

    @Override
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    
    
}
