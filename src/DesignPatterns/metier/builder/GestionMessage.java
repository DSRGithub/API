/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.metier.builder;
import DesignPatterns.metier.Employe;
import DesignPatterns.metier.builder.Message;
import java.time.LocalDate;
import java.util.Set;
/**
 *
 * @author David
 */
public class GestionMessage {
    public static void main(String[] args) {

        
        Employe emp1 = new Employe(1,"A15","Gregoire","jcqm",1);       
        System.out.println(emp1);
         
        Employe emp2 = new Employe(2, "A50", "Pierre", "Vanhoutryve",2);
        System.out.println(emp2);
        emp2.getEmploye().add(emp2);                                  
          
        try {
            
            Message msg1 = new Message.MessageBuilder().
                    setDateEnvoi(LocalDate.of(2019, 05, 19)).
                    setIdmsg(1).
                    setContenu("Hello").
                    setExpediteur("Logan").
                    addEmploye(emp1).
                    addEmploye(emp2).
                    build();
            System.out.println(msg1);
            
        } catch (Exception e) {
            System.out.println("erreur "+e);

        }
    }
}
