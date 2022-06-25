package View.View.Playlist;

import View.Modal.ModalCreatePlaylist;
import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import Utils.Observer.interfaces.IObserver;
import Utils.Observer.interfaces.IPublisher;
import Facades.PlaylistFacade;
import java.util.Collections;
import Model.Comparators.PlaylistComparatorByDate;
import Model.interfaces.IPlaylist;
import View.View.Editions.Playlist.EditPlaylist;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JOptionPane;

/**
 *
 * @author mateus
 */
public class PlaylistContainer extends javax.swing.JPanel implements IPublisher, IObserver {
    
    private final List<IObserver> observers = new ArrayList<>();
    private final PlaylistFacade facade = new PlaylistFacade();
    private IPlaylist clickedPlaylist;
    private long playlistSize;  
    private boolean isEditOption = false;
    
    /**
     * Creates new form Playlist
     */
    public PlaylistContainer() {
        initComponents();
        ListAllPlayLists();
        jLabelConfirmDelete.setVisible(false);
    }
    
    private void resizeScroll(){
        
        int itemsPerColumn = (int) scrollContainer.getSize().getWidth() / 100;
        
        int gap = Math.round(playlistSize/itemsPerColumn) * 50;
        int newHeight = (Math.round(playlistSize/itemsPerColumn) * 100 )+ gap;
        
        if(newHeight % 2 != 0)
            newHeight += 150;
        
        int newWidth = itemsPerColumn * 100;
              
        jPanelPlaylists.setPreferredSize(new Dimension(  newWidth, newHeight));

    }
    
    private void ListAllPlayLists(){
        PlaylistContainer observer = this;
        jPanelPlaylists.removeAll();
        jPanelPlaylists.revalidate();
        jPanelPlaylists.repaint();
        List<JPanel> capas = new ArrayList<>();
        Dimension dimension = new Dimension(100, 100);
        List<IPlaylist> playlists = facade.getAllPlaylistHasNoTracking();
        Collections.sort(playlists, new PlaylistComparatorByDate()); // Sort to createData
      
        playlistSize = playlists.size();
            
        playlists.forEach(playlist ->{        
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            panel.setBackground(new Color(34,34,34));
            JButton button = new JButton(playlist.getTitle());
            button.setBackground(new Color(34,34,34));
            button.setBorderPainted(false);
           
          
            button.setContentAreaFilled(false);
            button.setForeground(Color.WHITE);
            button.setPreferredSize(dimension);
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evt){
                    if(!jLabelConfirmDelete.isVisible()){
                        clickedPlaylist = playlist;
                        notifyObservers();
                    }else{
                        
                        if(isEditOption){
                            
                            EditPlaylist modalEditPlaylist = new EditPlaylist(playlist);
                            modalEditPlaylist.addObserver(observer);
                            modalEditPlaylist.setVisible(true);
                            
                        }else{
                            int option = JOptionPane.showConfirmDialog(null, "Sure you want to Remove this playlist ?", "JPlayer", JOptionPane.OK_OPTION);

                           if(option == 0){
                               boolean result = facade.DeletePlaylist(playlist);

                               if(result){
                                   JOptionPane.showMessageDialog(null, "Playlist removed with success!");
                                   ListAllPlayLists();
                               }else{
                                   JOptionPane.showMessageDialog(null, "An error ocurred while delete playlist!");
                               }
                           } 
                        }
                      
                    }
                    
                 
                }
                @Override
                public void mouseEntered(MouseEvent evt){
                    setCursor(new Cursor(Cursor.HAND_CURSOR));
                    panel.setSize(104, 104);
                }
                
                @Override
                public void mouseExited(MouseEvent evt){
                    setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                     panel.setSize(100, 100);
                }
            });
            panel.add(button);
            capas.add(panel);
        });
        
        
        capas.forEach(item->{
            jPanelPlaylists.add(item);
        });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollContainer = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanelPlaylists = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabelCreateNewPlaylist = new javax.swing.JLabel();
        jLabelConfirmDelete = new javax.swing.JLabel();
        jLabelDeletePlaylist = new javax.swing.JLabel();
        jLabelEditPlaylist = new javax.swing.JLabel();

        scrollContainer.setBackground(new java.awt.Color(255, 255, 255));
        scrollContainer.setPreferredSize(new java.awt.Dimension(200, 200));
        scrollContainer.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                scrollContainerComponentResized(evt);
            }
        });
        scrollContainer.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(16, 6));

        jPanelPlaylists.setBackground(new java.awt.Color(244, 243, 243));
        jPanelPlaylists.setMinimumSize(new java.awt.Dimension(300, 200));
        jPanelPlaylists.setPreferredSize(new java.awt.Dimension(100, 500));
        jScrollPane2.setViewportView(jPanelPlaylists);

        scrollContainer.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(34, 34, 34));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(34, 34, 34));

        jLabelCreateNewPlaylist.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelCreateNewPlaylist.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCreateNewPlaylist.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCreateNewPlaylist.setText("New Playlist");
        jLabelCreateNewPlaylist.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabelCreateNewPlaylist.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelCreateNewPlaylist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCreateNewPlaylistMouseClicked(evt);
            }
        });

        jLabelConfirmDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelConfirmDelete.setForeground(new java.awt.Color(255, 255, 255));
        jLabelConfirmDelete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelConfirmDelete.setText("Confirm");
        jLabelConfirmDelete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabelConfirmDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelConfirmDelete.setEnabled(false);
        jLabelConfirmDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelConfirmDeleteMouseClicked(evt);
            }
        });

        jLabelDeletePlaylist.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelDeletePlaylist.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDeletePlaylist.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDeletePlaylist.setText("Delete");
        jLabelDeletePlaylist.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabelDeletePlaylist.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDeletePlaylist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDeletePlaylistMouseClicked(evt);
            }
        });

        jLabelEditPlaylist.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelEditPlaylist.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEditPlaylist.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEditPlaylist.setText("Edit");
        jLabelEditPlaylist.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabelEditPlaylist.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelEditPlaylist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEditPlaylistMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabelCreateNewPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jLabelEditPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelDeletePlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelConfirmDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelConfirmDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCreateNewPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDeletePlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEditPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void scrollContainerComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_scrollContainerComponentResized
         resizeScroll();
    }//GEN-LAST:event_scrollContainerComponentResized

    private void jLabelCreateNewPlaylistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCreateNewPlaylistMouseClicked

          
        ModalCreatePlaylist modal = new ModalCreatePlaylist();
        modal.addObserver(this);
        modal.setVisible(true);

    }//GEN-LAST:event_jLabelCreateNewPlaylistMouseClicked

    private void jLabelDeletePlaylistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeletePlaylistMouseClicked
        
        isEditOption = false;
        jLabelEditPlaylist.setVisible(false);
        if(!jLabelConfirmDelete.isEnabled()){
            jLabelDeletePlaylist.setVisible(false);
            jLabelConfirmDelete.setEnabled(true);
            jLabelConfirmDelete.setVisible(true);
        }else{
   
            jLabelConfirmDelete.setEnabled(false);
            jLabelConfirmDelete.setVisible(false);
             jLabelDeletePlaylist.setVisible(true);
        }

    }//GEN-LAST:event_jLabelDeletePlaylistMouseClicked

    private void jLabelConfirmDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelConfirmDeleteMouseClicked

        jLabelDeletePlaylist.setVisible(true);
        jLabelConfirmDelete.setVisible(false);
        jLabelConfirmDelete.setEnabled(false);
        jLabelEditPlaylist.setVisible(true);
    }//GEN-LAST:event_jLabelConfirmDeleteMouseClicked

    private void jLabelEditPlaylistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditPlaylistMouseClicked
      
        isEditOption = true;
        jLabelDeletePlaylist.setVisible(false);
        if(!jLabelConfirmDelete.isEnabled()){
            jLabelEditPlaylist.setVisible(false);
            jLabelConfirmDelete.setVisible(true);
            jLabelConfirmDelete.setEnabled(true);
        }
       
    }//GEN-LAST:event_jLabelEditPlaylistMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelConfirmDelete;
    private javax.swing.JLabel jLabelCreateNewPlaylist;
    private javax.swing.JLabel jLabelDeletePlaylist;
    private javax.swing.JLabel jLabelEditPlaylist;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelPlaylists;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel scrollContainer;
    // End of variables declaration//GEN-END:variables

    @Override
    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {

        observers.forEach(ob ->{
            ob.update(clickedPlaylist);
        });
       
    }

    @Override
    public void update(Object publisher) {

        if( publisher instanceof Boolean ){
            if( ((Boolean)publisher) ){ 
                ListAllPlayLists();
            }
        }
    }

}
