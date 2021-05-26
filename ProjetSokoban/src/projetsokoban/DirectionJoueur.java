/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsokoban;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author romai
 */
public class DirectionJoueur extends Player {

    Scanner coord = new Scanner(System.in);
    
    public void dialogue(Board b) {
        System.out.println("Commande : [LRUD]");
        String dir = coord.nextLine();// demander la direction
        
        switch (dir) {
            case "L":
            case "U":
            case "R":
            case "D":
                b.deplacement(dir);
                break;
            default:
                System.err.println("Pas bonne lettre");
        }
    }
}
