/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package JPlayer.View.Playlist;

import Utils.Observer.interfaces.IObserver;
import JPlayer.Modal.ModalAddMusic;
import TableModel.MusicTableModel;
import TableModel.SelectMusicTableModel;
import facades.PlaylistFacade;
import java.util.List;
import javax.swing.JOptionPane;
import model.Playlist;
import model.interfaces.IMusic;
import model.interfaces.IPlaylist;

/**
 *
 * @author mateus
 */
public class PlaylistPanel extends javax.swing.JPanel implements IObserver {
    
    private  MusicTableModel model = new MusicTableModel();
    private  SelectMusicTableModel deleteModel = new SelectMusicTableModel();
    private final PlaylistFacade playlistFacade = new PlaylistFacade();
    private IPlaylist currentPlaylist;
    /**
     * Creates new form Playlist
     * @param playlist
     */
    public PlaylistPanel(IPlaylist playlist) {
        initComponents();
        
        currentPlaylist = (Playlist) playlist;
  
        jLabelTitle.setText(currentPlaylist.getTitle());
        jTextAreaDescription.setText(currentPlaylist.getDescription());
        model.insertMusic(currentPlaylist.getMusics());
        jTableMusic.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescription = new javax.swing.JTextArea();
        jLabelAddSongs = new javax.swing.JLabel();
        jLabelConfirmRemove = new javax.swing.JLabel();
        jLabelRemoveSongs = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableMusic = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(34, 34, 34));

        jLabelTitle.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("PLAYLIST TITLE");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextAreaDescription.setEditable(false);
        jTextAreaDescription.setBackground(new java.awt.Color(34, 34, 34));
        jTextAreaDescription.setColumns(20);
        jTextAreaDescription.setForeground(new java.awt.Color(255, 255, 255));
        jTextAreaDescription.setRows(5);
        jTextAreaDescription.setWrapStyleWord(true);
        jTextAreaDescription.setBorder(null);
        jScrollPane1.setViewportView(jTextAreaDescription);

        jLabelAddSongs.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelAddSongs.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAddSongs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddSongs.setText("Add songs");
        jLabelAddSongs.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabelAddSongs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAddSongs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAddSongsMouseClicked(evt);
            }
        });

        jLabelConfirmRemove.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelConfirmRemove.setForeground(new java.awt.Color(255, 255, 255));
        jLabelConfirmRemove.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelConfirmRemove.setText("Confirm");
        jLabelConfirmRemove.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabelConfirmRemove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelConfirmRemove.setEnabled(false);
        jLabelConfirmRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelConfirmRemoveMouseClicked(evt);
            }
        });

        jLabelRemoveSongs.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelRemoveSongs.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRemoveSongs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRemoveSongs.setText("Remove");
        jLabelRemoveSongs.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabelRemoveSongs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelRemoveSongs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRemoveSongsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelAddSongs, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabelRemoveSongs, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelConfirmRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE))
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAddSongs, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelConfirmRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRemoveSongs, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jTableMusic.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTableMusic);

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelAddSongsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddSongsMouseClicked
        
        ModalAddMusic modal = new ModalAddMusic();
        modal.addObserver(this);
        modal.setVisible(true);
    }//GEN-LAST:event_jLabelAddSongsMouseClicked

    private void jLabelConfirmRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelConfirmRemoveMouseClicked
       
        int option = JOptionPane.showConfirmDialog(null, "Sure you want to Remove songs this playlist ?", "JPlayer", JOptionPane.OK_OPTION);
        
        if(option == 0){
           
            List<IMusic> selecteds = deleteModel.GetAllSelected();
            boolean result =  playlistFacade.removeMusicsDb(currentPlaylist, selecteds); 
            currentPlaylist.getMusics().removeAll(selecteds); // remove visually
            model.insertWithRemove(currentPlaylist.getMusics());  // alter visually
            if(!result){
                JOptionPane.showMessageDialog(null, "An error occurred while trying to delete the selected songs. Try again");
                return;
            }
            deleteModel.removeMusic(selecteds); //remove visually
        }
        jLabelConfirmRemove.setEnabled(false);
        jTableMusic.setModel(model);
    }//GEN-LAST:event_jLabelConfirmRemoveMouseClicked

    private void jLabelRemoveSongsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRemoveSongsMouseClicked
        
        if(jLabelConfirmRemove.isEnabled()){
          jTableMusic.setModel(model);
          jLabelConfirmRemove.setEnabled(false);
          return;
        }
        
        jLabelConfirmRemove.setEnabled(!jLabelConfirmRemove.isEnabled());
        deleteModel.insertMusic(playlistFacade.getPlayList(currentPlaylist).getMusics());
        jTableMusic.setModel(deleteModel);
    }//GEN-LAST:event_jLabelRemoveSongsMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelAddSongs;
    private javax.swing.JLabel jLabelConfirmRemove;
    private javax.swing.JLabel jLabelRemoveSongs;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableMusic;
    private javax.swing.JTextArea jTextAreaDescription;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Object publisher) {
        IPlaylist backup = currentPlaylist;
        if( publisher instanceof List){
            
            List<IMusic> musics = (List<IMusic>) publisher;         
            currentPlaylist.getMusics().addAll(musics);
            playlistFacade.removeDuplicateMusics(currentPlaylist.getMusics());
            
            boolean response = playlistFacade.insertMusicsInPlaylist(currentPlaylist, musics);
            
            if(!response){
                JOptionPane.showMessageDialog(null, "An error occurred while trying to insert the selected songs. Try Again");
                currentPlaylist = backup;
                return;
            }
            model.insertMusic(currentPlaylist.getMusics());
            jTableMusic.setModel(model);
        }
    }
}
