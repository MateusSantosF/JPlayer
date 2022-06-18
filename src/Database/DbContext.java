package Database;

/**
 *
 * @author Mateus Santos
 */
public class DbContext {
    
    
    private long LAST_ID_TABLE_MUSIC = -1;
    private long LAST_ID_TABLE_PLAYLIST = -1;
    private long LAST_ID_TABLE_USER = -1;
    private static DbContext dbContext;
    
    private DbContext(){
        
    }
    
    private void mappingTables(){
        
    }
    
    public static DbContext getInstance(){
        if(dbContext == null){
            dbContext = new DbContext();
        }      
        return dbContext;
    }
    
    public void INCREMENT_ID_TABLE_MUSIC(){
        if(LAST_ID_TABLE_MUSIC < 0) mappingTables();
        LAST_ID_TABLE_MUSIC++;
    }
    
     public long GET_ID_TABLE_MUSIC(){
        return LAST_ID_TABLE_MUSIC;
    }
    
    public void INCREMENT_ID_TABLE_PLAYLIST(){
        if(LAST_ID_TABLE_PLAYLIST < 0) mappingTables();
        LAST_ID_TABLE_USER++;
    }
     public long GET_ID_TABLE_PLAYLIST(){
        return LAST_ID_TABLE_PLAYLIST;
    }
    
    public void INCREMENT_ID_TABLE_USER(){
        if(LAST_ID_TABLE_USER < 0) mappingTables();
        LAST_ID_TABLE_USER++;
    }
    
    public long GET_ID_TABLE_USER(){
        return LAST_ID_TABLE_USER;
    }
      

}
