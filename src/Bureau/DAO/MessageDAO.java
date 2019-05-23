
package Bureau.DAO;

/**
 * classe de mappage poo-relationnel message
 *
 * @author  David Sanchez Rodriguez 
 * @version 1.0
 * @see Message
 */

import Bureau.DAO.DAO;
import java.sql.SQLException;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import projet3_api.metier.Message;
import java.util.ArrayList;
import java.util.List;


public class MessageDAO extends DAO<Message> {
    /**
     * création d'un message sur base des valeurs de son objet métier
     *
     * @throws SQLException erreur de création
     * @param obj message à créer
     * @return message créé
     */
    
      @Override
      public Message create(Message obj) throws SQLException {
        int n;
        Message b = null;
        String q1="insert into PRO_MESSAGE(contenu,dateEnvoi,idemp) values(?,?,?)";
        String q2="select idmsg from PRO_MESSAGE where contenu=? and dateEnvoi=? and  idemp=?";
        try(PreparedStatement pstm1=dbConnect.prepareStatement(q1); 
                PreparedStatement pstm2=dbConnect.prepareStatement(q2)){
            pstm1.setString(1,obj.getContenu());
            pstm1.setInt(2,obj.getIdemp());
            int p = pstm1.executeUpdate();
            if (p == 0) {
                throw new SQLException("erreur de creation d'un message, aucune ligne créée");
            }
            pstm2.setString(1, obj.getContenu());
            pstm1.setDate(1, java.sql.Date.valueOf(obj.getDateEnvoi()));
            pstm2.setInt(3,obj.getIdemp());
            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idmsg = rs.getInt(1);
                    obj.setIdmsg(idmsg);
                    return read(idmsg);
                } else {
                    throw new SQLException("erreur de l'envoi du message record introuvable");
                }
            }
        }
    }
    
    
    /**
     * effacement du sur base de son identifiant
     *
     * @throws SQLException erreur de suppression
     * @param obj message à supprimer
     */
    
    @Override
    public void delete(Message obj) throws SQLException {
        String req="delete from PRO_Message where idmsg=?";
        try(PreparedStatement p=dbConnect.prepareStatement(req)){
            p.setInt(1,obj.getIdmsg());
            int n=p.executeUpdate();
            if(n==0){
                throw new SQLException("aucune ligne message effacée");
            }
        }
    }
    
     /**
     * mise à jour des données du message sur base de son identifiant
     *
     * @return message
     * @param obj message à mettre à jour
     * @throws SQLException erreur de mise à jour
     */
    
    @Override
    public Message update(Message obj) throws SQLException {
        String req = "update PRO_MESSAGE set contenu=? where idmsg= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(3, obj.getIdmsg());
            pstm.setString(1, obj.getContenu());
            pstm.setInt(2, obj.getIdemp());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne du message mise à jour");
            }
            return obj;
        }
    }
    /**
     * récupération des données d'un message sur base de son identifiant
     *
     * @throws SQLException identifiant inconnu
     * @param idemp identifiant du message
     * @return message trouvé 
     */
     @Override
    public Message read(int idemp) throws SQLException {
    
        String req="select * from PRO_MESSAGE where idemp=?";
         try(PreparedStatement p1=dbConnect.prepareStatement(req)){
             p1.setInt(1, idemp);
             try(ResultSet rs=p1.executeQuery()){
                 if(rs.next()){
                     String contenu=rs.getString("CONTENU");
                     LocalDate dateEnvoi = rs.getDate("DATEENVOI").toLocalDate();
                     int    idmsg= rs.getInt("IDMSG");
                     return new Message(idmsg,contenu,dateEnvoi,idemp);
                 }
                 else{
                     throw new SQLException("identifiant message inconnu");
                 }
             }
         }
         }

    
    public List<Message> rech(int idemp) throws SQLException {
        List<Message> msg = new ArrayList<>();
        String req="select * from PRO_MESSAGE where idemp=?";
         try(PreparedStatement p1=dbConnect.prepareStatement(req)){
             p1.setInt(1, idemp);
             try(ResultSet rs=p1.executeQuery()){
                 boolean trouve = false;
                 if(rs.next()){
                     trouve = true;
                     String contenu=rs.getString("CONTENU");
                     LocalDate dateEnvoi = rs.getDate("DATEENVOI").toLocalDate();
                     int    idmsg= rs.getInt("IDMSG");
                     msg.add(new Message(idmsg,contenu,dateEnvoi,idemp));
                 }
                 if (!trouve){
                     throw new SQLException("message  inconnu");
                 }else {
                    return msg;
                }
             }
         }
          
         }
}
