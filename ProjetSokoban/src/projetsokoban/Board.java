/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsokoban;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 *
 * @author romai
 */
public class Board {

    public int cols;
    public int rows;
    public String names;
    public char[][] board;
    ArrayList<Position> box = new ArrayList<>();
    ArrayList<Position> target = new ArrayList<>();
    ArrayList<Position> wall = new ArrayList<>();
    ArrayList<Position> charcter = new ArrayList<>();

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
        remplirTab();
        System.out.println(" ");
        afficherCols();
        System.out.println(" ");
        afficherRows();

    }

    public void remplirTab() {
        for (char[] row : board) { //pour chaque ligne
            Arrays.fill(row, '.'); //remplir une lligne de caractère 
        }
        for (Position boite : box) {
            board[boite.rows][boite.cols] = 'c';
        }

        for (Position destination : target) {
            board[destination.rows][destination.cols] = 'X';
        }

        for (Position mur : wall) {
            board[mur.rows][mur.cols] = '#';
        }
        
        for (Position perso : charcter) {
            board[perso.rows][perso.cols] = 'P';
        }
        
    }

    private void afficherRows() {
        for (int r = 0; r < rows; r++) {
            System.out.print(r + " ");
            if (r <= 9) {
                System.out.print(" ");
            }
            for (int c = 0; c < cols; c++) {
                System.out.print(" " + board[r][c]);
                if (c >= 9) {
                    System.out.print(" ");
                }
            }
            System.out.println(" ");
        }
    }

    /**
     * Permet d'afficher les colones
     */
    private void afficherCols() {
        System.out.print("    ");
        for (int c = 0; c < cols; c++) {
            System.out.print(c + " " );
        }
    }

    public void addHorizontalWall(int x, int y, int size) {
        //boucle qui permet de mettre de un mur hozital en fonction 
        //param.

        for (int c = 0; c < size; c++) {
            Position pos = new Position(x, y + c);
            wall.add(pos);
        }
    }

    public void addVerticalWall(int x, int y, int size) {
        for (int c = 0; c < size; c++) {
            Position pos = new Position(x + c, y);
            wall.add(pos);
        }
    }

    public void addBox(int x, int y) {
        Position pos = new Position(x, y);
        box.add(pos);
    }

    public void addTarget(int row, int col) {
        Position pos = new Position(row, col);
        target.add(pos);
    }

    public void setPosition(int x, int y) {
        Position pos = new Position(x, y);
        charcter.add(pos);
    }
}
