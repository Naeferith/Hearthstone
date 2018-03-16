/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu.src.capacite;

/**
 *
 * @author bagnato2u
 */
public abstract class Attaque extends Capacite {
    protected int damage;

    public Attaque(String nom, String description, int damage) {
        super(nom, description);
        this.damage = damage;
    } 
    
}
