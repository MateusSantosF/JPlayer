package Model.interfaces;

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
    void setId(long id);
    boolean isSelected();
    String serialize();
}
