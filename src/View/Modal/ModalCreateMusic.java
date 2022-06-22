package View.Modal;

import Utils.Observer.interfaces.IObserver;
import Utils.Observer.interfaces.IPublisher;
import Facades.MusicFacade;
import Facades.PlaylistFacade;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Model.Music;
import Model.interfaces.IMusic;

/**
 *
 * @author Mateus Santos
 */
public class ModalCreateMusic extends javax.swing.JFrame implements IPublisher{

    /**
     * Creates new form ModalAddMusic
     */
    private final MusicFacade facade = new MusicFacade();
    private final List<IObserver> observers = new ArrayList<>();
    private boolean result;
    
    public ModalCreateMusic() {
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

        jPanel1 = new javax.swing.JPanel();
        jButtonCreate = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldAuthor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jFormattedTextFieldDuration = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(35, 35, 35));

        jButtonCreate.setText("Create");
        jButtonCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jButtonCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButtonCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jTextFieldAuthor.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextFieldAuthorCaretUpdate(evt);
            }
        });

        jLabel1.setText("Song Name");

        jLabel2.setText("Author");

        jTextFieldName.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextFieldNameCaretUpdate(evt);
            }
        });

        try {
            jFormattedTextFieldDuration.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldDuration.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextFieldDuration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldDurationActionPerformed(evt);
            }
        });

        jLabel4.setText("Duration");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormattedTextFieldDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateActionPerformed
        
        if(validateFields()){
            result = facade.insertMusic(createMusic());
            if(result){
                JOptionPane.showMessageDialog(null, "Music created in database with sucess!");        
            }  

            notifyObservers();
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Check the fields and try again");
        }
       
   
    }//GEN-LAST:event_jButtonCreateActionPerformed
    
    private boolean validateFields(){
        
        return !(jTextFieldName.getText().isEmpty() ||
                jTextFieldAuthor.getText().isEmpty() || 
                jFormattedTextFieldDuration.getText().equals("  :  "));
    }
    private void jTextFieldAuthorCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextFieldAuthorCaretUpdate
        
    }//GEN-LAST:event_jTextFieldAuthorCaretUpdate

    private void jTextFieldNameCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextFieldNameCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNameCaretUpdate

    private void jFormattedTextFieldDurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldDurationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldDurationActionPerformed

    private IMusic createMusic(){     
        return new Music(jTextFieldName.getText(), jTextFieldAuthor.getText(), jFormattedTextFieldDuration.getText());
    }
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
            java.util.logging.Logger.getLogger(ModalCreateMusic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModalCreateMusic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModalCreateMusic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModalCreateMusic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModalCreateMusic().setVisible(true);
            }
        });
    }
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCreate;
    private javax.swing.JFormattedTextField jFormattedTextFieldDuration;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldAuthor;
    private javax.swing.JTextField jTextFieldName;
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
            ob.update(result);
        });
    }


}