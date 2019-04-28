
package GestionBureaudao;
import java.sql.*;
import myconnections.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import Bureau.DAO.BureauDAO;
import Bureau.DAO.DAO;
import projet3_api.metier.Bureau;
import projet3_api.metier.Vue4DAO_PRO;
import myconnections.DBConnection;

public class GestionBureau {

        Scanner sc = new Scanner(System.in);
        Bureau BureauActuel = null;
        private BureauDAO BureauDAO ;
        /*DAO<Bureau> BureauDAO = null;*/
                
    public GestionBureau() {
    }
     public void gestion() throws SQLException{
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connection invalide");
            System.exit(1);
        }

        System.out.println("connexion établie");

        BureauDAO = new BureauDAO();
        BureauDAO.setDbConnect(dbConnect);
        
       
        
        int ch = 0;
        do {
            
            System.out.println(" |======  MENU PRINCIPAL ======|\n1.creation bureau \n2.recherche exacte bureau ( sigle) \n3.recherche partielle ( description) \n4.modification \n5.effacement\n6.Liste employé/bureau \n7.fin");
            System.out.print("choix :");
            ch = sc.nextInt();
            sc.skip("\n");
            switch (ch) {
                case 1:
                    creation();
                    break;
                case 2:
                    rechercheExacte();
                    break;
                case 3:
                    recherchePartielle();
                    break;
                    
                case 4:
                    modification();
                    break;
                
                case 5:
                    effacement();
                    break;
                    
                case 6:
                    rech();
                    break;
                
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("choix incorrect");
            }

        } while (ch !=7);
        DBConnection.closeConnection();
    
     
      
    }
     
     
      public  void creation(){
        System.out.print("Sigle du bureau:");
        String SIGLE= sc.nextLine();
        System.out.print("numero de telephone :");
        String TEL = sc.nextLine();
        System.out.print("Description du bureau:");
        String DESCRIPTION= sc.nextLine();
        //sc.skip("\n");
       
        BureauActuel = new Bureau(0,SIGLE,TEL,DESCRIPTION);
        try {
            BureauActuel = BureauDAO.create(BureauActuel);
            System.out.println("bureau actuel : " + BureauActuel);
        } catch (SQLException e) {
            System.out.println("erreur :" + e);
        }
        
    }
     
      
       public void rechercheExacte() throws SQLException{
        
        System.out.println("Recherche sur base du Sigle du bureau  :"); 
        String sig = sc.nextLine();
        try{
        BureauActuel = BureauDAO.readSigle(sig);
           System.out.println("local recherche "+ BureauActuel);
        } catch( SQLException e) {
            System.out.println("erreur " + e.getMessage());
       }
        
        
    }
     
       public void recherchePartielle(){ 
        System.out.println("Entrer description : ");
        String DESCRIPTION= sc.nextLine();
        try {
            List<Bureau> alc = ((BureauDAO) BureauDAO).rechBureauDesc(DESCRIPTION);
            for (Bureau cl : alc) {
                System.out.println(cl);
            }
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }
    
    
      
      
       public void modification() throws SQLException { 
         if (BureauActuel == null) {
            System.out.println("Veuillez d'abord choisir un bureau actuel pour continuer");
            rechercheExacte();
        } 
         if (BureauActuel == null) {
            System.out.println("erreur aucun bureau actuel !");
         }
         else{
            
        String option=""; int choix;
        try {
            
            do{
            do{
                System.out.println("Quelle modification pour votre bureau ? \n\t1-Numero de telephone: \n\t2-Description \n\t3-Revenir au menu principal");
                option=sc.nextLine();
            }while(verifier_chaine(option,"[1-3]")==false);
            choix =Integer.parseInt(option);
            switch(choix){
                        case 1: 
                            System.out.println("Entrez le nouveau nuveau de telephone: ");
                            String nbr=sc.nextLine();
                            BureauActuel.setTEL(nbr);
                            BureauDAO.update(BureauActuel); break;
                        case 2: 
                            System.out.println("Entrez la nouvelle description: ");
                            String desc=sc.nextLine();
                            BureauActuel.setDESCRIPTION(desc);
                            BureauDAO.update(BureauActuel);break;
                        
                        case 3: break;
            }
        }while(choix!=3);
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
         } 
    }
      
    
       public void effacement() throws SQLException{
        if (BureauActuel == null) {
            System.out.println("Veuillez d'abord choisir un bureau actuel pour continuer");
            rechercheExacte();
        } 
        if (BureauActuel == null) {
            System.out.println("erreur lors de la recherche");
            
        } 
        else{
        try {
            BureauDAO.delete(BureauActuel);
            System.out.println("Bureau correctement effacé");
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
        }
    }
       
       
        public void rech() {
        System.out.println("Rechercher liste employé :");
        System.out.println("sigle de bureau complet ou partiel à rechercher :");
        String sigle = sc.nextLine();
         try {
            List<Vue4DAO_PRO> alc = ((BureauDAO) BureauDAO).rech(sigle);
            for (Vue4DAO_PRO cl : alc) {
                System.out.println(cl);
            }
        } catch (SQLException e) {
            System.out.println("probleme " + e.getMessage());
        }
       
        
    }
   
       
     public boolean verifier_chaine(String ch, String regex){
                return ch.matches(regex);
    }
    
      public static void main(String[] args) throws SQLException {
        GestionBureau gc = new GestionBureau();
        gc.gestion();
        BureauDAO bd = new BureauDAO();
        
    }
}
