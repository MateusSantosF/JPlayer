package JPlayer.View;


import Utils.Observer.interfaces.IObserver;
import JPlayer.View.Music.MusicContainer;
import JPlayer.View.Playlist.PlaylistPanel;
import JPlayer.View.Playlist.PlaylistContainer;
import javax.swing.JOptionPane;
import Utils.JPanelManager;
import model.Playlist;
import model.interfaces.IPlaylist;


/**
 *
 * @author mateus
 */
public class Main extends javax.swing.JFrame implements IObserver {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPainel = new javax.swing.JPanel();
        LateralBar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButtonHome = new javax.swing.JButton();
        jButtonMusics = new javax.swing.JButton();
        jButtonPlaylists = new javax.swing.JButton();
        container = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 355));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        mainPainel.setLayout(new java.awt.BorderLayout());

        LateralBar.setBackground(new java.awt.Color(52, 52, 52));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("USERNAME");

        jButtonHome.setText("Home");
        jButtonHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHomeActionPerformed(evt);
            }
        });

        jButtonMusics.setText("Search Musics");
        jButtonMusics.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButtonMusicsMousePressed(evt);
            }
        });

        jButtonPlaylists.setText("Playlists");
        jButtonPlaylists.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlaylistsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LateralBarLayout = new javax.swing.GroupLayout(LateralBar);
        LateralBar.setLayout(LateralBarLayout);
        LateralBarLayout.setHorizontalGroup(
            LateralBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LateralBarLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(LateralBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButtonMusics, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonPlaylists, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        LateralBarLayout.setVerticalGroup(
            LateralBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LateralBarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jButtonHome, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonMusics, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonPlaylists, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
        );

        mainPainel.add(LateralBar, java.awt.BorderLayout.LINE_START);

        container.setLayout(new java.awt.BorderLayout());
        mainPainel.add(container, java.awt.BorderLayout.CENTER);

        getContentPane().add(mainPainel, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonHomeActionPerformed

    private void jButtonPlaylistsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPlaylistsActionPerformed
        PlaylistContainer playlistContainer = new PlaylistContainer();
        playlistContainer.addObserver(this);
        new JPanelManager(container, playlistContainer);
    }//GEN-LAST:event_jButtonPlaylistsActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int option = JOptionPane.showConfirmDialog(null, "Sure you want to leave?", "JPlayer", JOptionPane.OK_OPTION);
        
        if(option == 0){
            this.dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    private void jButtonMusicsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMusicsMousePressed
       
        new JPanelManager(container, new MusicContainer());
    }//GEN-LAST:event_jButtonMusicsMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LateralBar;
    private javax.swing.JPanel container;
    private javax.swing.JButton jButtonHome;
    private javax.swing.JButton jButtonMusics;
    private javax.swing.JButton jButtonPlaylists;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel mainPainel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Object publisher) {

        if( publisher instanceof IPlaylist){
            Playlist playlist = (Playlist) publisher;
            new JPanelManager(container, new PlaylistPanel(playlist));
        }
    }
}
