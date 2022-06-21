package facades;

import Database.DbContext;
import java.util.List;
import model.interfaces.IUser;

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
    
}
