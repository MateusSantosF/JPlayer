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
    private final UserFacade facade = new UserFacade();
    private List<IUser> users;
    
     public SelectUserTableModel(){
        users = new ArrayList<>();
    }
     
     @Override
    public String getColumnName(int columnIndex){
             return columns[columnIndex];
        
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

        if ( columnIndex == 4 ) {
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
                return String.class;
            case 4:
                return Boolean.class;
            default:
                throw new AssertionError();
        }
    }


    @Override
    public int getRowCount() {
        return users.size();
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
                return users.get(row).getName();
            case 1:
                return users.get(row).getSurname();
            case 2:
                return users.get(row).getEmail();
            case 3:
                return users.get(row).getPassword();    
            case 4:
                return users.get(row).isSelected();
            default:
                return null;
        }
    }
       public void SearchUserByName(String input){ 
        clearData();
        insertUser(facade.GetAllUsers());
        List<IUser> filtered = users.stream().filter(
                user -> input.toLowerCase().contains(user.getName().toLowerCase())).collect(Collectors.toList());
        
        if(!filtered.isEmpty()){
            users = filtered;
        }
        fireTableDataChanged();    
    }
    
    
    public void insertUser(List<IUser> newUsers){  
        clearData();
        newUsers.forEach( m -> { m.setSelected(false); });
        this.users.addAll(newUsers);     
        fireTableDataChanged(); 
    }
    
     public void removeUser(List<IUser> users){
        this.users.removeAll(users);
        fireTableDataChanged(); 
    }
    
    
    private void clearData(){
        users.clear();
    }
    
     public List<IUser> GetAllSelected(){
        return users.stream().filter(user -> user.isSelected() == true).collect(Collectors.toList());
    }
    
}
