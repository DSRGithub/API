
package projet3_api.metier;

/**
 *classe metier de message
 * @author David Sanchez Rodriguez 
 * @version 1.0
 */
public class Message {
    /**
   * identifiant du message 
   */
   protected int idmsg;
   /**
   * contenu du message
   */
   protected String contenu;
   /**
   * date envoi du message (localdate)
   */
   protected String dateEnvoi;
   /**
   * constructeur par défaut
   */
    public Message() {
    }
     /**
 * constructeur paramétré
 * @param idmsg identifiant unique du message, affecté par la base de données
 * @param contenu contenu du message envoyé
 * @param dateEnvoi date envoie associée au message
 */
    public Message(int idmsg, String contenu, String dateEnvoi) {
        this.idmsg = idmsg;
        this.contenu = contenu;
        this.dateEnvoi = dateEnvoi;
    }
    /**
    * getter idmsqg
    * @return identifiant du message
    */
    public int getIdmsg() {
        return idmsg;
    }
    /**
     * setter idmsg
     * @param idmsg identifiant du message
     */
    public void setIdmsg(int idmsg) {
        this.idmsg = idmsg;
    }
    /**
    * getter contenu
    * @return contenu du message
    */
    public String getContenu() {
        return contenu;
    }
    /**
     * setter contenu
     * @param contenu contenu du message
     */
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
    /**
    * getter dateenvoi
    * @return date envoi du message
    */
    public String getDateEnvoi() {
        return dateEnvoi;
    }
    /**
     * setter dateenvoi
     * @param dateEnvoi date envoi du message
     */
    public void setDateEnvoi(String dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }
     /**
 * méthode toString
 * @return informations complètes
 */
    @Override
    public String toString() {
        return "Message{" + "idmsg=" + idmsg + ", contenu=" + contenu + ", dateEnvoi=" + dateEnvoi + '}';
    }
   
   
}
