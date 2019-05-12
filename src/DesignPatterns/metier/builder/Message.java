/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.metier.builder;

import DesignPatterns.metier.Employe;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
   * expediteur du message 
   */
    protected String contenu;
   /**
   * contenu du message
   */
   protected String Expediteur;
   /**
   * date envoi du message (localdate)
   */
   protected LocalDate dateEnvoi;
   /**
   * recepteur(s) du message
   */
    protected Set<Employe> employe = new HashSet<>();
   /**
   * constructeur par défaut
   */
    public Message() {
    }
     /**
 * constructeur paramétré
     * @param cb
 * @param idmsg identifiant unique du message, affecté par la base de données
 * @param contenu contenu du message envoyé
 * @param dateEnvoi date envoie associée au message
 * @param Expediteur nom  de celui qui envoie le message
 * @param employe les destinataires  
 */
    public Message(MessageBuilder cb) {
        this.idmsg = cb.idmsg;
        this.contenu = cb.contenu;
        this.Expediteur = cb.Expediteur;
        this.dateEnvoi = cb.dateEnvoi;
        this.employe = cb.employe;
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
    * getter Expediteur
    * @return identifiant de l'envoyeur
    */
    public String getExpediteur() {   
        return Expediteur;
    }

    /**
     * setter Expediteur
     * @param Expediteur nom de l'envoyeur
     */
    public void setExpediteur(String Expediteur) {    
        this.Expediteur = Expediteur;
    }
    /**
    * getter des destinataires
    * 
    * 
     * @return 
    */
    public Set<Employe> getEmploye() {
        return employe;
    }
    
     /**
     * méthode toString
     * @return informations complètes
     */
    

    @Override
    public String toString() {
        return "Message{" + "idmsg=" + idmsg + ", contenu=" + contenu + ", Expediteur=" + Expediteur + ", dateEnvoi=" + dateEnvoi + ", employe=" + employe + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.idmsg;
        hash = 41 * hash + Objects.hashCode(this.contenu);
        hash = 41 * hash + Objects.hashCode(this.Expediteur);
        hash = 41 * hash + Objects.hashCode(this.dateEnvoi);
        hash = 41 * hash + Objects.hashCode(this.employe);
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
        if (!Objects.equals(this.contenu, other.contenu)) {
            return false;
        }
        if (!Objects.equals(this.Expediteur, other.Expediteur)) {
            return false;
        }
        if (!Objects.equals(this.dateEnvoi, other.dateEnvoi)) {
            return false;
        }
        if (!Objects.equals(this.employe, other.employe)) {
            return false;
        }
        return true;
    }

   
  
    
    public class MessageBuilder {
        /**
   * identifiant du message 
   */
   protected int idmsg;
        /**
   * expediteur du message 
   */
    protected String contenu;
   /**
   * contenu du message
   */
   protected String Expediteur;
   /**
   * date envoi du message (localdate)
   */
   protected LocalDate dateEnvoi;
   /**
   * recepteur(s) du message
   */
    protected Set<Employe> employe = new HashSet<>();
    
    public MessageBuilder setIdmsg(int idmsg) {
            this.idmsg = idmsg;
            return this;
        }
    
    public MessageBuilder setContenu(String contenu) {
            this.contenu = contenu;
            return this;
        }
    
    public MessageBuilder setExpediteur(String Expediteur) {
            this.Expediteur = Expediteur;
            return this;
        }
    
    public MessageBuilder setDateEnvoi(LocalDate dateEnvoi) {
            this.dateEnvoi = dateEnvoi;
            return this;
        }
    
    public MessageBuilder setEmploye(Set<Employe> employe) {
            this.employe = employe;
            return this;
        }
    
    
    //méthode add employe . elle va ajouter dans le set employe
        public MessageBuilder addEmploye(Employe i) {
            
            employe.add(i);
            return this;
        }
     public Message build() throws Exception {
            if (idmsg <= 0 || Expediteur == null || contenu == null  || dateEnvoi == null || employe == null) {
                throw new Exception("informations de construction incomplètes");
            }
            return new Message(this);
        }
}
   
   
}
