package model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import model.interfaces.IMusic;

/**
 *
 * @author mateus
 */
public class Music implements IMusic{
    
    private long Id;
    private String name;
    private String author;
    private LocalTime duration;
    private boolean selected;

   
    public Music(){
        
    }
    
    public Music(String name, String author, String duration){
        //TODO get lastId increment in database
        this.name  = name;
        this.author = author;
        this.duration = LocalTime.parse(duration);
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
    public String getDuration() {
        return duration.toString();
    }

    public void setDuration(String duration) {
        this.duration = LocalTime.parse(duration);
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
