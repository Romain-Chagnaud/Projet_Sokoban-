/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsokoban;

import com.sun.source.tree.Tree;
import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Classe permet de construire le plateau
 *
 * @author romai
 */
public class Board {

    /**
     * nombre de colonnes
     */
    public int cols;

    /**
     * nombre de lignes
     */
    public int rows;

    /**
     * nom du plateau
     */
    public String names;

    /**
     * tableau à double entrée de caractères
     */
    public char[][] board;

    /**
     * liste de caisse
     */
    ArrayList<Position> box = new ArrayList<>();

    /**
     * liste de cible
     */
    ArrayList<Position> target = new ArrayList<>();

    /**
     * cible de mur
     */
    ArrayList<Position> wall = new ArrayList<>();

    /**
     * position du joueur
     */
    Position posPlayer;

    /**
     * constructeur du board
     * @param name nom du plateau
     * @param row nombre de lignes
     * @param col nombre de colonnes
     */
    public Board(String name, int row, int col) {
        this.names = name;
        this.rows = row;
        this.cols = col;
        board = new char[row][col];
        System.out.println(name);
//        System.out.println("ligne: " + row);
//        System.out.println("colonne: " + col);

    }

    /**
     * méthode qui permet d'afficher le plateau
     */
    public void display() {
        remplirTab();
        System.out.println(" ");
        afficherCols();
        System.out.println(" ");
        afficherRows();

    }

    /**
     * méthode qui permet de remplir le plateau de caractère
     */
    public void remplirTab() {
        for (char[] row : board) { //pour chaque ligne
            Arrays.fill(row, '.'); //remplir une lligne de caractère 
        }

        for (Position mur : wall) {
            board[mur.row][mur.col] = '#';
        }

        for (Position destination : target) {
            board[destination.row][destination.col] = 'X';
        }

        for (Position boite : box) {
            board[boite.row][boite.col] = 'C';
        }

        board[posPlayer.row][posPlayer.col] = 'P';

    }

    /**
     * méthode qui affiche le nombre de ligne du plateau
     */
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
     * méthode qui permet d'afficher les colones du plateau
     */
    private void afficherCols() {
        System.out.print("    ");
        for (int c = 0; c < cols; c++) {
            System.out.print(c + " ");
        }
    }

    /**
     * méthode qui ajoute les murs horizontal au plateau
     * @param x coordonnée x du mur 
     * @param y coordonnée y du mur 
     * @param size taille du mur 
     */
    public void addHorizontalWall(int x, int y, int size) {
        //boucle qui permet de mettre de un mur hozital en fonction 
        //param.

        for (int c = 0; c < size; c++) {
            Position pos = new Position(x, y + c);
            wall.add(pos);
        }
    }

    /**
     * méthode qui ajoute les murs vertical au plateau
     *@param x coordonnée x du mur 
     * @param y coordonnée y du mur 
     * @param size taille du mur 
     */
    public void addVerticalWall(int x, int y, int size) {
        for (int c = 0; c < size; c++) {
            Position pos = new Position(x + c, y);
            wall.add(pos);
        }
    }

    /**
     * méthode qui ajoute une box a une coordonnée donnée
     * @param x coordonnée x d'une caisse 
     * @param y coordonnée y d'une caisse 
     */
    public void addBox(int x, int y) {
        Position pos = new Position(x, y);
        box.add(pos);
    }

    /**
     * méthode qui ajoute un mur a une coordonnée donnée
     * (utiliser pour la seconde partie)
     * @param x coordonnée x du mur 
     * @param y coordonnée y du mur 
     */
    public void addWall(int x, int y) {
        Position pos = new Position(x, y);
        wall.add(pos);
    }

    /**
     * méthode qui ajoute une cible a une coordonnée donnée
     * @param x coordonnée x d'une cible 
     * @param y coordonnée y d'une cible 
     */
    public void addTarget(int x, int y) {
        Position pos = new Position(x, y);
        target.add(pos);
    }

    /**
     * méthode qui ajoute un joueur à une coordonnée donnée
     * @param x coordonnée x du joueur 
     * @param y coordonnée y du joueur 
     */
    public void setPosition(int x, int y) {
        posPlayer = new Position(x, y);
    }

    /**
     * méthode qui permet de voir si le joueur et dans le plateau ou pas
     * @param p position des limite du plateau 
     * @return la position des bord su plateau
     */
    public boolean estDansPlateau(Position p) {
        return (p.row < rows && p.col < cols && p.row >= 0 && p.col >= 0);
    }

    /**
     * méthode qui permet de voir si un joueur et sur une
     * position valide ou pas (soit différent d'un mur ou
     * le joueur n'est pas dans le plateau)
     * @param pos
     * @return
     */
    public boolean valide(Position pos) {
        return estDansPlateau(pos) && !contientMur(pos);
    }

    /**
     * méthode qui prend une position et regarde s'il y a un mur
     * @param pos
     * @return
     */
    public boolean contientMur(Position pos) {
        return wall.contains(pos);
    }

    /**
     * méthode qui vérifie si il y a une victoire ou pas 
     */
    public void checVict() {
        boolean isVict = true;
        for (var p : box) {
            if (!target.contains(p)) {
                isVict = false;
                break;
            }
        }
    }

    /**
     * méthode qui déclenche la victoire 
     * @return vrai si la une caisse et sur une cible 
     */
    public boolean won() {
        for (var c : box) {
            for (var p : target) {
                if (board[c.row][c.col] == board[p.row][p.col]) {
                    return false;
                }
            }
        }
        return true; // vrai si tout les targets sont remplis de caisse. 
    }

    /**
     * méthode qui gére le déplacement du joueur et des caisses
     * @param dir
     * @param pos
     * @return
     */
    public Position next(String dir, Position pos) {
        Position p = null;
        switch (dir) {
            case "U":
                if (pos != null) {
                    p = new Position(pos.row - 1, pos.col); // position dans la casse suivante
                } else {
                    p = new Position(posPlayer.row - 1, posPlayer.col);//position du joueur 
                }
                break;
            case "D":
                if (pos != null) {
                    p = new Position(pos.row + 1, pos.col);
                } else {
                    p = new Position(posPlayer.row + 1, posPlayer.col);
                }
                break;
            case "L":
                if (pos != null) {
                    p = new Position(pos.row, pos.col - 1);
                } else {
                    p = new Position(posPlayer.row, posPlayer.col - 1);
                }
                break;
            case "R":
                if (pos != null) {
                    p = new Position(pos.row, pos.col + 1);
                } else {
                    p = new Position(posPlayer.row, posPlayer.col + 1);
                }
                break;
            default:
                break;

        }
        return p;
    }

    /**
     * méthode qui permet de déplacer les caisses avec le mouvement du joueur
     * @param dir direction donnée par le joeur
     */
    public void deplacement(String dir) {
        Position p = next(dir, null);
        if (valide(p)) { //si dans plateau && pas de mur 

            if (box.contains(p)) { // si il y a une caisse 

                Position posBox = next(dir, p);
                if (valide(posBox)) {
                    box.remove(p);
                    box.add(posBox);
                    setPosition(p.row, p.col);
                    checVict();
                }
            } else {
                setPosition(p.row, p.col);
            }
        }
    }

    /**
     * Permer de reconnaitre les différents caractères du text
     * @param b le board 
     * @param line nombre de ligne dans le text
     * @param y 
     * @throws IOException
     */
    public static void textBoardBuilder(Board b, String line, int y) throws IOException {
        char caractere = 'n';
        for (int x = 0; x < line.length(); x++) {
            caractere = line.charAt(x);
            switch (caractere) {
                case 'P':
                    b.setPosition(y, x);
                    break;
                case 'X':
                    b.addTarget(y, x);
                    break;
                case '#':
                    b.addWall(y, x);
                    break;
                case 'C':
                    b.addBox(y, x);
                    break;
                default:
                    break;
            }
        }
    }   
}
