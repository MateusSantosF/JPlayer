package Model;

import Model.interfaces.IUser;

/**
 *
 * @author mateus
 */
public class User implements IUser {
    
     private long Id;
     private String name;
     private String surname;
     private String email;
     private String password;
     private boolean selected;
     
     public User() {
         
    }
     
     public User(String name ,String surname, String email, String password){
        this.name  = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }
    
    public User(String[] atributes){
        this.Id = Long.valueOf(atributes[0]);
        this.name  = atributes[1];
        this.surname = atributes[2];
        this.email = atributes[3];
        this.password = atributes[4];
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
    
    @Override
    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
     @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
     @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return String.format("%d:{%s,%s,%s, %S}", this.getId(), this.getName(),this.getSurname(),this.getEmail(), this.getPassword());
    }

    

    
    
}
