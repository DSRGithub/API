
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
import Bureau.DAO.EmployeDAO;
import Bureau.DAO.DAO;
import projet3_api.metier.Bureau;
import projet3_api.metier.Employe;
import myconnections.DBConnection;

public class GestionBureau {

        Scanner sc = new Scanner(System.in);
        Bureau BureauActuel = null;
        private BureauDAO BureauDAO ;
        
        Employe EmployeActuel = null;
        private EmployeDAO EmployeDAO;
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
        
        EmployeDAO = new EmployeDAO();
        EmployeDAO.setDbConnect(dbConnect);
        
        
        int ch = 0;
        do {
            
            System.out.println(" |======  MENU PRINCIPAL ======|\n1.creation bureau \n2.recherche exacte bureau ( sigle) \n3.recherche partielle ( description) \n4.modification \n5.effacement \n6.fin");
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
                    System.exit(0);
                    break;
                default:
                    System.out.println("choix incorrect");
            }

        } while (ch !=6);
        DBConnection.closeConnection();
    
     
      /* DAO employe Fonctionnel 
      int ch = 0;
        do {
            
            System.out.println(" |======  MENU PRINCIPAL ======|\n1.creation employe  \n2.recherche employe \n3.modification \n4.effacement \n5.fin");
            System.out.print("choix :");
            ch = sc.nextInt();
            sc.skip("\n");
            switch (ch) {
                case 1:
                    creationEmploye();
                    break;
                case 2:
                    rechercheEmploye();
                    break;
                    
                case 3:
                    modificationEmploye();
                    break;
                
                case 4:
                    effacementEmploye();
                    break;
                
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("choix incorrect");
            }

        } while (ch !=5);
        DBConnection.closeConnection();
      }
     */
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
      // partie employe creation
      public  void creationEmploye(){
        System.out.print("matricule de l'employe:");
        String MATRICULE= sc.nextLine();
        System.out.print("nom :");
        String NOM = sc.nextLine();
        System.out.print("prenom:");
        String PRENOM= sc.nextLine();
        System.out.print("identifiant du bureau:");
        int IDBUR= sc.nextInt();
        //sc.skip("\n");
       
        EmployeActuel = new Employe(0,MATRICULE,NOM,PRENOM,IDBUR);
        try {
             EmployeActuel = EmployeDAO.create(EmployeActuel);
            System.out.println("employe actuel : " + EmployeActuel);
        } catch (SQLException e) {
            System.out.println("erreur :" + e);
        }
        
    }
      
      
     
      
       public void rechercheExacte() throws SQLException{
        
        System.out.println("Recherche sur base du Sigle du bureau  :"); 
        String sig = sc.nextLine();
        BureauActuel = BureauDAO.readSigle(sig);
           System.out.println("local recherche "+ BureauActuel);
           
        
        
    }
       // partie employe recherche
        public void rechercheEmploye() throws SQLException{
        
        System.out.println("Recherche sur base du matricule du bureau  :"); 
        String mat = sc.nextLine();
        EmployeActuel = EmployeDAO.readMATRICULE(mat);
           System.out.println("employe recherche "+ EmployeActuel);
           
        
        
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
    
    
      
      
       public void modification() { 
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
       
       //partie employe modification
       public void modificationEmploye() { 
        String option=""; int choix;
        try {
            
            do{
            do{
                System.out.println("Quelles modifications employé ? \n\t1-Nom: \n\t2-Prenom \n\t3-id du bureau \n\t4-Revenir au menu principal");
                option=sc.nextLine();
            }while(verifier_chaine(option,"[1-4]")==false);
            choix =Integer.parseInt(option);
            switch(choix){
                        case 1: 
                            System.out.println("Entrez le nouveau nom: ");
                            String nm=sc.nextLine();
                            EmployeActuel.setNOM(nm);
                            EmployeDAO.update(EmployeActuel); break;
                        case 2: 
                            System.out.println("Entrez le nouveau prenom: ");
                            String pre=sc.nextLine();
                            EmployeActuel.setPRENOM(pre);
                            EmployeDAO.update(EmployeActuel);break;
                            
                        case 3: 
                            System.out.println("Entrez le nouvel id de votre bureau: ");
                            int id=sc.nextInt();
                            EmployeActuel.setIDBUR(id);
                            EmployeDAO.update(EmployeActuel);break;
                        case 4: break;
            }
        }while(choix!=4);
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
         
    }
      
       
       
      
       public void effacement(){  
       try {
              BureauDAO.delete(BureauActuel);
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }
    
       // partie employe effacement 
       public void effacementEmploye(){  
       try {
              EmployeDAO.delete(EmployeActuel);
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    } 
       
     public boolean verifier_chaine(String ch, String regex){
                return ch.matches(regex);
    }
    
      public static void main(String[] args) throws SQLException {
        GestionBureau gc = new GestionBureau();
        gc.gestion();
        BureauDAO bd = new BureauDAO();
        EmployeDAO ed = new EmployeDAO();
    }
}
