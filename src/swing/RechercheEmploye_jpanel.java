/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;
import Bureau.DAO.EmployeDAO;
import javax.swing.JOptionPane;
import projet3_api.metier.Employe;
/**
 *
 * @author David
 */
public class RechercheEmploye_jpanel extends javax.swing.JPanel {
     EmployeDAO employeDAO=null;
     Employe emp=null;
    /**
     * Creates new form RechercheEmploye_jpanel
     */
    public RechercheEmploye_jpanel() {
        initComponents();
        
    }
    public void setEmployeDAO(EmployeDAO employeDAO){
        this.employeDAO=employeDAO;
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
        jLabel5 = new javax.swing.JLabel();
        idemp_form = new javax.swing.JTextField();
        matricule_form = new javax.swing.JTextField();
        nom_form = new javax.swing.JTextField();
        prenom_form = new javax.swing.JTextField();
        idbur_form = new javax.swing.JTextField();
        jButtonrech = new javax.swing.JButton();
        jButtonmaj = new javax.swing.JButton();
        jButtonsupp = new javax.swing.JButton();

        jLabel1.setText("idemp");

        jLabel2.setText("matricule");

        jLabel3.setText("nom");

        jLabel4.setText("prenom");

        jLabel5.setText("idbur");

        idemp_form.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idemp_formActionPerformed(evt);
            }
        });

        jButtonrech.setText("recherche");
        jButtonrech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonrechActionPerformed(evt);
            }
        });

        jButtonmaj.setText("maj");
        jButtonmaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonmajActionPerformed(evt);
            }
        });

        jButtonsupp.setText("supprimer ");
        jButtonsupp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonsuppActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonrech)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonmaj, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonsupp))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1))
                        .addGap(98, 98, 98)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(prenom_form)
                            .addComponent(nom_form)
                            .addComponent(matricule_form)
                            .addComponent(idbur_form, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .addComponent(idemp_form))))
                .addContainerGap(313, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idemp_form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(matricule_form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nom_form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(prenom_form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idbur_form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonrech)
                    .addComponent(jButtonmaj)
                    .addComponent(jButtonsupp))
                .addContainerGap(41, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonrechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonrechActionPerformed
         try{
            
            String matricule =matricule_form.getText();
            emp=employeDAO.readMATRICULE(matricule);
            idemp_form.setText(""+emp.getIDEMP());
            nom_form.setText(emp.getNOM());
            prenom_form.setText(emp.getPRENOM());
            idbur_form.setText(""+emp.getIDBUR());
            JOptionPane.showConfirmDialog(this,"employe trouvé","succès",JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_jButtonrechActionPerformed

    private void jButtonmajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonmajActionPerformed
           try{
            int idemp=Integer.parseInt(idemp_form.getText());
            String matricule =matricule_form.getText();
            String nom=nom_form.getText();
            String prenom=prenom_form.getText();
            int idbur=Integer.parseInt(idbur_form.getText());
            Employe emp=new Employe(idemp,matricule,nom,prenom,idbur);
            employeDAO.update(emp);
            JOptionPane.showMessageDialog(this,"employe mis à jour","succès",JOptionPane.INFORMATION_MESSAGE);

        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonmajActionPerformed

    private void jButtonsuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonsuppActionPerformed
        try{
            int idemp=Integer.parseInt(idemp_form.getText());
            employeDAO.delete(emp);
            idemp_form.setText("");
            matricule_form.setText("");
            nom_form.setText("");
            prenom_form.setText("");
            idbur_form.setText("");
                         JOptionPane.showMessageDialog(this,"employe effacé","succès",JOptionPane.INFORMATION_MESSAGE);

        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_jButtonsuppActionPerformed

    private void idemp_formActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idemp_formActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idemp_formActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField idbur_form;
    private javax.swing.JTextField idemp_form;
    private javax.swing.JButton jButtonmaj;
    private javax.swing.JButton jButtonrech;
    private javax.swing.JButton jButtonsupp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField matricule_form;
    private javax.swing.JTextField nom_form;
    private javax.swing.JTextField prenom_form;
    // End of variables declaration//GEN-END:variables
}