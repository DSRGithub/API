
package projet3_api.metier;

/**
 *classe metier du bureau 
 * @author David Sanchez Rodriguez 
 * @version 1.0
 */
public class Bureau {
     protected int IDBUR;
   
   protected String SIGLE;
   
   protected String TEL;
   
   protected String DESCRIPTION;

    public Bureau() {
    }

    public Bureau(int IDBUR, String SIGLE, String TEL, String DESCRIPTION) {
        this.IDBUR = IDBUR;
        this.SIGLE = SIGLE;
        this.TEL = TEL;
        this.DESCRIPTION = DESCRIPTION;
    }

    public int getIDBUR() {
        return IDBUR;
    }

    public void setIDBUR(int IDBUR) {
        this.IDBUR = IDBUR;
    }

    public String getSIGLE() {
        return SIGLE;
    }

    public void setSIGLE(String SIGLE) {
        this.SIGLE = SIGLE;
    }

    public String getTEL() {
        return TEL;
    }

    public void setTEL(String TEL) {
        this.TEL = TEL;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    @Override
    public String toString() {
        return "Bureau{" + "IDBUR=" + IDBUR + ", SIGLE=" + SIGLE + ", TEL=" + TEL + ", DESCRIPTION=" + DESCRIPTION + '}';
    }

   
}
