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
        if ("/quit".equals(dir)) {
            Player.over = true;
        } else {
            switch (dir) {
                case "L":
                    b.newPosition(-1, 0);
                    break;

                case "R":
                    b.newPosition(1, 0);
                    break;

                case "U":
                    b.newPosition(0, 1);
                    break;

                case "D":
                    b.newPosition(0, -1);
                    break;
                default:
            }
            System.out.println("afficher le nouveau plateau");
        }
    }
}
