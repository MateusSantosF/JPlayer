package model.interfaces;

/**
 *
 * @author mateus
 */
public interface IMusic {
    
    long getId();
    String getTitle();
    String getAuthor();
    String getAlbum();
    long getDuration();  
    void setSelected(boolean value);
    boolean isSelected();
}
