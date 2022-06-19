package model.interfaces;

/**
 *
 * @author mateus
 * @param <T>
 */
public interface IMusic{
    
    long getId();
    String getName();
    String getAuthor();
    String getDuration();  
    void setSelected(boolean value);
    boolean isSelected();
}
