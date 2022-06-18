
package TableModel;

import facades.MusicFacade;
import java.awt.Checkbox;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import model.Music;
import model.interfaces.IMusic;

/**
 *
 * @author mateus
 */
public class SelectMusicTableModel extends AbstractTableModel  {

    private final String[] columns = {"Title", "Author", "Album", "Duration", "Selected"};
    private final MusicFacade facade = new MusicFacade();
    private List<IMusic> musics;

    public SelectMusicTableModel(){
        musics = new ArrayList<>();
    }
    
    @Override
    public String getColumnName(int column){
        return columns[column];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

            if (columnIndex == 4) {
                musics.get(rowIndex).setSelected(Boolean.valueOf(aValue.toString()));             
                fireTableRowsUpdated(rowIndex, rowIndex);
                fireTableCellUpdated(rowIndex, columnIndex);
            }
    }
        
    @Override
    public Class<?> getColumnClass​(int columnIndex){
    
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return Boolean.class;
            default:
                throw new AssertionError();
        }
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
    public boolean isCellEditable(int row, int column) {
        return column == 4;
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
            case 4:
                return musics.get(row).isSelected();          
            default:
                return null;
        }
    }

    public void SearchMusicByName(String input){ 
        ClearData();
        insertMusic(facade.GetAllMusics());
        List<IMusic> filtered = musics.stream().filter(
                music -> input.toLowerCase().contains(music.getTitle().toLowerCase())).collect(Collectors.toList());
        
        if(!filtered.isEmpty()){
            musics = filtered;
        }
        fireTableDataChanged();    
    }
    
    public void insertMusic(List<IMusic> musics){
        this.musics.clear();
        this.musics.addAll(musics);     
        fireTableDataChanged(); 
    }
    
    public List<IMusic> GetAllSelected(){
        return musics.stream().filter(music -> music.isSelected() == true).collect(Collectors.toList());
    }
    
    private void ClearData(){
        musics.clear();
    }

    
}
