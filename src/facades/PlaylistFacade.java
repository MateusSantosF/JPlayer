package facades;

import JPlayer.Mocks.PlaylistMock;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import model.interfaces.IMusic;
import model.interfaces.IPlaylist;


/**
 *
 * @author mateus
 */
public class PlaylistFacade {

    
    public List<IPlaylist> getAllPlaylist(){
        return PlaylistMock.playlistList();
    }
    
    public IPlaylist getPlayList(IPlaylist playlist){
        return playlist;
    }
    
    public boolean removeMusicsDb(IPlaylist playlist,  List<IMusic> musics){
        return  true;
    }
    
    public boolean insertMusicsDb(IPlaylist playlist, List<IMusic> musics){
        return true;
    }
    
    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
    return t -> seen.add(keyExtractor.apply(t));
}
    public List<IMusic> removeDuplicateMusics(List<IMusic> musics){
        return musics.stream().filter(distinctByKey(IMusic::getId)).collect(Collectors.toList());  
    }
}
