/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.metier.observer;

/**
 *
 * @author David
 */
public class Gestion {
    public static void main(String[] args) {
         Bureau b1 = new Bureau(1, "F40","04025326252","Bureau avec les I7");
         Bureau b2 = new Bureau(2, "F41","04588987474","Bureau avec les MacBook");
         Employe emp1= new Employe(1,"AAA","Jean","Labie",1);
         Employe emp2= new Employe(2,"BBB","Jules","Blothiaux",2);
         b1.addObserver(emp1);
         b1.addObserver(emp2);
         b2.addObserver(emp1);
         
        b1.setTEL("0678/98.11.22");
        b2.setTEL("0878/21.11.55");
    }
}
