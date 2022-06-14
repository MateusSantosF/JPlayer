/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Music;

/**
 *
 * @author mateus
 */
public class MusicTableModel extends AbstractTableModel {

    private String[] columns = {"Title", "Author", "Album", "Duration"};
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
    
    public void insertMusic(List<Music> musics){
        this.musics.clear();
        this.musics.addAll(musics);     
        fireTableDataChanged(); 
    }
    
}
