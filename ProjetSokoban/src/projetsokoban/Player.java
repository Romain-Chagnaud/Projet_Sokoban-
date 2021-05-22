/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsokoban;

import java.awt.Dialog;
import java.util.Scanner;

/**
 *
 * @author romai
 */
public class Player {

    public static boolean over;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Scanner consol = new Scanner(System.in);
//        System.out.println("Nombre de lignes :");
//        int rows = consol.nextInt();
//        System.out.println("Nombre de colonnes :");
//        int cols = consol.nextInt();
        Board b = new Board("coucou", 10, 10);
        DirectionJoueur d = new DirectionJoueur();

        b.addHorizontalWall(0, 0, 3);
        b.addVerticalWall(0, 0, 4);
        b.addHorizontalWall(1, 0, 2);
        b.addVerticalWall(1, 2, 2);
        b.addBox(4, 5);
        b.addBox(2, 3);
        b.addTarget(1, 2);
        b.setPosition(2, 2);
        b.display();
        for (int x = 0; x < 10; x++) {
            d.dialogue(b);
            b.display();
        }
    }
}
