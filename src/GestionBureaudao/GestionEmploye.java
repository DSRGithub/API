/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionBureaudao;

import java.sql.*;
import myconnections.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import Bureau.DAO.EmployeDAO;
import Bureau.DAO.DAO;
import projet3_api.metier.Employe;
import myconnections.DBConnection;


/**
 *
 * @author David
 */
public class GestionEmploye {
    Scanner sc = new Scanner(System.in);
       
        
        Employe EmployeActuel = null;
        private EmployeDAO EmployeDAO;
       
                
    public GestionEmploye() {
    }
     public void gestion() throws SQLException{
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connection invalide");
            System.exit(1);
        }

        System.out.println("connexion établie");

        
        EmployeDAO = new EmployeDAO();
        EmployeDAO.setDbConnect(dbConnect);
        
        
    
     
      
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
      
    
       
        public void rechercheEmploye() throws SQLException{
        
        System.out.println("Recherche sur base du matricule de l'employe  :"); 
        String mat = sc.nextLine();
        EmployeActuel = EmployeDAO.readMATRICULE(mat);
           System.out.println("employe recherche "+ EmployeActuel);
           
        
        
    }
       
       
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
        GestionEmploye gc = new GestionEmploye();
        gc.gestion();
        EmployeDAO ed = new EmployeDAO();
    }

    
}
