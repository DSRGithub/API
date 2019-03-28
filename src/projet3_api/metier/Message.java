
package projet3_api.metier;

/**
 *classe metier de message
 * @author David Sanchez Rodriguez 
 * @version 1.0
 */
public class Message {
     protected int idmsg;
   
   protected String contenu;
   
   protected String dateEnvoi;

    public Message() {
    }

    public Message(int idmsg, String contenu, String dateEnvoi) {
        this.idmsg = idmsg;
        this.contenu = contenu;
        this.dateEnvoi = dateEnvoi;
    }

    public int getIdmsg() {
        return idmsg;
    }

    public void setIdmsg(int idmsg) {
        this.idmsg = idmsg;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(String dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    @Override
    public String toString() {
        return "Message{" + "idmsg=" + idmsg + ", contenu=" + contenu + ", dateEnvoi=" + dateEnvoi + '}';
    }
   
   
}
