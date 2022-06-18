package model.interfaces;

/**
 *
 * @author mateus
 */
public interface IMusic {
    
    long getId();
    String getName();
    String getAuthor();
    String getDuration();  
    void setSelected(boolean value);
    boolean isSelected();
}
