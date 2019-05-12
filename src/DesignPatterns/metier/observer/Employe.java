/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.metier.observer;

import java.util.Objects;

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
   protected int IDBUR;
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
    public Employe(int IDEMP, String MATRICULE, String NOM, String PRENOM, int IDBUR) {
        this.IDEMP = IDEMP;
        this.MATRICULE = MATRICULE;
        this.NOM = NOM;
        this.PRENOM = PRENOM;
        this.IDBUR = IDBUR;
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
     /**
 * méthode toString
 * @return informations complètes
 */
    @Override
    public String toString() {
        return "Employe{" + "IDEMP=" + IDEMP + ", MATRICULE=" + MATRICULE + ", NOM=" + NOM + ", PRENOM=" + PRENOM + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.IDEMP;
        hash = 97 * hash + Objects.hashCode(this.MATRICULE);
        hash = 97 * hash + Objects.hashCode(this.NOM);
        hash = 97 * hash + Objects.hashCode(this.PRENOM);
        hash = 97 * hash + this.IDBUR;
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
        final Employe other = (Employe) obj;
        if (this.IDEMP != other.IDEMP) {
            return false;
        }
        if (this.IDBUR != other.IDBUR) {
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
        return true;
    }
    
    
    @Override
    public void update(String msg) {
        System.out.println(PRENOM+" "+NOM+" a reçu le msg :"+msg);
    }
    
   
}
