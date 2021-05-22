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
                if (b.equals(b.wall)) {
                    b.posPlayer = new Position(b.posPlayer.rows, b.posPlayer.cols);
                    System.err.println("attention au mur !");
                } else {
                    b.posPlayer = new Position(b.posPlayer.rows, b.posPlayer.cols - 1);
                }
                break;

            case "U":
                if (b.equals(b.wall)) {
                    b.posPlayer = new Position(b.posPlayer.rows, b.posPlayer.cols);
                    System.err.println("attention au mur !");
                } else {
                    b.posPlayer = new Position(b.posPlayer.rows - 1, b.posPlayer.cols);
                }
                break;

            case "R":
                if (b.equals(b.wall)) {
                    b.posPlayer = new Position(b.posPlayer.rows, b.posPlayer.cols);
                    System.err.println("attention au mur !");
                } else {
                    b.posPlayer = new Position(b.posPlayer.rows, b.posPlayer.cols + 1);
                }
                break;

            case "D":
                if (b.equals(b.wall)) {
                    b.posPlayer = new Position(b.posPlayer.rows, b.posPlayer.cols);
                    System.err.println("attention au mur !");
                } else {
                    b.posPlayer = new Position(b.posPlayer.rows + 1, b.posPlayer.cols);
                }
                break;
            default:
                System.err.println("Pas bonne lettre");
        }
    }
}
