package facades;

import Database.DbContext;

/**
 *
 * @author mateus
 */
public class UserFacade {
    
    private final DbContext dbContext;
    
    public UserFacade(){
        dbContext = DbContext.getInstance();
    }
    
    
}
