/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsokoban;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author romai
 */
public class Administrator {

    static Scanner popopo = new Scanner(System.in);

    public static void main(String[] args) {
        String chemin = "data/librairie.sqlite3";
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

    private static void dialoguer(Connection c) throws SQLException {
        boolean encore = true;
        while (encore) {
            System.out.println("ADMINISTRATION INTERFACE - USE WITH CAUTION :");
            System.out.println("1. Creation d'une nouvelle database: ");
            System.out.println("2. Lister board");
            System.out.println("3. Voir Board");
            System.out.println("4. Ajouter board avec un fichier");
            System.out.println("5. Supprimer board depuis la base");
            System.out.println("6 Quitter");

            String commande = enleverEspaces(popopo.nextLine());
            System.out.println();

            switch (commande) {
                case "6":
                    encore = false;
                    break;
                case "1":
                    //TODO  
                    break;
                case "2":
                    //TODO
                    break;
                case "3":
                    //TODO
                    break;
                case "4":
                    //TODO
                    break;
                case "5":
                    //TODO
                    break;
                default:
                    System.out.println("commande inconnue : " + commande);
            }
        }

    }

    private static String enleverEspaces(String string) {
        return string.replaceAll("\\s+", "").toLowerCase();

    }
}
