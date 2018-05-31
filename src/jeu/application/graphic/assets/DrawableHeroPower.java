/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu.application.graphic.assets;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import jeu.src.IJoueur;

/**
 *
 * @author Thomas
 */
public class DrawableHeroPower extends Parent {
    private ImageView overlay;
    private ImageView inside;
    //private HearthstoneText;
    
    public DrawableHeroPower(IJoueur joueur) {
        overlay = new ImageView(new Image(getClass().getResourceAsStream("/jeu/application/graphic/ressources/image/hero_power.png")));
        inside = new ImageView(new Image(getClass().getResourceAsStream("/jeu/application/graphic/ressources/image/heroPower/" + joueur.getHeros().getNom() +".png")));
        inside.setTranslateX(28);
        inside.setTranslateY(45);
        
        this.getChildren().add(inside);
        this.getChildren().add(overlay);
    }
}
