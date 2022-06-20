/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JPlayer.Mocks;

import java.util.ArrayList;
import java.util.List;
import model.User;
import model.interfaces.IUser;

/**
 *
 * @author User
 */
public class UserMock {
    
     public static List<IUser> userList(){
         List<IUser> list = new ArrayList<>();
         
         for (int i = 0; i < 5; i++) {
            User current = new User();
            current.setSelected(false);
            current.setId(i);
            current.setName("User"+i);
            current.setEmail("random@.com"+i);
            current.setPassword("SafePassword"+i);
            list.add(current);
        }
         
         
         return list;
     }
     
    
}
