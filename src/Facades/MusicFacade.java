package Facades;

import DAO.DbContext;
import java.util.List;
import Model.interfaces.IMusic;


/**
 *
 * @author mateus
 */
public class MusicFacade {
    
    
    private final DbContext dbContext;
    
    public MusicFacade(){
        dbContext = DbContext.getInstance();
    }
   
    public List<IMusic> GetAllMusics(){
             
       return dbContext.Musics.ListAll();
    }
    
    public IMusic GetMusicById(long id){
        return dbContext.Musics.GetById(id);
    }
     
    public boolean insertMusic(IMusic music){
        return dbContext.Musics.Insert(music);
    }
}
