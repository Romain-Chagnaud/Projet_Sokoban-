/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsokoban;

import com.sun.source.tree.Tree;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.TreeSet;

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
    Position posPlayer;

    public Board(String name, int row, int col) {
        this.names = name;
        this.rows = row;
        this.cols = col;
        board = new char[row][col];
        System.out.println(name);
//        System.out.println("ligne: " + row);
//        System.out.println("colonne: " + col);

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

        board[posPlayer.rows][posPlayer.cols] = 'P';

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
            System.out.print(c + " ");
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

    public void addTarget(int x, int y) {
        Position pos = new Position(x, y);
        target.add(pos);
    }

    public void setPosition(int x, int y) {
        this.posPlayer = new Position(x, y);
    }

    public boolean estDansPlateau(Position p) {
        return (p.rows < cols && p.cols < rows && p.rows >= 0 && p.cols >= 0);
    }

    public char getContenuCase(Position p) {
        return board[p.rows][p.cols];
    }

    public boolean valide() {
        boolean ok = false;
        if (!estDansPlateau(posPlayer)) {
            if (getContenuCase(posPlayer) != board[rows][cols]) {
                ok = false;
                System.err.println("Choix invalide");
            }
        }
        return ok;
    }

//    public boolean obstacle() {
//        boolean lol = false;
//        if (equals(wall)) {
//            if (posPlayer == equals(wall)) {
//                this.posPlayer = new Position(posPlayer.rows, posPlayer.cols);
//                System.err.println("attention au mur !");
//            }
//        }
//        return lol;
//    }
    
    public void checVict(){
        boolean isVict = true;
        for(var p : box){
            if(!target.contains(p)){
                isVict = false;
                break;
            }
        }
    }
    
    public boolean won(){
        boolean vict = false;
        for(var c : box){
            if(target.contains(c)){
                vict = true;
            }
        }
        
        return vict;
    }
    
}
