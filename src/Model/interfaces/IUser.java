
package Model.interfaces;

public interface IUser {

    void setId(long id);
    long getId();
    void setSelected(boolean value);
    String serialize();
    String getName();
    String getSurname();
    String getEmail();
    String getPassword();
    boolean isSelected();
    
}
