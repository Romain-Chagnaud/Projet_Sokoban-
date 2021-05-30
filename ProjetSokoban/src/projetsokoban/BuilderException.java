/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsokoban;

/**
 * classe qui gère les exception pour le BoardBuilder
 * @author romai
 */
class BuilderException extends Exception {

    /**
     * méthode qui crée une exception spécial pour le builder
     * @param message message d'erreur
     */
    public BuilderException(String message) {
        super(message);
    }
}
