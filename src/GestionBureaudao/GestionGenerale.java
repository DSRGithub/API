/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionBureaudao;

import java.util.Scanner;
import GestionBureaudao.GestionBureau;
import GestionBureaudao.GestionEmploye;
import java.sql.SQLException;
/**
 *
 * @author David
 */
public class GestionGenerale {
    Scanner sc = new Scanner(System.in);
    
    public GestionGenerale() {

    }
    
    
    public void menu() throws SQLException {
        int ch = 10;
        while (ch != 0) {
            System.out.println("1.Bureau\n2.Employe\n3.Message\n4fin");
            ch = sc.nextInt();
            switch (ch) {
                case 0:
                    ch=10;
                    break;
                case 1:
                    menuBureau();
                    break;
                case 2:
                    menuEmploye();
                    break;
                case 3:
                    System.out.println("En cours de constuction");
                    //menuMessage();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default :
                    System.out.println("erreur de saisie");
            }
        }

    }

    public void menuBureau() throws SQLException {
        GestionBureau gb = new GestionBureau();
        gb.gestion();
    }

    public void menuEmploye() throws SQLException {
        GestionEmploye ge = new GestionEmploye();
        ge.gestion();
    }
    /*
    public void menuMessage(){
        GestionMessage pre=new GestionMessage();
        pre.menuP();
    }
   */
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        GestionGenerale p = new GestionGenerale();
        p.menu();
    }
}
