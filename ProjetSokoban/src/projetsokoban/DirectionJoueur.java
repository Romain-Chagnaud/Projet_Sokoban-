/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsokoban;

import java.util.Scanner;

/**
 *
 * @author romai
 */
public class DirectionJoueur extends Direction {
    
    Scanner coord = new Scanner(System.in); // demander la direction 
//    Position pos = new Position(0, 0);
    

    public void dialogue(Board b) {
        System.out.println("Commande : [LRUD]");
        String dir = coord.nextLine();
        if ("/quit".equals(dir)) {
            Player.over = true;
        } else {
            switch (dir) {
                case "L":
                    deplacementJoueur(-1, 0);
                    break;

                case "R":
                    deplacementJoueur(1, 0);
                    break;

                case "U":
                    deplacementJoueur(0, 1);
                    break;

                case "D":
                    deplacementJoueur(0, -1);
                    break;
                default:
            }
            
        }
    }
}
