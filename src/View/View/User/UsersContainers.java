package View.View.User;

import Facades.UserFacade;
import Model.interfaces.IUser;
import TableModel.SelectUserTableModel;
import TableModel.UserTableModel;
import Utils.Observer.interfaces.IObserver;
import View.View.Editions.User.EditUsers;
import View.View.Records.SignIn;
import java.awt.Window;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class UsersContainers extends javax.swing.JPanel implements IObserver {

    /**
     * Creates new form MusicContainer
     */
    private UserTableModel model = new UserTableModel();
    private SelectUserTableModel removeModel = new SelectUserTableModel();
    private final UserFacade facade = new UserFacade();

    public UsersContainers() {
        initComponents();
        listAllUsersInDatabase();
        jLabelConfirmRemove.setVisible(false);
    }

    private void listAllUsersInDatabase() {

        model.insertWithRemove(facade.GetAllUsers());
        jTableMusics.setModel(model);
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
        jTextFieldSearchBar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMusics = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabelRemoveSongs = new javax.swing.JLabel();
        jLabelConfirmRemove = new javax.swing.JLabel();
        jLabelRemoveSongs1 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(35, 35, 35));

        jTextFieldSearchBar.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextFieldSearchBarCaretUpdate(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Search");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldSearchBar, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE))
                .addGap(41, 41, 41))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(244, 243, 243));

        jTableMusics.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableMusics);

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel2.setText("Users");

        jLabelRemoveSongs.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelRemoveSongs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRemoveSongs.setText("Delete");
        jLabelRemoveSongs.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabelRemoveSongs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelRemoveSongs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRemoveSongsMouseClicked(evt);
            }
        });

        jLabelConfirmRemove.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
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

        jLabelRemoveSongs1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelRemoveSongs1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRemoveSongs1.setText("Edit");
        jLabelRemoveSongs1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabelRemoveSongs1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelRemoveSongs1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRemoveSongs1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabelRemoveSongs1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)
                                .addComponent(jLabelRemoveSongs, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelConfirmRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE))
                        .addGap(26, 26, 26))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelConfirmRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRemoveSongs1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRemoveSongs, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldSearchBarCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextFieldSearchBarCaretUpdate
        model.SearchUserByName(jTextFieldSearchBar.getText());
        jTableMusics.setModel(model);
    }//GEN-LAST:event_jTextFieldSearchBarCaretUpdate

    private void jLabelRemoveSongsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRemoveSongsMouseClicked

        if (!jLabelConfirmRemove.isEnabled()) {
            removeModel.insertUser(model.getData());
            jTableMusics.setModel(removeModel);
            jLabelConfirmRemove.setEnabled(true);
            jLabelConfirmRemove.setVisible(true);

        } else {
            jTableMusics.setModel(model);
            jLabelConfirmRemove.setEnabled(false);
            jLabelConfirmRemove.setVisible(false);
        }


    }//GEN-LAST:event_jLabelRemoveSongsMouseClicked

    private void jLabelConfirmRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelConfirmRemoveMouseClicked

        int option = JOptionPane.showConfirmDialog(null, "Sure you want to Remove users ?", "JPlayer", JOptionPane.OK_OPTION);

        if (option == 0) {

            List<IUser> selecteds = removeModel.GetAllSelected();
            if (selecteds.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Select at least one user.");
                return;
            }

            List<IUser> currentUsers = model.getData();

            selecteds.forEach(users -> {
                currentUsers.removeIf(user -> user.getId() == users.getId());
            });

            boolean result = facade.removeUsersDb(selecteds);
            if (!result) {
                JOptionPane.showMessageDialog(null, "An error occurred while trying to delete the selected users. Try again");
            } else {
                removeModel.removeUser(selecteds);
            }

            IUser isCurrentUSer = selecteds.stream().filter(user -> user.getId() == facade.GetIdCurrentUser()).findFirst().orElse(null);

            if (isCurrentUSer != null) {
                closeApplication();
            }
        }
        jLabelConfirmRemove.setEnabled(false);
        listAllUsersInDatabase();

    }//GEN-LAST:event_jLabelConfirmRemoveMouseClicked

    private void closeApplication() {
        final Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new SignIn().setVisible(true);
        parentWindow.dispose();
    }
    private void jLabelRemoveSongs1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRemoveSongs1MouseClicked

        int selectedRow = jTableMusics.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Select at least one user in table.");
            return;
        }

        IUser selectedUser = model.getData(selectedRow);
        EditUsers modalEdit = new EditUsers(selectedUser);
        modalEdit.addObserver(this);
        modalEdit.setVisible(true);


    }//GEN-LAST:event_jLabelRemoveSongs1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelConfirmRemove;
    private javax.swing.JLabel jLabelRemoveSongs;
    private javax.swing.JLabel jLabelRemoveSongs1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMusics;
    private javax.swing.JTextField jTextFieldSearchBar;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Object publisher) {

        if (publisher instanceof Boolean) {

            if (((Boolean) publisher)) {
                listAllUsersInDatabase();
            }
        }

    }
}
