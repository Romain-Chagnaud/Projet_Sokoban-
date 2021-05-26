/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsokoban;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author romai
 */
public class TextBoardBuilder implements BoardBuilder {

    String nom;
    String niveau = " ";
    int col;
    int row;

    public TextBoardBuilder(String name) {
        this.nom = name;
    }

    //ajoute une ligne au plateau 
    void addRows(String mot) {
        row++;
        col = nom.length();
        niveau = niveau.concat(mot);
    }

    @Override
    public Board build() throws BuilderException {
        Board b = new Board(nom, row, col);
        int x = 0;
        for (int r = 0; r < row; r++) {
            for (int d = 0; d < col; d++) {
                char sos = niveau.charAt(x);
                x++;
                switch (x) {
                    case '#':
                        b.addHorizontalWall(r, d, 1);
                        break;
                    case 'P':
                        b.setPosition(r, d);
                        break;
                    case '.':
                        b.board[r][d] = '.';
                        break;
                    case 'c':
                        b.addBox(r, d);
                        break;
                    case 'X':
                        b.addTarget(r, d);
                        break;
                    default:
                }
            }
        }
        return b;
    } 
}
