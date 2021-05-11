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
public class Player {

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
       
        b.addHorizontalWall(2, 2, 3);
       b.addBox(0, 0);
       b.addTarget(1, 2);
        b.display();

    }

}
