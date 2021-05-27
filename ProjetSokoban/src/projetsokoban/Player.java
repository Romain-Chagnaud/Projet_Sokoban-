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
    public static void main(String[] args) throws BuilderException {

        Board b = new Board("coucou", 10, 10);
        DirectionJoueur d = new DirectionJoueur();
        /*
        b.addHorizontalWall(0, 0, 10);
        b.addVerticalWall(0, 0, 10);
        b.addHorizontalWall(9, 0, 10);
        b.addVerticalWall(0, 9, 10);
        b.addBox(4, 5);
        b.addBox(2, 3);
        b.addBox(5, 5);
        b.addTarget(5, 5);
        b.setPosition(3, 3);
//        b.display();
//        play(b, d);
*/      
        b = textBoardBuilder();
        b.display();
        
//        FileBuilder lol = new FileBuilder();
//        b = lol.fileBuilder();
//        b.display();
    }

    public static void play(Board b, DirectionJoueur d) {
        boolean quit = false;
        while (!quit) {
            d.dialogue(b);
            b.display();

            if (quit) {
                System.out.println("Abadon du Joueur");
                Player.over = true;
            } else {
                quit = b.won();
                if (quit) {
                    System.out.println("Vous avez Gagné");
                }
            }
        }
    }

    public static Board textBoardBuilder() throws BuilderException {
        var builder = new TextBoardBuilder("A Simple Board");
        builder.addRows("##########");
        builder.addRows("#X.X#....#");
        builder.addRows("#...CC.P.#");
        builder.addRows("#........#");
        builder.addRows("##########");
        Board b = builder.build();
        return b;

    }

}
