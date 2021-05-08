/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsokoban;

/**
 *
 * @author romai
 */
public class Player {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Board b = new Board(" coucou ", 50, 15);
        b.display();
        b.addHorizontalWall(2, 1, 3);
    }
    
}
