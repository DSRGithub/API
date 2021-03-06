/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.metier.observer;

import java.util.Objects;
/**
 *classe metier du bureau 
 * @author David 
 * @version 1.0
 */
public class Bureau extends Subject{
     /**
   * identifiant unique du bureau
   */
   protected int IDBUR;
   /**
   * sigle du bureau
   */
   protected String SIGLE;
   /**
   * numero de telephone du bureau
   */
   protected String TEL;
   /**
   * description du bureau
   */
   protected String DESCRIPTION;
   /**
   *  constructeur par défaut
   */
    public Bureau() {
    }
     /**
 * constructeur paramétré
 * @param IDBUR identifiant unique du bureau, affecté par la base de données
 * @param SIGLE sigle du bureau
 * @param TEL numerode telephone associé au bureau
 * @param DESCRIPTION description du bureau
 */
    public Bureau(int IDBUR, String SIGLE, String TEL, String DESCRIPTION) {
        this.IDBUR = IDBUR;
        this.SIGLE = SIGLE;
        this.TEL = TEL;
        this.DESCRIPTION = DESCRIPTION;
    }
   /**
    * getter IDBUR
    * @return identifiant du bureau ( on indique ce que cela retourne )
    */
    public int getIDBUR() {
        return IDBUR;
    }
    /**
     * setter IDBUR
     * @param IDBUR identifiant du bureau
     */
    public void setIDBUR(int IDBUR) {
        this.IDBUR = IDBUR;
    }
    /**
     * getter du sigle
     * @return le sigle
     */
    public String getSIGLE() {
        return SIGLE;
    }
    /**
     * setter sigle
     * @param SIGLE sigle du bureau
     */
    public void setSIGLE(String SIGLE) {
        this.SIGLE = SIGLE;
    }
    /**
     * getter du telephone
     * @return telephone
     */
    public String getTEL() {
        return TEL;
    }
    /**
     * setter telephone
     * @param TEL telephone
     */
    public void setTEL(String TEL) {
        this.TEL = TEL;
        notifyObservers();
    }
    /**
     * getter description
     * @return description
     */
    public String getDESCRIPTION() {
        return DESCRIPTION;
    }
    /**
     * setter description
     * @param DESCRIPTION description du bureau
     */
    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }
    
    /**
 * méthode toString
 * @return informations complètes
 */
    @Override
    public String toString() {
        return "Bureau{" + "IDBUR=" + IDBUR + ", SIGLE=" + SIGLE + ", TEL=" + TEL + ", DESCRIPTION=" + DESCRIPTION + '}';
    }
    
     @Override
    public String getNotification() {
        return "nouveau numéro de téléphone du bureau "+SIGLE+" = "+TEL;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.IDBUR;
        hash = 97 * hash + Objects.hashCode(this.SIGLE);
        hash = 97 * hash + Objects.hashCode(this.TEL);
        hash = 97 * hash + Objects.hashCode(this.DESCRIPTION);
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
        final Bureau other = (Bureau) obj;
        if (!Objects.equals(this.DESCRIPTION, other.DESCRIPTION)) {
            return false;
        }
        return true;
    }
}
