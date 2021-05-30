/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsokoban;

import java.awt.Dialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Classe qui permet de lancer le jeu et la lecture du jeu depuis un fichier
 *
 * @author romai
 */
public class Player {

    public static boolean over;

    /**
     * @param args the command line arguments
     * @throws projetsokoban.BuilderException
     */
    public static void main(String[] args) throws BuilderException, IOException {
        Board b = new Board("coucou", 10, 10);
        DirectionJoueur d = new DirectionJoueur();
        b.addHorizontalWall(9, 0, 9);
        b.addHorizontalWall(0, 1, 9);
        b.addVerticalWall(0, 0, 10);
        b.addVerticalWall(0, 9, 10);
        b.addBox(2, 1);
        b.addTarget(3, 1);
        b.setPosition(3, 4);
        b.display();
        play(b, d);
//        fileBoardBuilder(b);
//        b.display();

    }

    /**
     * Méthode qui gère la boucle du jeu
     *
     * @param b le board sur le lequel on joue
     * @param d permet le déplacement du joueur
     */
    public static void play(Board b, DirectionJoueur d) {
        boolean quit = false;
        while (!quit) {
            d.dialogue(b);
            b.display();
            
            quit = !b.won();
            if (quit) {
                System.out.println("Vous avez Gagné");
            }
        }
    }

    /**
     * Méthode permetant l'affichage d'un fichier texte choisi
     *
     * @param b le board sur le lequel va être afficher notre fichier
     * @throws IOException exception levé
     */
    public static void fileBoardBuilder(Board b) throws IOException {
        String ligne;
        BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\romai\\Documents\\S2_IUT\\TPS2\\UE21\\M2103_P_O_O\\Projet Sokoban\\ProjetSokoban\\Prog.txt"));
        int r = 0;
        while ((ligne = in.readLine()) != null) {
            Board.textBoardBuilder(b, ligne, r);
            r++;
        }
        in.close();
    }
}
