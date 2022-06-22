package Database;

import Utils.TableReader;
import Utils.TableUnionReader;
import Utils.TableUnionWriter;
import Utils.TableWriter;
import java.util.ArrayList;
import java.util.List;
import model.Music;
import model.Playlist;
import model.User;
import model.interfaces.IMusic;
import model.interfaces.IPlaylist;
import model.interfaces.IUser;


/**
 *
 * @author Mateus Santos
 */
public class DbContext {
    
    
    private long LAST_ID_TABLE_MUSIC = -1;
    private long LAST_ID_TABLE_PLAYLIST = -1;
    private long LAST_ID_TABLE_USER = -1;
    private static DbContext dbContext;
    
    public DbUnion<IPlaylist, IMusic> PlaylistMusics = new DbUnion<IPlaylist, IMusic>() {
        
        TableUnionReader<IPlaylist, IMusic> reader = new TableUnionReader(new Playlist(), new Music());
       
        
        @Override
        public List<Long> ListAll(IPlaylist type) {       
            return reader.readTable();
        }

        @Override
        public boolean Insert(IPlaylist type, List<IMusic> childrens) {
           TableUnionWriter<IPlaylist, IMusic> writer = new TableUnionWriter(type, new Music());
           return writer.writeInTable(childrens);
        }

        @Override
        public boolean Update(IPlaylist type, List<IMusic> childrens) {
           TableUnionWriter<IPlaylist, IMusic> writer = new TableUnionWriter(type, new Music());
           return writer.UpdateRegister(type.getId(), childrens);
        }

        @Override
        public boolean Delete(IPlaylist type, List<IMusic> childrens) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    };
        
    public Dbset<IMusic> Musics = new Dbset<IMusic>() {
        
        TableReader<IMusic> reader = new TableReader<>(new Music());
        
        @Override
        public List<IMusic> ListAll() {
            return reader.readTable();
        }
        
        @Override
        public List<IMusic> ListAllHasNoTracking() {
            return reader.readTable();
        }
       
        @Override
        public IMusic GetById(long id) {
           return reader.readTable().stream().filter(music -> music.getId() == id).findAny().orElse(null);
        }

        @Override
        public boolean Insert(IMusic type) {
            type.setId(getLastIdTableMusic());
            TableWriter<IMusic> writer = new TableWriter(type);
            return writer.writeInTable(type);
        }

        @Override
        public boolean Update(IMusic type) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public boolean Delete(IMusic type) {
            
            //TODO dont forget clear TABLE_ID variables 
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    };
    
    public Dbset<IPlaylist> Playlists = new Dbset<IPlaylist>() {
        
        TableReader<IPlaylist> reader = new TableReader<>(new Playlist());
        
        
        @Override
        public List<IPlaylist> ListAll() {
            List<IPlaylist> list = reader.readTable();
                    
            list.forEach( playlist ->{
                List<IMusic> currentPlayListMusics = new ArrayList<>();
                
                PlaylistMusics.ListAll(playlist).forEach(id -> {
                    currentPlayListMusics.add(Musics.GetById(id));
                });
                playlist.addMusics(currentPlayListMusics);
            } );
            
            return list;
        }
        
        @Override
        public List<IPlaylist> ListAllHasNoTracking() {
            return reader.readTable();
        }

        @Override
        public IPlaylist GetById(long id) {
            IPlaylist result = reader.readTable().stream().filter( playlist -> playlist.getId() == id).findAny().orElse(null);
            List<IMusic> currentPlayListMusics = new ArrayList<>();
            
            PlaylistMusics.ListAll(result).forEach(idPlaylist -> {
                    currentPlayListMusics.add(Musics.GetById(idPlaylist));
             });
            result.addMusics(currentPlayListMusics);
         
            return result;
        }

        @Override
        public boolean Insert(IPlaylist type) {
            type.setId(getLastIdTablePlaylist());
            TableWriter<IPlaylist> writer = new TableWriter(type);         
            return writer.writeInTable(type);
        }

        @Override
        public boolean Update(IPlaylist type) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public boolean Delete(IPlaylist type) {
              //TODO dont forget clear TABLE_ID variables 
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
  
    };
    
    public Dbset<IUser> Users = new Dbset<IUser>(){
        
        TableReader<IUser> reader = new TableReader<>(new User());
        
        @Override
        public List<IUser> ListAll() {
            
             return reader.readTable();
        }

        @Override
        public List<IUser> ListAllHasNoTracking() {
            
            return reader.readTable();
        }

        @Override
        public IUser GetById(long id) {
            return reader.readTable().stream().filter(User -> User.getId() == id).findAny().orElse(null);

        }

        @Override
        public boolean Insert(IUser type) {
            
            type.setId(getLastIdTableUser());
            TableWriter<IUser> writer = new TableWriter(type);         
            return writer.writeInTable(type);
        }

        @Override
        public boolean Update(IUser type) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean Delete(IUser type) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    };
    private DbContext(){
        
    }
    
    public static DbContext getInstance(){
        if(dbContext == null){
            dbContext = new DbContext();
        }      
        return dbContext;
    }
    
    private long getLastIdTableMusic(){
        if(LAST_ID_TABLE_MUSIC < 0) mappingTables();
        return ++LAST_ID_TABLE_MUSIC;
    }
    
    private long getLastIdTablePlaylist(){
        if(LAST_ID_TABLE_PLAYLIST < 0) mappingTables();
        return ++LAST_ID_TABLE_PLAYLIST;
    }
    
    private long getLastIdTableUser(){
        if(LAST_ID_TABLE_USER < 0) mappingTables();
        return ++LAST_ID_TABLE_USER;
    }
   
        
    private void mappingTables(){
        
        TableReader<IMusic> musicTableReader = new TableReader<>(new Music());
        TableReader<IPlaylist> playListTableReader = new TableReader<>(new Playlist());
        
        LAST_ID_TABLE_PLAYLIST = playListTableReader.getLastIdInTable();      
        LAST_ID_TABLE_MUSIC = musicTableReader.getLastIdInTable();

    }
}
