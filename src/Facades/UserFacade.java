package Facades;

import DAO.DbContext;
import java.util.List;
import Model.interfaces.IUser;

/**
 *
 * @author mateus
 */
public class UserFacade {
    
    private final DbContext dbContext;
    
    public UserFacade(){
        dbContext = DbContext.getInstance();
    }
    
    
    public List<IUser> GetAllUsers(){         
       return dbContext.Users.ListAll();
    }
    
    public IUser GetUserById(long id){
        return dbContext.Users.GetById(id);
    }
    
    public boolean insertUser(IUser user){
        return dbContext.Users.Insert(user);
    }
    
    public boolean removeUsersDb(List<IUser> currentUsers) {
        
        boolean result;
        int length = currentUsers.size();
        
        for(int i = 0; i < length; i++){
            result = dbContext.Users.Delete(currentUsers.get(i));
            if(!result){
                return false;
            }
        }
        result = dbContext.PlaylistUsers.DeleteMultiples(currentUsers);
        
        return result;
    }
    
    public boolean UpdateUser(IUser editedUser){
        return dbContext.Users.Update(editedUser);
    }
}
