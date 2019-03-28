
package Bureau.DAO;


import Bureau.DAO.DAO;
import java.sql.SQLException;
import java.sql.*;
import java.util.*;
import projet3_api.metier.Bureau;
import java.util.ArrayList;
import java.util.List;

public class BureauDAO extends DAO<Bureau> {
    
    /**
     * récupération des données d'un bureau sur base de son identifiant
     *
     * @throws SQLException identifiant inconnu
     * @param SIGLE identifiant du bureau
     * @return bureau trouvé 
     */
    
    
    public Bureau readSigle(String SIGLE) throws SQLException {
        Bureau b=null;
        String req="select * from PRO_BUREAU where SIGLE=?";
         try(PreparedStatement p1=dbConnect.prepareStatement(req)){
             p1.setString(1, SIGLE);
             try(ResultSet rs=p1.executeQuery()){
                 if(rs.next()){
                     int IDBUR=rs.getInt("IDBUR");
                     //mettre nom de colones exacte
                     String TEL=rs.getString("TEL");
                     String DESCRIPTION = rs.getString("DESCRIPTION");
                     b=new Bureau(IDBUR,SIGLE,TEL,DESCRIPTION);
                 }
                 else{
                     throw new SQLException("Sigle du bureau inconnu");
                 }
             }
         }
        return b;
    }

    /**
     * création d'un bureau sur base des valeurs de son objet métier
     *
     * @throws SQLException erreur de création
     * @param obj bureau à créer
     * @return bureau créé
     */
    @Override
    public Bureau create(Bureau obj) throws SQLException {
        int n;
        Bureau b = null;
        String q1="insert into Pro_Bureau(SIGLE,TEL,DESCRIPTION) values(?,?,?)";
        String q2="select IDBUR from PRO_Bureau where SIGLE=? and TEL=? and DESCRIPTION=?";
        try(PreparedStatement pstm1=dbConnect.prepareStatement(q1); 
                PreparedStatement pstm2=dbConnect.prepareStatement(q2)){
            pstm1.setString(1,obj.getSIGLE());
            pstm1.setString(2,obj.getTEL());
            pstm1.setString(3,obj.getDESCRIPTION());
            int p = pstm1.executeUpdate();
            if (p == 0) {
                throw new SQLException("erreur de creation de bureau, aucune ligne créée");
            }
            pstm2.setString(1, obj.getSIGLE());
            pstm2.setString(2,obj.getTEL());
            pstm2.setString(3,obj.getDESCRIPTION());
            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int IDBUR = rs.getInt(1);
                    obj.setIDBUR(IDBUR);
                    return read(IDBUR);
                } else {
                    throw new SQLException("erreur de création de bureau, record introuvable");
                }
            }
        }
    }
    

    
    /**
     * effacement du bureau sur base de son identifiant
     *
     * @throws SQLException erreur de suppression
     * @param obj bureau à supprimer
     */
    
    @Override
    public void delete(Bureau obj) throws SQLException {
        String req="delete from PRO_BUREAU where SIGLE=?";
        try(PreparedStatement p=dbConnect.prepareStatement(req)){
            p.setString(1,obj.getSIGLE());
            int n=p.executeUpdate();
            if(n==0){
                throw new SQLException("aucune ligne bureau effacée");
            }
        }
    }
  
    /**
     * mise à jour des données du bureau sur base de son identifiant
     *
     * @return bureau
     * @param obj bureau à mettre à jour
     * @throws SQLException erreur de mise à jour
     */
    @Override
    public Bureau update(Bureau obj) throws SQLException {
        String req = "update PRO_BUREAU set TEL=?,DESCRIPTION=? where SIGLE= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            //pstm.setInt(3, obj.getIBUR());
            pstm.setString(3, obj.getSIGLE());
            pstm.setString(1, obj.getTEL());
            pstm.setString(2, obj.getDESCRIPTION());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne du bureau mise à jour");
            }
            return obj;
        }
    }

 
    
    /**
     * méthode permettant de récupérer tous les bureau portant un certain sigle
     * @param SIGLE sigle du bureau recherché
     * @return liste des bureau 
     * @throws SQLException nom inconnu
     */
    
    /*public List<Bureau> rechBUREAU(String SIGLE) throws SQLException {
        List<Bureau> Bure = new ArrayList<>();
        String req = "select * from PRO_BUREAU where SIGLE = ?";

        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req)) {
            pstm1.setString(1, SIGLE);
            try (ResultSet rs = pstm1.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    int IDBUR = rs.getInt("IDBUREAU");
                    SIGLE = rs.getString("Sigle");
                    String TEL = rs.getString("tel");
                    String DESCRIPTION = rs.getString("DESCRIPTION");
                    Bure.add(new Bureau(IDBUR,SIGLE,TEL,DESCRIPTION));
                    
                }
                if (!trouve) {
                    throw new SQLException("bureau inconnu");
                } else {
                    return Bure;
                }
            }
        }
        
        
    }
    */
    /** methode de recherche par description**/
     
     public List<Bureau> rechBureauDesc(String BureauRdesc) throws SQLException {
        List<Bureau> bure = new ArrayList<>();
        String req = "select * from PRO_Bureau where DESCRIPTION LIKE  ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setString(1, "%"+BureauRdesc+"%");
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    int IDBUR = rs.getInt("IDBUR");
                    String SIGLE = rs.getString("SIGLE");
                    String TEL = rs.getString("TEL");
                    String DESCRIPTION = rs.getString("DESCRIPTION");
                    
                    bure.add(new Bureau(IDBUR,SIGLE,TEL,DESCRIPTION));
                }

                if (!trouve) {
                    throw new SQLException("bureau non inconnu");
                } else {
                    return bure;
                }
            }
        }
        
    }

    @Override
    public Bureau read(int IDBUR) throws SQLException {
    
        String req="select * from PRO_BUREAU where IDBUR=?";
         try(PreparedStatement p1=dbConnect.prepareStatement(req)){
             p1.setInt(1, IDBUR);
             try(ResultSet rs=p1.executeQuery()){
                 if(rs.next()){
                     String SIGLE=rs.getString("SIGLE");
                     
                     String TEL=rs.getString("TEL");
                     String DESCRIPTION = rs.getString("DESCRIPTION");
                     return new Bureau(IDBUR,SIGLE,TEL,DESCRIPTION);
                 }
                 else{
                     throw new SQLException("identifiant du bureau inconnu");
                 }
             }
         }
         }
    
}
