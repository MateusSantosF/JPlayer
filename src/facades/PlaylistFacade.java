package facades;

import Database.DbContext;
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

    
    private final DbContext dbContext;
    
    public PlaylistFacade(){
        dbContext = DbContext.getInstance();
    }
    
    public List<IPlaylist> getAllPlaylistHasNoTracking(){
        return dbContext.Playlists.ListAllHasNoTracking();
    }
    
    public List<IPlaylist> getAllPlaylist(){
        return dbContext.Playlists.ListAll();
    }
    
    public IPlaylist getPlayList(IPlaylist playlist){
        return dbContext.Playlists.GetById(playlist.getId());
    }
    
    public boolean removeMusicsDb(IPlaylist playlist,  List<IMusic> musics){
        return  true;
    }
    
    public boolean updatePlaylistMusics(IPlaylist playlist, List<IMusic> musics){
        return dbContext.PlaylistMusics.Update(playlist, musics);
    }
    
    public boolean createPlaylist(IPlaylist playlist){
        return dbContext.Playlists.Insert(playlist);
    }
    
    public boolean insertMusics(IPlaylist currentPlaylist, List<IMusic> musics) {
        return true;
    }
    
    public List<IMusic> removeDuplicateMusics(List<IMusic> musics){
        return musics.stream().filter(distinctByKey(IMusic::getId)).collect(Collectors.toList());  
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
    return t -> seen.add(keyExtractor.apply(t));
    }

   
}
