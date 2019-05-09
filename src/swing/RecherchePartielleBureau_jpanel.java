/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import projet3_api.metier.Bureau;
import Bureau.DAO.BureauDAO;
/**
 *
 * @author David
 */
public class RecherchePartielleBureau_jpanel extends javax.swing.JPanel {
       BureauDAO bureauDAO=null;
    /**
     * Creates new form RecherchePartielleBureau_jpanel
     */
    public RecherchePartielleBureau_jpanel() {
        initComponents();
        dft1.addColumn("idbur");
        dft1.addColumn("Sigle");
        dft1.addColumn("tel");
        dft1.addColumn("description");
        jTable1.setModel(dft1);
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

        desc = new javax.swing.JLabel();
        desc_form = new javax.swing.JTextField();
        desc_rech_form = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        desc.setText("description");

        desc_form.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desc_formActionPerformed(evt);
            }
        });

        desc_rech_form.setText("recherche");
        desc_rech_form.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desc_rech_formActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "idbur", "sigle", "telephone", "description"
            }
        ));
        jTable1.setToolTipText("");
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(desc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(desc_form, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(desc_rech_form)
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(desc)
                    .addComponent(desc_form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(desc_rech_form))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void desc_formActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desc_formActionPerformed
       
    }//GEN-LAST:event_desc_formActionPerformed

    private void desc_rech_formActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desc_rech_formActionPerformed
         try{
            String rech=desc_form.getText();
            List<Bureau> lbur=bureauDAO.rechBureauDesc(rech);
            int i=dft1.getRowCount();
            for(int j=i-1;j>0;j--){
                dft1.removeRow(j);
            }
            for(Bureau bur:lbur){
                Vector v=new Vector();
                v.add(bur.getIDBUR());
                v.add(bur.getSIGLE());
                v.add(bur.getTEL());
                v.add(bur.getDESCRIPTION());
                dft1.addRow(v);
                
            }
        }catch(Exception e){
           JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_desc_rech_formActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel desc;
    private javax.swing.JTextField desc_form;
    private javax.swing.JButton desc_rech_form;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}