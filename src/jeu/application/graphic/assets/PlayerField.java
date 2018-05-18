/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu.application.graphic.assets;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import jeu.src.IJoueur;

/**
 *
 * @author Thomas
 */
public class PlayerField extends HBox {
    private IJoueur joueur;
    
    private DrawableJoueur dJoueur;
    
    private VBox leftPart;
    private VBox middlePart;
    private VBox rightPart;
    
    private DrawableHeroPower dHP;
    
    private ImageView manaCristal;
    private HearthstoneText mana;
    
    public PlayerField(IJoueur j) {
        joueur     = j;
        dJoueur    = new DrawableJoueur(j);
        leftPart   = new VBox();
        middlePart = new VBox();
        rightPart  = new VBox();
        
        middlePart.setAlignment(Pos.BOTTOM_LEFT);
        
        HBox handSpace = new HBox();
        HBox heroSpace = new HBox();
        
        //dHP = new DrawableHeroPower();
        
        handSpace.setStyle("-fx-background-color : rgba(100,100,0,0.5)");
        heroSpace.setStyle("-fx-background-color : rgba(0,100,100,0.5)");
        
        heroSpace.setAlignment(Pos.BOTTOM_RIGHT);
        //this.setBackground(new Background(new BackgroundFill(Color.CHARTREUSE, CornerRadii.EMPTY, Insets.EMPTY)));
        leftPart.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD, CornerRadii.EMPTY, Insets.EMPTY)));
        rightPart.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD, CornerRadii.EMPTY, Insets.EMPTY)));
        //leftPart.setPrefWidth(this.getParent().getLayoutBounds().getWidth()/3);
        
        heroSpace.getChildren().add(dHP);
        heroSpace.getChildren().add(dJoueur);
        
        middlePart.getChildren().add(handSpace);
        middlePart.getChildren().add(heroSpace);
        
        this.getChildren().add(leftPart);
        this.getChildren().add(middlePart);
        this.getChildren().add(rightPart);
    }
    
    public void resize() {
        this.setPrefHeight(this.getParent().getLayoutBounds().getHeight()/2);
        leftPart.setPrefWidth(this.getParent().getLayoutBounds().getWidth()/4);
        middlePart.setPrefWidth(this.getParent().getLayoutBounds().getWidth()/2);
        rightPart.setPrefWidth(Math.floor(this.getParent().getLayoutBounds().getWidth()/4));
        dJoueur.setScaleX(0.3);
        dJoueur.setScaleY(0.3);
        
        dHP.setScaleX(0.5);
        dHP.setScaleY(0.5);
        
        
        for (Node n : middlePart.getChildren()) {
            ((Pane) n).setPrefHeight(middlePart.getWidth()/3);
        }
    }
}
