/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsokoban;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe permettant de diriger le player
 *
 * @author romai
 */
public class DirectionJoueur extends Player {

    /**
     * scanner permettant de donné une réponse ecrite dans la console
     */
    Scanner coord = new Scanner(System.in);

    /**
     * méthode qui permet de gerer le dialogue avec le joueur
     *
     * @param b
     */
    public void dialogue(Board b) {
        System.out.println("Commande : [LRUD]");
        String dir = coord.nextLine();// demander la direction

        switch (dir) {
            case "L":
                b.deplacement(dir);
                break;
            case "U":
                b.deplacement(dir);
                break;
            case "R":
                b.deplacement(dir);
                break;
            case "D":
                b.deplacement(dir);
                break;
            case "/quit":
                System.out.println("Abadon du Joueur");
                System.exit(0);
                break;
            default:
                System.err.println("Pas bonne lettre");
        }
    }
}
