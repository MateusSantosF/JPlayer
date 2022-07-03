package DAO;

import java.util.ArrayList;
import java.util.List;
import Model.Music;
import Model.Playlist;
import Model.User;
import Model.interfaces.IMusic;
import Model.interfaces.IPlaylist;
import Model.interfaces.IUser;
import Utils.Constants;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

public class DbContext {

    private long LAST_ID_TABLE_MUSIC = -1;
    private long LAST_ID_TABLE_PLAYLIST = -1;
    private long LAST_ID_TABLE_USER = -1;
    public IUser CURRENT_USER;

    private static DbContext dbContext;

    /**
     * Relaciona playlists com Músicas
     */
    public DbUnion<IPlaylist, IMusic> PlaylistMusics = new DbUnion<IPlaylist, IMusic>() {

        @Override
        public List<Long> ListAll(IPlaylist type) {
            TableUnionReader<IPlaylist, IMusic> reader = new TableUnionReader(type, new Music());
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
            TableUnionWriter<IPlaylist, IMusic> writer = new TableUnionWriter(type, new Music());
            return writer.DeleteOneRegister(type.getId(), childrens);
        }

        @Override
        public boolean DeleteMultiples(List<IMusic> childrens) {
            TableUnionWriter<IPlaylist, IMusic> writer = new TableUnionWriter(new Playlist(), new Music());
            return writer.DeleteMultiplesRegisters(childrens);
        }
    };

    /**
     * Responsável exclusivamente pela entidade Musica
     */
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
            TableWriter<IMusic> writer = new TableWriter(type);
            return writer.UpdateRegister(type);
        }

        @Override
        public boolean Delete(IMusic type) {

            TableWriter<IMusic> writer = new TableWriter(type);
            boolean result = writer.DeleteRegister(type);

            if (result) {
                LAST_ID_TABLE_MUSIC = -1;
                return true;
            }
            return false;
        }
    };

    /**
     * Responsável exclusivamente pela entidade Playlist
     */
    public Dbset<IPlaylist> Playlists = new Dbset<IPlaylist>() {

        TableReader<IPlaylist> reader = new TableReader<>(new Playlist());

        @Override
        public List<IPlaylist> ListAll() {
            List<IPlaylist> list = reader.readTable();

            list.forEach(playlist -> {
                List<IMusic> currentPlayListMusics = new ArrayList<>();

                PlaylistMusics.ListAll(playlist).forEach(id -> {
                    currentPlayListMusics.add(Musics.GetById(id));
                });
                playlist.addMusics(currentPlayListMusics);
            });

            return list;
        }

        @Override
        public List<IPlaylist> ListAllHasNoTracking() {
            return reader.readTable();
        }

        @Override
        public IPlaylist GetById(long id) {
            IPlaylist result = reader.readTable().stream().filter(playlist -> playlist.getId() == id).findAny().orElse(null);
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
            TableWriter<IPlaylist> writer = new TableWriter(type);
            return writer.UpdateRegister(type);
        }

        @Override
        public boolean Delete(IPlaylist type) {

            TableWriter<IPlaylist> writer = new TableWriter(type);
            boolean result = writer.DeleteRegister(type);

            if (result) {
                LAST_ID_TABLE_PLAYLIST = -1;
                return true;
            }
            return false;
        }

    };

    /**
     * Responsável exclusivamente pela entidade Usuário
     */
    public Dbset<IUser> Users = new Dbset<IUser>() {

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
            TableWriter<IUser> writer = new TableWriter(type);
            return writer.UpdateRegister(type);
        }

        @Override
        public boolean Delete(IUser type) {

            TableWriter<IUser> writer = new TableWriter(type);
            boolean result = writer.DeleteRegister(type);

            if (result) {
                LAST_ID_TABLE_USER = -1;
                return true;
            }
            return false;
        }

    };

    /**
     * Relaciona a PLAYLIST com o USUARIO
     */
    public DbUnion<IPlaylist, IUser> PlaylistUsers = new DbUnion<IPlaylist, IUser>() {

        @Override
        public List<Long> ListAll(IPlaylist type) {
            TableUnionReader<IPlaylist, IUser> reader = new TableUnionReader(type, new User());
            return reader.readTable();
        }

        @Override
        public boolean Insert(IPlaylist type, List<IUser> childrens) {
            TableUnionWriter<IPlaylist, IUser> writer = new TableUnionWriter(type, new User());
            return writer.writeInTable(childrens);
        }

        @Override
        public boolean Update(IPlaylist type, List<IUser> childrens) {
            TableUnionWriter<IPlaylist, IUser> writer = new TableUnionWriter(type, new User());
            return writer.UpdateRegister(type.getId(), childrens);
        }

        @Override
        public boolean Delete(IPlaylist type, List<IUser> childrens) {
            TableUnionWriter<IPlaylist, IUser> writer = new TableUnionWriter(type, new User());
            return writer.DeleteOneRegister(type.getId(), childrens);
        }

        @Override
        public boolean DeleteMultiples(List<IUser> childrens) {
            TableUnionWriter<IPlaylist, IUser> writer = new TableUnionWriter(new Playlist(), new User());
            return writer.DeleteMultiplesRegisters(childrens);
        }

    };

    /**
     * Relaciona os Usuários com Playlists
     */
    public DbUnion<IUser, IPlaylist> UserPlaylist = new DbUnion<IUser, IPlaylist>() {
        @Override
        public List<Long> ListAll(IUser type) {
            TableUnionReader<IUser, IPlaylist> reader = new TableUnionReader(type, new Playlist());
            return reader.readTable();
        }

        @Override
        public boolean Insert(IUser type, List<IPlaylist> childrens) {
            TableUnionWriter<IUser, IPlaylist> writer = new TableUnionWriter(type, new Playlist());
            TableUnionReader<IUser, IPlaylist> reader = new TableUnionReader(type, new Playlist());

            List<Long> playlistIdsCurrentUser = reader.readTable();

            if (playlistIdsCurrentUser.isEmpty()) {
                return writer.writeInTable(childrens);
            }

            return Update(type, childrens);
        }

        @Override
        public boolean Update(IUser type, List<IPlaylist> childrens) {
            TableUnionWriter<IUser, IPlaylist> writer = new TableUnionWriter(type, new Playlist());
            return writer.UpdateRegister(type.getId(), childrens);
        }

        @Override
        public boolean Delete(IUser type, List<IPlaylist> childrens) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public boolean DeleteMultiples(List<IPlaylist> childrens) {
            TableUnionWriter<IPlaylist, IPlaylist> writer = new TableUnionWriter(new Playlist(), new Playlist());
            return writer.DeleteMultiplesRegisters(childrens);
        }
    };

    public static DbContext getInstance() {
        if (dbContext == null) {
            dbContext = new DbContext();

        }
        return dbContext;
    }

    private DbContext() {
        createTablesIfNotExists();
    }

    private void createTablesIfNotExists() {

        File userTable = new File(Constants.USER_TABLE);
        File playlistTable = new File(Constants.PLAYLIST_TABLE);
        File musicTable = new File(Constants.MUSIC_TABLE);
        File userPlaylistTable = new File(Constants.USER_PLAYLIST_TABLE);
        File playlistMusicsTable = new File(Constants.PLAYLIST_MUSIC_TABLE);

        try {
            userTable.createNewFile();
            playlistTable.createNewFile();
            musicTable.createNewFile();
            userPlaylistTable.createNewFile();
            playlistMusicsTable.createNewFile();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error in create database files");
        }

    }

    private long getLastIdTableMusic() {
        if (LAST_ID_TABLE_MUSIC < 0) {
            mappingTables();
        }
        return ++LAST_ID_TABLE_MUSIC;
    }

    private long getLastIdTablePlaylist() {
        if (LAST_ID_TABLE_PLAYLIST < 0) {
            mappingTables();
        }
        return ++LAST_ID_TABLE_PLAYLIST;
    }

    private long getLastIdTableUser() {
        if (LAST_ID_TABLE_USER < 0) {
            mappingTables();
        }
        return ++LAST_ID_TABLE_USER;
    }

    private void mappingTables() {

        TableReader<IMusic> musicTableReader = new TableReader<>(new Music());
        TableReader<IPlaylist> playListTableReader = new TableReader<>(new Playlist());
        TableReader<IUser> userTableReader = new TableReader<>(new User());

        LAST_ID_TABLE_PLAYLIST = playListTableReader.getLastIdInTable();
        LAST_ID_TABLE_MUSIC = musicTableReader.getLastIdInTable();
        LAST_ID_TABLE_USER = userTableReader.getLastIdInTable();
    }
}
