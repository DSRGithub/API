/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.metier.builder;

import DesignPatterns.metier.Employe;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.List;
import java.util.Date;

/**
 *classe metier de message
 * @author David Sanchez Rodriguez 
 * @version 2.0
 */

public class Message {
   
    private int idmsg;
   
    private String contenu;
   
    private LocalDate dateEnvoi;
  
    private Set<Employe> employe = new HashSet<>();
  
    
    public Message(MessageBuilder cb) {
        this.idmsg = cb.idmsg;
        this.contenu = cb.contenu;
        this.dateEnvoi = LocalDate.now();
        this.employe = cb.employe;
        
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
  
    public LocalDate getDateEnvoi() {
        return LocalDate.now();
    }
    
    /*public void setDateEnvoi(LocalDate dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }*/
 
    public Set<Employe> getEmploye() {
        return employe;
    }
    public void setEmploye(Set<Employe> employe) {
        this.employe = employe;
    }
   
    

    @Override
    public String toString() {
        return "Message{" + "idmsg=" + idmsg + ", contenu=" + contenu + ", dateEnvoi=" + dateEnvoi + ", employe=" + employe + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.idmsg;
        hash = 23 * hash + Objects.hashCode(this.contenu);
        hash = 23 * hash + Objects.hashCode(this.dateEnvoi);
        hash = 23 * hash + Objects.hashCode(this.employe);
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
        if (!Objects.equals(this.dateEnvoi, other.dateEnvoi)) {
            return false;
        }
        if (!Objects.equals(this.employe, other.employe)) {
            return false;
        }
        return true;
    }
     
    
    public static class MessageBuilder {
   
    private int idmsg;
   
    private String contenu;
   
    private Set<Employe> employe = new HashSet<>();
    
    private LocalDate dateEnvoi=LocalDate.now();
    
     public MessageBuilder() {

        }
    
    public MessageBuilder setIdmsg(int idmsg) {
            this.idmsg = idmsg;
            return this;
        }
    
    public MessageBuilder setContenu(String contenu) {
            this.contenu = contenu;
            return this;
        }
    
   
    
   /* public MessageBuilder setDateEnvoi(LocalDate dateEnvoi) {
            this.dateEnvoi = dateEnvoi;
            return this;
        }*/
    
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
            if (idmsg <= 0 ||  contenu == null  || dateEnvoi == null || employe == null) {
                throw new Exception("informations de construction incomplètes");
            }
            return new Message(this);
        }
   }
   
   
}
