/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.interfaces;

/**
 *
 * @author mateus
 */
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
