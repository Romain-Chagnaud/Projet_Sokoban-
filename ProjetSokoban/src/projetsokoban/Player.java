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

        Board b = new Board("coucou", 10, 10);
        DirectionJoueur d = new DirectionJoueur();

        b.addHorizontalWall(0, 0, 3);
        b.addVerticalWall(0, 0, 4);
        b.addHorizontalWall(1, 0, 2);
        b.addVerticalWall(1, 2, 2);
        b.addBox(4, 5);
        b.addBox(2, 3);
        b.addBox(5, 5);
        b.addTarget(5, 5);
        b.setPosition(2, 2);
        b.display();
        play(b, d);
    }
    public static void play(Board b, DirectionJoueur d){
        boolean quit = false;
        while(!quit){
            d.dialogue(b);
            b.display();
            b.valide();
            
            if(quit){
                System.out.println("Abadon du Joueur");
                Player.over = true;
            }else{
                quit = b.won();
                if(quit){
                    System.out.println("Vous avez Gagné");
                }
            }
        }
    }
}
