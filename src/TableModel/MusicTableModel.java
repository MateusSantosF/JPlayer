
package TableModel;

import facades.MusicFacade;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;
import model.Music;

/**
 *
 * @author mateus
 */
public class MusicTableModel extends AbstractTableModel {

    private final String[] columns = {"Title", "Author", "Album", "Duration"};
    private final MusicFacade facade = new MusicFacade();
    private List<Music> musics;

    public MusicTableModel(){
        musics = new ArrayList<>();
    }
    
    @Override
    public String getColumnName(int column){
        return columns[column];
    }
    
    @Override
    public int getRowCount() {
        return musics.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }      

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return musics.get(row).getTitle();
            case 1:
                return musics.get(row).getAuthor();
            case 2:
                return musics.get(row).getAlbum();
            case 3:
                return musics.get(row).getDuration();
            default:
                return null;
        }
    }
    
    public void insertMusic(Music music){
        musics.add(music);
    }
    
    public void SearchMusicByName(String input){ 
        ClearData();
        insertMusic(facade.GetAllMusics());
        List<Music> filtered = musics.stream().filter(
                music -> input.toLowerCase().contains(music.getTitle().toLowerCase())).collect(Collectors.toList());
        
        if(!filtered.isEmpty()){
            musics = filtered;
        }
        fireTableDataChanged();    
    }
    
    public void insertMusic(List<Music> musics){
        this.musics.clear();
        this.musics.addAll(musics);     
        fireTableDataChanged(); 
    }
    
    private void ClearData(){
        musics.clear();
    }
    
}
