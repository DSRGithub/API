/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.metier.observer;

import java.util.Objects;
import DesignPatterns.metier.observer.Bureau;
/**
 *classe metier des employes 
 * @author David
 * @version 1.0
 */
public class Employe extends Observer{
     /**
   * identifiant unique de l'employé 
   */
    protected int IDEMP;
   /**
   * matricule du bureau
   */
   protected String MATRICULE;
   /**
   * nom de l'employé
   */
   protected String NOM;
   /**
   * prenom de l'employé
   */
   protected String PRENOM;
   /**
   * identifiant unique du bureau
   */
   // protected int IDBUR;
   protected Bureau bureau;
   /**
   *  constructeur par défaut
   */
    public Employe() {
    }
     /**
 * constructeur paramétré
 * @param IDEMP identifiant unique du de l'employé, affecté par la base de données
 * @param MATRICULE matricule de l'employé
 * @param NOM nom de l'employé
 * @param PRENOM prenom de l'employé
 * @param IDBUR identifiant unique du bureau ,affecté a la création
 */
    public Employe(int IDEMP, String MATRICULE, String NOM, String PRENOM, Bureau bureau) {
        this.IDEMP = IDEMP;
        this.MATRICULE = MATRICULE;
        this.NOM = NOM;
        this.PRENOM = PRENOM;
        this.bureau = bureau;
    }

    public Bureau getBureau() {    
        return bureau;
    }

    /**
     * getter IDBUR
     * @return identifiant du bureau ( on indique ce que cela retourne )
     */
    /* public int getIDBUR() {
    return IDBUR;
    }*/
    /**
     * setter IDBUR
     * @param IDBUR identifiant du bureau
     */
    /*public void setIDBUR(int IDBUR) {
    this.IDBUR = IDBUR;
    }*/
    public void setBureau(Bureau bureau) {    
        this.bureau = bureau;
    }

    /**
     * getter IDBUR
     * @return identifiant de l'employé
     */
    public int getIDEMP() {
        return IDEMP;
    }
    /**
     * setter IDEMP
     * @param IDEMP identifiant de l'employé
     */
    public void setIDEMP(int IDEMP) {
        this.IDEMP = IDEMP;
    }
    /**
    * getter Matricule
    * @return Matricule de l'employé
    */
    public String getMATRICULE() {
        return MATRICULE;
    }
    /**
     * setter MATRICULE
     * @param MATRICULE matricule de l'employé
     */
    public void setMATRICULE(String MATRICULE) {
        this.MATRICULE = MATRICULE;
    }
    /**
    * getter NOM
    * @return NOM
    */
    public String getNOM() {
        return NOM;
    }
    /**
     * setter NOM
     * @param NOM nom de l'employé
     */
    public void setNOM(String NOM) {
        this.NOM = NOM;
    }
    /**
    * getter Prenom
    * @return PRENOM
    */
    public String getPRENOM() {
        return PRENOM;
    }
    /**
     * setter PRENOM
     * @param PRENOM prenom de l'employé
     */
    public void setPRENOM(String PRENOM) {
        this.PRENOM = PRENOM;
    }

   
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.IDEMP;
        hash = 71 * hash + Objects.hashCode(this.MATRICULE);
        hash = 71 * hash + Objects.hashCode(this.NOM);
        hash = 71 * hash + Objects.hashCode(this.PRENOM);
        hash = 71 * hash + Objects.hashCode(this.bureau);
        return hash;
    }

    /**
     * méthode toString
     * @return informations complètes
     */
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
        final Employe other = (Employe) obj;
        if (this.IDEMP != other.IDEMP) {
            return false;
        }
        if (!Objects.equals(this.MATRICULE, other.MATRICULE)) {
            return false;
        }
        if (!Objects.equals(this.NOM, other.NOM)) {
            return false;
        }
        if (!Objects.equals(this.PRENOM, other.PRENOM)) {
            return false;
        }
        if (!Objects.equals(this.bureau, other.bureau)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Employe{" + "IDEMP=" + IDEMP + ", MATRICULE=" + MATRICULE + ", NOM=" + NOM + ", PRENOM=" + PRENOM + ", bureau=" + bureau + '}';
    }

    @Override
    public void update(String msg) {
        System.out.println(PRENOM+" "+NOM+" a reçu le msg :"+msg);
    }
    
   
}
