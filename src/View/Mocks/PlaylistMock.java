
package View.Mocks;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import Model.Playlist;
import Model.interfaces.IPlaylist;


public class PlaylistMock {
    
    public static List<IPlaylist> playlistList(){
         List<IPlaylist> list = new ArrayList<>();
        
        for (int i = 0; i < 25; i++) {
            IPlaylist current = new Playlist(MusicMock.musicsList(), "Playlist"+i, "Any description"+i);
            current.setCreateData(LocalDate.of(2022, Month.MARCH, 2));
            list.add(current);
        }
        
        return list;        
    }
}
