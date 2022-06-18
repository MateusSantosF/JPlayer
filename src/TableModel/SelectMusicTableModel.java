
package TableModel;

import facades.MusicFacade;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;
import model.interfaces.IMusic;

/**
 *
 * @author mateus
 */
public class SelectMusicTableModel extends AbstractTableModel  {

    private final String[] columns = {"Title", "Author", "Duration", "Selected"};
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

        if (columnIndex == 3) {
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
        return column == 3;
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
            case 3:
                return musics.get(row).isSelected();          
            default:
                return null;
        }
    }

    public void SearchMusicByName(String input){ 
        clearData();
        insertMusic(facade.GetAllMusicsTwo());
        List<IMusic> filtered = musics.stream().filter(
                music -> input.toLowerCase().contains(music.getName().toLowerCase())).collect(Collectors.toList());
        
        if(!filtered.isEmpty()){
            musics = filtered;
        }
        fireTableDataChanged();    
    }
    
    public void insertMusic(List<IMusic> musics){
        clearData();
        musics.forEach( m -> { m.setSelected(false); });
        this.musics.addAll(musics);     
        fireTableDataChanged(); 
    }
    
    public void removeMusic(List<IMusic> musics){
        this.musics.removeAll(musics);
        fireTableDataChanged(); 
    }
    
    public List<IMusic> GetAllSelected(){
        return musics.stream().filter(music -> music.isSelected() == true).collect(Collectors.toList());
    }
    
    private void clearData(){
        musics.clear();
    }

    
}
