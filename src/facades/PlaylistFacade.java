package facades;

import JPlayer.Mocks.PlaylistMock;
import java.util.List;
import model.interfaces.IPlaylist;


/**
 *
 * @author mateus
 */
public class PlaylistFacade {

    
    public List<IPlaylist> getAllPlaylist(){
        return PlaylistMock.playlistList();
    }
}
