package Facades;

import DAO.DbContext;
import Model.interfaces.IPlaylist;
import java.util.List;
import Model.interfaces.IUser;
import java.util.stream.Collectors;

/**
 *
 * @author mateus
 */
public class UserFacade {
    
    private final DbContext dbContext;
    private final PlaylistFacade playlistFacade;
    
    public UserFacade(){
        dbContext = DbContext.getInstance();
        playlistFacade = new PlaylistFacade();
    }
    
    
    public List<IUser> GetAllUsers(){         
       return dbContext.Users.ListAll();
    }
    
    public IUser GetUserById(long id){
        return dbContext.Users.GetById(id);
    }
    
    public Long GetIdCurrentUser(){
        return dbContext.CURRENT_USER.getId();
    }
    
    public boolean insertUser(IUser user){
        return dbContext.Users.Insert(user);
    }
    
    public boolean removeUsersDb(List<IUser> currentUsers) {
        
        boolean result = false;
        int length = currentUsers.size();
        
        for(int i = 0; i < length; i++){
            result = dbContext.Users.Delete(currentUsers.get(i));
            if(!result){
                return false;
            }
        }
        List<IPlaylist> playlists =  dbContext.Playlists.ListAllHasNoTracking();
        List<Long> userPlaylists = dbContext.UserPlaylist.ListAll(dbContext.CURRENT_USER);
        
        //Deleting playlist for current deleted user 
        if(!userPlaylists.isEmpty()){
            result = dbContext.UserPlaylist.DeleteMultiples( playlists.stream().filter( playlist ->
            userPlaylists.contains(playlist.getId())).collect(Collectors.toList())); 
        }
    
        
        return result;
    }
    
    public boolean UpdateUser(IUser editedUser){
        return dbContext.Users.Update(editedUser);
    }
}
