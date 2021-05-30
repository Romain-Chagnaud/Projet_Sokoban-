/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsokoban;

import java.beans.Statement;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.DatabaseMetaData;

/**
 *
 * @author romai
 */
public class Administrator {

    static Scanner popopo = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String chemin = "librairie.sqlite3";
        String URL = "jdbc:sqlite:" + chemin;
        chargerPiloteSQLite();
        try (Connection connexion = DriverManager.getConnection(URL)) {
            preparerRequetes(connexion);
            dialoguer(connexion);
        } catch (SQLException ex) {
            System.err.println("* Base " + URL + " introuvable.");
        }
    }

    private static void chargerPiloteSQLite() {
        String sqlite_driver = "org.sqlite.JDBC";
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            System.err.println("* Driver " + sqlite_driver + " introuvable.");
            System.exit(1);
        }
    }

    private static void preparerRequetes(Connection c) {
        // Preparer une requete
        // "select * from livres where id = ?"
    }

    private static void dialoguer(Connection c) throws SQLException, IOException {
        boolean encore = true;
        while (encore) {
            System.out.println("ADMINISTRATION INTERFACE - USE WITH CAUTION :");
            System.out.println("1. Creation d'une nouvelle database: ");
            System.out.println("2. Lister board");
            System.out.println("3. Voir Board");
            System.out.println("4. Ajouter board avec un fichier");
            System.out.println("5. Supprimer board depuis la base");
            System.out.println("6 Quitter");

            String commande = enleveEspaces(popopo.nextLine());
           Board b = new Board("coucou", 10, 10);

            switch (commande) {
                case "6":
                    encore = false;
                    break;                  
                case "1":
                    
                    break;
                case "2":
                    
                    break;
                case "3":
                    
                    break;
                case "4":
                    add("hey",b);
                    b.display();
                    break;
                case "5":
                    
                    break;
                default:
                    System.out.println("commande inconnue : " + commande);
            }
        }

    }

    private static String enleveEspaces(String string) {
        return string.replaceAll("\\s+", "").toLowerCase();

    }
    
     public static void creationBase(Board b) throws SQLException {
         
     }
     
     private static void add(String id, Board b)throws SQLException, FileNotFoundException, IOException{      
         String ligne;
         id = "C:\\Users\\romai\\Documents\\S2_IUT\\TPS2\\UE21\\M2103_P_O_O\\Projet Sokoban\\ProjetSokoban\\Prog.txt";
        BufferedReader in = new BufferedReader(new FileReader(id));
        int r = 0;
        while ((ligne = in.readLine()) != null) {
            Board.textBoardBuilder(b, ligne, r);
            r++;
        }
        in.close();
    }
     
   private void remove(String id)throws SQLException{
         
     }
     
//     Board get(String id)throws SQLException{
//         Board c = new Board(id, c.rows, c.cols);
//         return c;
//     }
//     
}
