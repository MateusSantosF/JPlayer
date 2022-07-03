
package TableModel;

import Facades.MusicFacade;
import Facades.PlaylistFacade;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;
import Model.interfaces.IMusic;

public class MusicTableModel extends AbstractTableModel {

    private final String[] columns = {"Title", "Author", "Duration"};
    private final MusicFacade musicFacade = new MusicFacade();
    private final PlaylistFacade playlistFacade = new PlaylistFacade();
    private List<IMusic> musics;

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
                return musics.get(row).getName();
            case 1:
                return musics.get(row).getAuthor();
            case 2:
                return musics.get(row).getDuration();
            default:
                return null;
        }
    }
    

    public void SearchMusicByName(String input){ 
        clearData();
        insertMusic(musicFacade.GetAllMusics());
        List<IMusic> filtered = musics.stream().filter(
                music -> input.toLowerCase().contains(music.getName().toLowerCase())).collect(Collectors.toList());
        
        if(!filtered.isEmpty()){
            musics = filtered;
        }
        fireTableDataChanged();    
    }
    
    public void insertMusic(List<IMusic> newMusics){  
        musics.addAll(newMusics);
        musics = playlistFacade.removeDuplicateMusics(musics);
        fireTableDataChanged(); 
    }
    
    public void insertWithRemove(List<IMusic> newMusics){
        clearData();
        musics.addAll(newMusics);
        fireTableDataChanged(); 
    }
    
    private void clearData(){
        musics.clear();
    }
    
    public List<IMusic> getData(){
        return musics;
    }
    
    public IMusic getData(int rowIndex){
        return musics.get(rowIndex);
    }
    
 
    
}
