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

        
        Employe emp = new Employe(1,"A15","Gregoire","jcqm",1);       
        emp.setEmploye(emp);
        Employe emp2 = new Employe(2,"A16","jules","Blth",1);       
        emp.setEmploye(emp);
       
          
        try {
            
            Message msg = new Message.MessageBuilder().
                    setIdmsg(1).
                    setContenu("Hello").
                    addEmploye(emp).
                    addEmploye(emp2).
                    build();
            System.out.println(msg);
            
        } catch (Exception e) {
            System.out.println("erreur "+e);

        }
    }
}
