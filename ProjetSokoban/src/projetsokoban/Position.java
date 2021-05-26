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
public class Position {

    public int col;
    public int row;

    public Position(int row, int col) {
        this.col = col;
        this.row = row;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.col;
        hash = 59 * hash + this.row;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (this.col != other.col) {
            return false;
        }
        if (this.row != other.row) {
            return false;
        }
        return true;
    }

}
