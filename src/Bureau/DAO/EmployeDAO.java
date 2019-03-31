
package Bureau.DAO;


import java.sql.SQLException;
import java.sql.*;
import java.util.*;
import projet3_api.metier.Employe;
import java.util.ArrayList;
import java.util.List;


public class EmployeDAO extends DAO<Employe> {
    
    /**
     * création d'un employe sur base des valeurs de son objet métier
     *
     * @throws SQLException erreur de création
     * @param obj employeà créer
     * @return employe créé
     */
    @Override
    public Employe create(Employe obj) throws SQLException {
        int n;
        Employe b = null;
        String q1="insert into PRO_EMPLOYE(MATRICULE,NOM,PRENOM,IDBUR) values(?,?,?,?)";
        String q2="select IDEMP from PRO_EMPLOYE where MATRICULE=? and NOM=? and  PRENOM=? and IDBUR=?";
        try(PreparedStatement pstm1=dbConnect.prepareStatement(q1); 
                PreparedStatement pstm2=dbConnect.prepareStatement(q2)){
            pstm1.setString(1,obj.getMATRICULE());
            pstm1.setString(2,obj.getNOM());
            pstm1.setString(3,obj.getPRENOM());
            pstm1.setInt(4,obj.getIDBUR());
            int p = pstm1.executeUpdate();
            if (p == 0) {
                throw new SQLException("erreur de creation d'un employe, aucune ligne créée");
            }
            pstm2.setString(1, obj.getMATRICULE());
            pstm2.setString(2,obj.getNOM());
            pstm2.setString(3,obj.getPRENOM());
            pstm2.setInt(4,obj.getIDBUR());
            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int IDEMP = rs.getInt(1);
                    obj.setIDEMP(IDEMP);
                    return read(IDEMP);
                } else {
                    throw new SQLException("erreur de création de l'employé, record not found");
                }
            }
        }
    }
    
    /**
     * récupération des données d'un employe sur base de son identifiant
     *
     * @throws SQLException identifiant inconnu
     * @param MATRICULE identifiant de l'employe
     * @return employe trouve
     */
    
    
     public Employe readMATRICULE(String MATRICULE) throws SQLException {
        Employe b=null;
        String req="select * from PRO_EMPLOYE where MATRICULE=?";
         try(PreparedStatement p1=dbConnect.prepareStatement(req)){
             p1.setString(1, MATRICULE);
             try(ResultSet rs=p1.executeQuery()){
                 if(rs.next()){
                     int IDEMP=rs.getInt("IDEMP");
                     //mettre nom de colones exacte
                     String NOM=rs.getString("NOM");
                     String PRENOM = rs.getString("PRENOM");
                     int IDBUR = rs.getInt("IDBUR");
                     b=new Employe(IDEMP,MATRICULE,NOM,PRENOM,IDBUR);
                 }
                 else{
                     throw new SQLException("Matricule du bureau inconnu");
                 }
             }
         }
        return b;
    }

    /**
     * effacement de l'employe sur base de son identifiant
     *
     * @throws SQLException erreur de suppression
     * @param obj employe à supprimer
     */
    
    @Override
    public void delete(Employe obj) throws SQLException {
        String req="delete from PRO_EMPLOYE where MATRICULE=?";
        try(PreparedStatement p=dbConnect.prepareStatement(req)){
            p.setString(1,obj.getMATRICULE());
            int n=p.executeUpdate();
            if(n==0){
                throw new SQLException("aucune ligne employe effacée");
            }
        }
    }
    
     /**
     * mise à jour des données de l employé sur base de son identifiant
     *
     * @return employe
     * @param obj employe à mettre à jour
     * @throws SQLException erreur de mise à jour
     */
    
    @Override
    public Employe update(Employe obj) throws SQLException {
        String req = "update PRO_EMPLOYE set NOM=?,PRENOM=?,IDBUR=? where MATRICULE= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            
            pstm.setString(4, obj.getMATRICULE());
            pstm.setString(1, obj.getNOM());
            pstm.setString(2, obj.getPRENOM());
            pstm.setInt(3, obj.getIDBUR());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne du employe mise à jour");
            }
            return obj;
        }
    }

 
    @Override
    public Employe read(int IDEMP) throws SQLException {
    
        String req="select * from PRO_EMPLOYE where IDEMP=?";
         try(PreparedStatement p1=dbConnect.prepareStatement(req)){
             p1.setInt(1, IDEMP);
             try(ResultSet rs=p1.executeQuery()){
                 if(rs.next()){
                     String MATRICULE=rs.getString("MATRICULE");
                     
                     String NOM=rs.getString("NOM");
                     String PRENOM= rs.getString("PRENOM");
                     int    IDBUR= rs.getInt("IDBUR");
                     return new Employe(IDEMP,MATRICULE,NOM,PRENOM,IDBUR);
                 }
                 else{
                     throw new SQLException("identifiant employe inconnu");
                 }
             }
         }
         }
}
