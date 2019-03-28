
package projet3_api.metier;

/**
 *classe metier des employes 
 * @author David Sanchez Rodriguez 
 * @version 1.0
 */
public class Employe {
    protected int IDEMP;
   
   protected String MATRICULE;
   
   protected String NOM;
   
   protected String PRENOM;

    public Employe() {
    }

    public Employe(int IDEMP, String MATRICULE, String NOM, String PRENOM) {
        this.IDEMP = IDEMP;
        this.MATRICULE = MATRICULE;
        this.NOM = NOM;
        this.PRENOM = PRENOM;
    }

    public int getIDEMP() {
        return IDEMP;
    }

    public void setIDEMP(int IDEMP) {
        this.IDEMP = IDEMP;
    }

    public String getMATRICULE() {
        return MATRICULE;
    }

    public void setMATRICULE(String MATRCULE) {
        this.MATRICULE = MATRCULE;
    }

    public String getNOM() {
        return NOM;
    }

    public void setNOM(String NOM) {
        this.NOM = NOM;
    }

    public String getPRENOM() {
        return PRENOM;
    }

    public void setPRENOM(String PRENOM) {
        this.PRENOM = PRENOM;
    }

    @Override
    public String toString() {
        return "Employe{" + "IDEMP=" + IDEMP + ", MATRICULE=" + MATRICULE + ", NOM=" + NOM + ", PRENOM=" + PRENOM + '}';
    }

    
   
   
}
