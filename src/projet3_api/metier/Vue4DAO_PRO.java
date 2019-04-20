
package projet3_api.metier;

/**
 *classe métier Vue4DAO_PRO ( afficher tous les employés et leurs locaux )
 * @author David
 * @version 1.0
 */
public class Vue4DAO_PRO {
    /**
     * nom de l employé
     */
    private String nom;
     /**
     * prenom de l'employé
     */
    private String prenom;
    /**
     * sigle du bureau de l'employé 
     */
    private String sigle;
    /**
     * constructeur par défaut
     */
    public Vue4DAO_PRO() {
    }
     /**
     * constructeur paramétré
     *
     * @param nom nom de l'employé 
     * @param prenom prenom de l'employé
     * @param sigle sigle du bureau
     */
    public Vue4DAO_PRO(String nom, String prenom, String sigle) {
        this.nom = nom;
        this.prenom = prenom;
        this.sigle = sigle;
    }
    /**
     * getter nom
     * @return nom de l'employé
     */
    public String getNom() {
        return nom;
    }
    /**
     * setter nom
     * @param nom nom de l'employé
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * getter prenom
     * @return prenom de l'employé
     */
    public String getPrenom() {
        return prenom;
    }
    /**
     * setter prenom
     * @param prenom prenom de l'employé
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    /**
     * getter sigle
     * @return le sigle du bureau de l'employé
     */
    public String getSigle() {
        return sigle;
    }
    /**
     * setter sigle
     * @param sigle sigle du bureau de l'employé
     */
    public void setSigle(String sigle) {
        this.sigle = sigle;
    }
     /**
    * méthode toString
    * @return informations complètes
    */
    @Override
    public String toString() {
        return "Vue4DAO_PRO{" + "nom=" + nom + ", prenom=" + prenom + ", sigle=" + sigle + '}';
    }
    
    
}
