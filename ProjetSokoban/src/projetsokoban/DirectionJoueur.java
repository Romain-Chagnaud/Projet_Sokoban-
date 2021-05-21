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

    ArrayList<Position> character = new ArrayList<>();

    Scanner coord = new Scanner(System.in);

    public void dialogue(Board b) {
        System.out.println("Commande : [LRUD]");
        String dir = coord.nextLine();// demander la direction
//        if ("/quit".equals(dir)) {
//            Player.over = true;
//        } else {

        switch (dir) {
            case "L":
//                if (!b.wall){
                    b.posPlayer = new Position(b.posPlayer.rows, b.posPlayer.cols - 1);
                    break;
//                }
            case "U":
                b.posPlayer = new Position(b.posPlayer.rows - 1, b.posPlayer.cols);
                break;

            case "R":
                b.posPlayer = new Position(b.posPlayer.rows, b.posPlayer.cols + 1);
                break;

            case "D":
                b.posPlayer = new Position(b.posPlayer.rows + 1, b.posPlayer.cols);
                break;
            default:
                System.err.println("Pas bonne lettre");
        }
    }
}
