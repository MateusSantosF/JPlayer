
package TableModel;

import facades.MusicFacade;
import java.awt.Checkbox;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;
import model.interfaces.IMusic;

/**
 *
 * @author mateus
 */
public class MusicTableModel extends AbstractTableModel {

    private final String[] columns = {"Title", "Author", "Album", "Duration"};
    private final MusicFacade facade = new MusicFacade();
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
    

    public void SearchMusicByName(String input){ 
        clearData();
        insertMusic(facade.GetAllMusics());
        List<IMusic> filtered = musics.stream().filter(
                music -> input.toLowerCase().contains(music.getTitle().toLowerCase())).collect(Collectors.toList());
        
        if(!filtered.isEmpty()){
            musics = filtered;
        }
        fireTableDataChanged();    
    }
    
    public void insertMusic(List<IMusic> newMusics){  
        musics.addAll(newMusics);
        removeDuplicateValues();
        fireTableDataChanged(); 
    }
    
    private void clearData(){
        musics.clear();
    }
    
    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
    return t -> seen.add(keyExtractor.apply(t));
}
    private void removeDuplicateValues(){
        musics = musics.stream().filter(distinctByKey(IMusic::getId)).collect(Collectors.toList());
        fireTableDataChanged();
    }
    
}
