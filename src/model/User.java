package model;

import model.interfaces.IUser;

/**
 *
 * @author mateus
 */
public class User implements IUser {
    
     private long Id;
     private String name;
     private String email;
     private String password;
     private boolean selected;
     
     public User() {
         
    }
     
     public User(String name, String email, String password){
        this.name  = name;
        this.email = email;
        this.password = password;
    }
    
    public User(String[] atributes){
        this.Id = Long.valueOf(atributes[0]);
        this.name  = atributes[1];
        this.email = atributes[2];
        this.password = atributes[3];
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

    public void setName(String name) {
        this.name = name;
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
        return email;
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
        return String.format("%d:{%s,%s,%s}", this.getId(), this.getName(),this.getEmail(), this.getPassword());
    }

    
    
}
