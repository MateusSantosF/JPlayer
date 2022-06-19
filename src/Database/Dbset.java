/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.util.List;

/**
 *
 * @author mateus
 * @param <T>
 */
public abstract class Dbset <T>{
    
    public abstract List<T> ListAll();
    
    public abstract List<T> ListAllHasNoTracking();
    
    public abstract T GetById(long id);
    
    public abstract boolean Insert(T type);
    
    public abstract boolean Update(T type);
    
    public abstract boolean Delete(T type);
    
}
