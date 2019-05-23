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
import Bureau.DAO.MessageDAO;
import Bureau.DAO.DAO;
import projet3_api.metier.Message;
import myconnections.DBConnection;

/**
 *
 * @author David
 */
public class GestionMessage {
     Scanner sc = new Scanner(System.in);
       
        
        Message MessageActuel = null;
        private MessageDAO MessageDAO;
        
        public GestionMessage() {
    }
     public void gestion() throws SQLException{
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connection invalide");
            System.exit(1);
        }

        System.out.println("connexion établie");

        
        MessageDAO = new MessageDAO();
        MessageDAO.setDbConnect(dbConnect);
        
        
    
     
      
      int ch = 0;
        do {
            
            System.out.println(" |======  MENU PRINCIPAL ======|\n1.envoi de message  \n2.recherche de message envoyé (unique) \n3.recherche de message envoyé( multiples)\n5.modification du message \n6.effacement du message \n5.fin");
            System.out.print("choix :");
            ch = sc.nextInt();
            sc.skip("\n");
            switch (ch) {
                case 1:
                    creationMessage();
                    break;
                case 2:
                    rechercheMessage();
                    break;
                case 3:
                    rech();
                    break;    
                case 4:
                    modificationMessage();
                    break;
                
                case 5:
                    effacementMessage();
                    break;
                
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("choix incorrect");
            }

        } while (ch !=6);
        DBConnection.closeConnection();
      }

   
     
   
      
      public  void creationMessage(){
        System.out.print("contenu:");
        String contenu= sc.nextLine();
        System.out.print("votre id employé :");
        int idemp = sc.nextInt();
        /*System.out.print("id de l'employé destinataire:");
        int idemp= sc.nextInt();*/
        //sc.skip("\n");
       
        MessageActuel = new Message(0,contenu,LocalDate.now(),idemp);
        try {
             MessageActuel = MessageDAO.create(MessageActuel);
            System.out.println("message actuel : " + MessageActuel);
        } catch (SQLException e) {
            System.out.println("erreur :" + e);
        }
        // todo une boucle do while pour l envoi de plusieurs messages !
    }
      
    public void rechercheMessage() throws SQLException{
        
        System.out.println("Recherche sur base de id  de l'employe  :"); 
        int id = sc.nextInt();
         try{
        MessageActuel = MessageDAO.read(id);
           System.out.println("message recherche "+ MessageActuel);
        } catch( SQLException e) {
            System.out.println("erreur " + e.getMessage());
       }
        
           
         /*try {
            List<Message> alc = (List<Message>) ((MessageDAO) MessageDAO).read(id);
            for (Message cl : alc) {
                System.out.println(cl);
            }
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
      */
        
    }
       
      
        public void rech() throws SQLException{
        
        System.out.println("Recherche sur base de id  de l'employe  :"); 
        int id = sc.nextInt(); 
         try {
            List<Message> alc = (List<Message>) ((MessageDAO) MessageDAO).rech(id);
            for (Message cl : alc) {
                System.out.println(cl);
            }
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
      
        
    }
       
       
       public void modificationMessage() throws SQLException { 
         if (MessageActuel == null) {
            System.out.println("Veuillez d'abord choisir un message actuel pour continuer");
            rechercheMessage();
        } 
         if (MessageActuel == null) {
            System.out.println("erreur aucun bureau actuel !");
         }
         else{   
        String option=""; int choix;
        try {
            
            do{
            do{
                System.out.println("Quelles modifications pour votre message ? \n\t1-contenu: \n\t2-id employé du message\n\t3-revenir au menu principal");
                option=sc.nextLine();
            }while(verifier_chaine(option,"[1-3]")==false);
            choix =Integer.parseInt(option);
            switch(choix){
                        case 1: 
                            System.out.println("Entrez le nouveau contenu du message: ");
                            String ct=sc.nextLine();
                            MessageActuel.setContenu(ct);
                            MessageDAO.update(MessageActuel); break;
                            
                        case 2: 
                            System.out.println("Entrez le nouvel id message: ");
                            int id=sc.nextInt();
                            MessageActuel.setIdemp(id);
                            MessageDAO.update(MessageActuel);break;
                        case 3: break;
            }
        }while(choix!=3);
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
         } 
    }
      
   
    
      
       public void effacementMessage() throws SQLException{ 
         if (MessageActuel == null) {
            System.out.println("Veuillez d'abord choisir un message actuel pour continuer");
            rechercheMessage();
        } 
         if (MessageActuel == null) {
            System.out.println("erreur aucun message actuel !");
         }
         else{    
       try {
              MessageDAO.delete(MessageActuel);
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
       }
       // todo mettre en oeuvre la suppression en cascade message ( lie a info )
    } 
       
     public boolean verifier_chaine(String ch, String regex){
                return ch.matches(regex);
    }
    
      public static void main(String[] args) throws SQLException {
        GestionMessage gc = new GestionMessage();
        gc.gestion();
        MessageDAO ed = new MessageDAO();
    }

}
