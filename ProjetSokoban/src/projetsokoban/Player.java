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
public class Player  {

    public static boolean over;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner consol = new Scanner(System.in);
        System.out.println("Nombre de lignes :");
        int rows = consol.nextInt();
        System.out.println("Nombre de colonnes :");
        int cols = consol.nextInt();
        Board b = new Board("coucou", rows, cols);
        DirectionJoueur d = new DirectionJoueur();
        
        b.addHorizontalWall(0, 0, 4);
        b.addVerticalWall(0, 0, 3);
        b.addHorizontalWall(4, 4, 2);
        b.addVerticalWall(4, 3, 3);
        b.addBox(9, 9);
        b.addTarget(1, 2);
        b.setPosition(5, 5);
        b.display();
        d.dialogue(b);
        
    }
}
