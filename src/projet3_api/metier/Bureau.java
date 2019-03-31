
package projet3_api.metier;

/**
 *classe metier du bureau 
 * @author David Sanchez Rodriguez 
 * @version 1.0
 */
public class Bureau {
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

   
}
