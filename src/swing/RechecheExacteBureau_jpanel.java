/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;
import Bureau.DAO.BureauDAO;
import java.util.List;
import java.util.Vector;
import projet3_api.metier.Bureau;
import projet3_api.metier.Employe;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import projet3_api.metier.Vue4DAO_PRO;
/**
 *
 * @author David
 */

public class RechecheExacteBureau_jpanel extends javax.swing.JPanel {
     BureauDAO bureauDAO=null;
     Bureau bur=null;
    /**
     * Creates new form RechecheExacteBureau_jpanel
     */
    public RechecheExacteBureau_jpanel() {
        initComponents();
        dft1.addColumn("nom");
        dft1.addColumn("prenom");
        dft1.addColumn("sigle");
        jTableVue.setModel(dft1);
    }
    DefaultTableModel dft1=new DefaultTableModel();
   
    public void setBureauDAO(BureauDAO bureauDAO){
        this.bureauDAO=bureauDAO;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonrecherche = new javax.swing.JButton();
        jButtonmaj = new javax.swing.JButton();
        jButtoneffacer = new javax.swing.JButton();
        sigle_form = new javax.swing.JTextField();
        idbur_form = new javax.swing.JTextField();
        tel_form = new javax.swing.JTextField();
        desc_form = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVue = new javax.swing.JTable();

        jLabel1.setText("idbur");
        jLabel1.setEnabled(false);

        jLabel2.setText("sigle");

        jLabel3.setText("telephone");

        jLabel4.setText("description");

        jButtonrecherche.setText("recherche");
        jButtonrecherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonrechercheActionPerformed(evt);
            }
        });

        jButtonmaj.setText("maj");
        jButtonmaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonmajActionPerformed(evt);
            }
        });

        jButtoneffacer.setText("effacer");
        jButtoneffacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoneffacerActionPerformed(evt);
            }
        });

        idbur_form.setEditable(false);
        idbur_form.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idbur_formActionPerformed(evt);
            }
        });

        jTableVue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nom", "Prenom", "Sigle"
            }
        ));
        jScrollPane1.setViewportView(jTableVue);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(112, 112, 112)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(sigle_form, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tel_form, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(desc_form, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(idbur_form)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButtonrecherche)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonmaj, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(85, 85, 85)
                            .addComponent(jButtoneffacer))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idbur_form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(sigle_form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tel_form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(desc_form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonrecherche)
                    .addComponent(jButtonmaj)
                    .addComponent(jButtoneffacer))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void idbur_formActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idbur_formActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idbur_formActionPerformed

    private void jButtonrechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonrechercheActionPerformed
        try{
            //int idbur=Integer.parseInt(idbur_form.getText());
            String SIGLE =sigle_form.getText();
            bur=bureauDAO.readSigle(SIGLE);
            idbur_form.setText(""+bur.getIDBUR());
            tel_form.setText(""+bur.getTEL());
            desc_form.setText(bur.getDESCRIPTION());
            JOptionPane.showMessageDialog(this,"bureau trouvé","succès",JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);

        }
           try{
            String rech=sigle_form.getText();
            List<Vue4DAO_PRO> lbur=bureauDAO.rech(rech);
            int i=dft1.getRowCount();
            for(int j=i-1;j>=0;j--){
                dft1.removeRow(j);
            }
            for(Vue4DAO_PRO bur:lbur){
                Vector v=new Vector();
                v.add(bur.getNom());
                v.add(bur.getPrenom());
                v.add(bur.getSigle());
                dft1.addRow(v);
                
            }
        }catch(Exception e){
           JOptionPane.showMessageDialog(this,e.getMessage(),"aucun employe dans ce bureau",JOptionPane.ERROR_MESSAGE);
           int i=dft1.getRowCount();
            for(int j=i-1;j>=0;j--){
                dft1.removeRow(j);
            }
        }
    }//GEN-LAST:event_jButtonrechercheActionPerformed

    private void jButtonmajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonmajActionPerformed
        try{
            int idbur=Integer.parseInt(idbur_form.getText());
            String sigle=sigle_form.getText();
            String tel=tel_form.getText();
            String desc=desc_form.getText();
            Bureau bur=new Bureau(idbur,sigle,tel,desc);
            bureauDAO.update(bur);
            JOptionPane.showMessageDialog(this,"bureau mis à jour","succès",JOptionPane.INFORMATION_MESSAGE);

        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonmajActionPerformed

    private void jButtoneffacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoneffacerActionPerformed
        try{
            int idbur=Integer.parseInt(idbur_form.getText());
            bureauDAO.delete(bur);
            idbur_form.setText("");
            sigle_form.setText("");
            tel_form.setText("");
            desc_form.setText("");
                         JOptionPane.showMessageDialog(this,"bureau effacé","succès",JOptionPane.INFORMATION_MESSAGE);

        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_jButtoneffacerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField desc_form;
    private javax.swing.JTextField idbur_form;
    private javax.swing.JButton jButtoneffacer;
    private javax.swing.JButton jButtonmaj;
    private javax.swing.JButton jButtonrecherche;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableVue;
    private javax.swing.JTextField sigle_form;
    private javax.swing.JTextField tel_form;
    // End of variables declaration//GEN-END:variables
}
