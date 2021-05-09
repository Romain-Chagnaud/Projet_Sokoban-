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
        System.out.println(name);
        System.out.println("ligne: " + row);
        System.out.println("colonne: " + col);

    }


    public void display() {
        System.out.println(" ");
        afficherRows();
        System.out.println(" ");
        Bar();
        afficherCols();
        Bar();
    }

    private void afficherCols() {
        for (int r = 0; r < cols; r++) {
            System.out.print(r);
            if (r <= 9) {
                System.out.print(" ");
            }
            if (r <= 99) {
                System.out.print(" ");
            }
            System.out.print("|");
            for (int c = 0; c < rows; c++) {
                System.out.print("  ");
                if (c > 9) {
                    System.out.print(" ");
                }
                if (c > 99) {
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }
    }

    /**
     * affiche la barre "+----+"
     */
    private void Bar() {

        System.out.print("   " + "+");
        for (int c = 0; c < rows; c++) {
            System.out.print("--");
            if (c > 9) {
                System.out.print("-");
            }
            if (c > 99) {
                System.out.print("-");
            }
        }
        System.out.println("+");
    }

    /**
     *
     */
    private void afficherRows() {
        System.out.print("    ");
        for (int c = 0; c < rows; c++) {
            System.out.print(c + " ");
        }
    }

    public void addHorizontalWall(int row, int col, int size) {
        System.out.println("#");
    }

}
