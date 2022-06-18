package facades;

import Database.DbContext;
import JPlayer.Mocks.MusicMock;
import java.util.List;
import model.interfaces.IMusic;


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
        return MusicMock.musicsList();
    }
    
     public List<IMusic> GetAllMusicsTwo(){
        return MusicMock.musicsListTwo();
    }
     
    public boolean insertMusic(IMusic music){
        return true;
    }
}
