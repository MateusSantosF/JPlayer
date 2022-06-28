/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableModel;

import Facades.UserFacade;
import Model.interfaces.IUser;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author User
 */
public class SelectUserTableModel extends AbstractTableModel {

    private final String[] columns = {"Name", "Surname", "Email", "Password", "Selected"};
    private final UserFacade userFacade = new UserFacade();
    private List<IUser> users;
    
     public SelectUserTableModel(){
        users = new ArrayList<>();
    }
    

    @Override
    public int getRowCount() {
        return users.size();
    }
    
    @Override
    public String getColumnName(int columnIndex){
             return columns[columnIndex];
        
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

        if ( columnIndex == 3 ) {
            users.get(rowIndex).setSelected(Boolean.valueOf(aValue.toString()));             
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
            case 4:
                return Boolean.class;
            default:
                throw new AssertionError();
        }
    }

    @Override
    public int getColumnCount() {
           return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch (columnIndex) {
            case 0:
                return users.get(rowIndex).getName();
            case 1:
                return users.get(rowIndex).getSurname();
            case 2:
                return users.get(rowIndex).getEmail();
            case 3:
                if(!users.get(rowIndex).isSelected()){
                    
                    return "Offline";
                }else {
                    return "Online";
                }
            
            default:
                return null;
        }
    }
    
    public void insertUser(List<IUser> newUsers){  
        users.addAll(newUsers);
        fireTableDataChanged(); 
    }
    
     public void removeUser(List<IUser> musics){
        this.users.removeAll(musics);
        fireTableDataChanged(); 
    }
    
    public void insertWithRemove(List<IUser> newUsers){
        clearData();
        users.addAll(newUsers);
        fireTableDataChanged(); 
    }
    
    private void clearData(){
        users.clear();
    }
    
     public List<IUser> GetAllSelected(){
        return users.stream().filter(music -> music.isSelected() == true).collect(Collectors.toList());
    }
    
    
    public void SearchUserByName(String input){ 
        clearData();
        insertUser(userFacade.GetAllUsers());
        List<IUser> filtered = users.stream().filter(
                user -> input.toLowerCase().contains(user.getName().toLowerCase())).collect(Collectors.toList());
        
        if(!filtered.isEmpty()){
            users = filtered;
        }
        fireTableDataChanged();    
    }
    
}
