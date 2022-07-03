package Model;

import java.time.LocalTime;
import Model.interfaces.IMusic;

public class Music implements IMusic {

    private long Id;
    private String name;
    private String author;
    private LocalTime duration;
    private boolean selected;

    public Music() {

    }

    public Music(String name, String author, String duration) {
        this.name = name;
        this.author = author;
        this.duration = LocalTime.parse(duration);
    }

    public Music(String[] atributes) {
        this.Id = Long.valueOf(atributes[0]);
        this.name = atributes[1];
        this.author = atributes[2];
        this.duration = LocalTime.parse(atributes[3]);
    }

    @Override
    public long getId() {
        return Id;
    }

    @Override
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

    @Override
    public String serialize() {
        return String.format("%d:{%s,%s,%s}", this.getId(), this.getName(), this.getAuthor(), this.getDuration());
    }

}
