/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;
import java.awt.CardLayout;
import java.sql.Connection;
import javax.swing.JOptionPane;
import Bureau.DAO.BureauDAO;
import Bureau.DAO.DAO;
import myconnections.DBConnection;
/**
 *
 * @author David
 */
public class Gestion_Bureau_jframe extends javax.swing.JFrame {

    /**
     * Creates new form Gestion_Bureau_jframe
     */
    CardLayout cardl;
    public Gestion_Bureau_jframe() {
        initComponents();
        cardl=(CardLayout)this.getContentPane().getLayout();
         Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connection invalide");
            JOptionPane.showMessageDialog(this,"connexion invalide","ERREUR",JOptionPane.ERROR_MESSAGE);
        }
         BureauDAO bureauDAO = new BureauDAO();
         bureauDAO.setDbConnect(dbConnect);
         creationBureau_jpanel2.setBureauDAO(bureauDAO);
         recherchePartielleBureau_jpanel1.setBureauDAO(bureauDAO);
         rechecheExacteBureau_jpanel1.setBureauDAO(bureauDAO);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        creationBureau_jpanel2 = new swing.CreationBureau_jpanel();
        recherchePartielleBureau_jpanel1 = new swing.RecherchePartielleBureau_jpanel();
        rechecheExacteBureau_jpanel1 = new swing.RechecheExacteBureau_jpanel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        creation = new javax.swing.JMenuItem();
        rechercheexacte = new javax.swing.JMenuItem();
        recherchepartielle = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());
        getContentPane().add(creationBureau_jpanel2, "card2");
        getContentPane().add(recherchePartielleBureau_jpanel1, "card3");
        getContentPane().add(rechecheExacteBureau_jpanel1, "card4");

        jMenuBar2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jMenu3.setText("Menu Bureau");

        creation.setText("creation");
        creation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creationActionPerformed(evt);
            }
        });
        jMenu3.add(creation);

        rechercheexacte.setText("Recherche exacte");
        rechercheexacte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechercheexacteActionPerformed(evt);
            }
        });
        jMenu3.add(rechercheexacte);

        recherchepartielle.setText("Recherche partielle");
        recherchepartielle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recherchepartielleActionPerformed(evt);
            }
        });
        jMenu3.add(recherchepartielle);

        jMenuBar2.add(jMenu3);

        setJMenuBar(jMenuBar2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void creationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creationActionPerformed
        cardl.show(this.getContentPane(), "card2");
    }//GEN-LAST:event_creationActionPerformed

    private void rechercheexacteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechercheexacteActionPerformed
        cardl.show(this.getContentPane(), "card4");
    }//GEN-LAST:event_rechercheexacteActionPerformed

    private void recherchepartielleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recherchepartielleActionPerformed
        cardl.show(this.getContentPane(), "card3");
    }//GEN-LAST:event_recherchepartielleActionPerformed

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
            java.util.logging.Logger.getLogger(Gestion_Bureau_jframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestion_Bureau_jframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestion_Bureau_jframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestion_Bureau_jframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gestion_Bureau_jframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem creation;
    private swing.CreationBureau_jpanel creationBureau_jpanel2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar2;
    private swing.RechecheExacteBureau_jpanel rechecheExacteBureau_jpanel1;
    private swing.RecherchePartielleBureau_jpanel recherchePartielleBureau_jpanel1;
    private javax.swing.JMenuItem rechercheexacte;
    private javax.swing.JMenuItem recherchepartielle;
    // End of variables declaration//GEN-END:variables
}
