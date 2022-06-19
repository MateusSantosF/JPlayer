package Database;

import Utils.TableReader;
import Utils.TableUnionReader;
import java.util.ArrayList;
import java.util.List;
import model.Music;
import model.Playlist;
import model.interfaces.IMusic;
import model.interfaces.IPlaylist;

/**
 *
 * @author Mateus Santos
 */
public class DbContext {
    
    
    private long LAST_ID_TABLE_MUSIC = -1;
    private long LAST_ID_TABLE_PLAYLIST = -1;
    private long LAST_ID_TABLE_USER = -1;
    private static DbContext dbContext;
    
    private DbUnion<IPlaylist, IMusic> PlaylistMusics = new DbUnion<IPlaylist, IMusic>() {
        
        TableUnionReader<IPlaylist, IMusic> reader;
        
        @Override
        public List<Long> ListAll(IPlaylist type) {
            reader = new TableUnionReader(type, new Music());         
            return reader.readTable();
        }

        @Override
        public boolean Insert(IPlaylist type, List<IMusic> childrens) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public boolean Update(IPlaylist type, List<IMusic> childrens) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        public IMusic GetById(long id) {
           return reader.readTable().stream().filter(music -> music.getId() == id).findAny().orElse(null);
        }

        @Override
        public boolean Insert(IMusic type) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public boolean Update(IMusic type) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public boolean Delete(IMusic type) {
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
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public boolean Update(IPlaylist type) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public boolean Delete(IPlaylist type) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    };

    public DbContext(Dbset<IPlaylist> Playlists) {
        this.Playlists = Playlists;
    }
        

    
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
