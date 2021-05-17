/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsokoban;

import java.util.ArrayList;

/**
 *
 * @author romai
 */
public class Direction {
//    public enum Directions{
//        Haut, Bas, Gauche, Droite
//    }
    
//    public Direction Haut;
//    public Direction Bas;
//    public Direction Droite;
//    public Direction Gauche;
    
    ArrayList<Position> charcter = new ArrayList<>();
    
    public void deplacementJoueur(int x, int y){
        Position pos = new Position(x, y);
        charcter.add(pos);
    }
}
