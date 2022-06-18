package model.interfaces;

import java.time.LocalDate;

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
    
    public LocalDate getCreateData();

    public void setCreateData(LocalDate createDate);
}
