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
public class Board {

    public int cols;
    public int rows;
    public String names;
    public char[][] board;

    public Board(String name, int row, int col) {
        this.names = name;
        this.rows = row;
        this.cols = col;

        board = new char[row][col];

    }

    public void display() {
        afficherRows();
        System.out.println(" ");
        afficherCols();
    }

    private void afficherRows() {
        
        System.out.print("    ");
        for (int c = 0; c < cols; c++) {
            System.out.print(c + " ");
        }
    }
    
     private void afficherCols() {
       for (int r = 0; r < rows; r++) {
            System.out.print(r + " ");
            if (r <= 9) {
                System.out.print(" ");
            }
            System.out.print(" ");
            for (int c = 1; c < cols; c++) {
                System.out.print("  ");
            }
            System.out.println(" ");
        }
    }
    

}
