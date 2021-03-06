
package projet3_api.metier;

import java.time.LocalDate;
import java.util.Objects;

/**
 *classe metier de message
 * @author David Sanchez Rodriguez 
 * @version 2.0
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
   protected LocalDate dateEnvoi;
   /**
   * date envoi du message (localdate)
   */
   protected int idemp;
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
 * @param idemp identifiant de celui qui envoie le message
 */
    public Message(int idmsg, String contenu, LocalDate dateEnvoi , int idemp) {
        this.idmsg = idmsg;
        this.contenu = contenu;
        this.dateEnvoi = dateEnvoi;
        this.idemp = idemp;
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
    public LocalDate getDateEnvoi() {
        return dateEnvoi;
    }
    /**
     * setter dateenvoi
     * @param dateEnvoi date envoi du message
     */
    public void setDateEnvoi(LocalDate dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }
    /**
    * getter idemp
    * @return identifiant de l'envoyeur
    */
    public int getIdemp() {
        return idemp;
    }
    /**
     * setter idemp
     * @param idemp identifiant de l'envoyeur
     */
    public void setIdemp(int idemp) {
        this.idemp = idemp;
    }
    /**
 * méthode toString
 * @return informations complètes
 */
    @Override
    public String toString() {
        return "Message{" + "idmsg=" + idmsg + ", contenu=" + contenu + ", dateEnvoi=" + dateEnvoi + ", idemp=" + idemp + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.idmsg;
        hash = 29 * hash + Objects.hashCode(this.contenu);
        hash = 29 * hash + Objects.hashCode(this.dateEnvoi);
        hash = 29 * hash + this.idemp;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Message other = (Message) obj;
        if (this.idmsg != other.idmsg) {
            return false;
        }
        if (this.idemp != other.idemp) {
            return false;
        }
        if (!Objects.equals(this.contenu, other.contenu)) {
            return false;
        }
        if (!Objects.equals(this.dateEnvoi, other.dateEnvoi)) {
            return false;
        }
        return true;
    }
   
   
}
