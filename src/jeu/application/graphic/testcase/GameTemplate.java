/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu.application.graphic.testcase;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jeu.application.graphic.assets.HearthstoneText;
import jeu.application.graphic.assets.PlayerField;
import jeu.src.heros.Heros;
import jeu.src.Joueur;
import jeu.src.exception.HearthstoneException;
import jeu.src.heros.Jaina;

/**
 *
 * @author Thomas
 */
public class GameTemplate extends Application {
    private static final int WINDOW_WIDTH = 1280;
    private static final int WINDOW_HEIGHT = 720;
    
    @Override
    public void start(Stage primaryStage) {
        //primaryStage.setResizable(false);
        
        StackPane root = new StackPane();
        root.setBackground(new Background(new BackgroundImage(new Image(getClass().getResourceAsStream("/jeu/application/graphic/ressources/image/game_overlay.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        
        
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        primaryStage.setTitle("Game Overlay");
        primaryStage.setScene(scene);
        
        
        VBox battlefield = new VBox();
        battlefield.setMaxWidth((4*scene.getWidth())/6);
        battlefield.setMaxHeight(WINDOW_HEIGHT);
        //battlefield.setBackground(new Background(new BackgroundFill(Color.BEIGE, CornerRadii.EMPTY, Insets.EMPTY)));
        
        PlayerField advField = null;
        PlayerField playerField = null;
        advField = new PlayerField(new Joueur("SuperGay", new Jaina() ));
        advField.setAlignment(Pos.BOTTOM_LEFT);
        playerField = new PlayerField(new Joueur("oui", new Jaina() ));
        //HBox playerField = new HBox();
        //playerField.setBackground(new Background(new BackgroundFill(Color.BLUEVIOLET, CornerRadii.EMPTY, Insets.EMPTY)));
        //playerField.setPrefHeight(WINDOW_HEIGHT/2);
        
        //VBox leftPart = new VBox();
        //leftPart.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD, CornerRadii.EMPTY, Insets.EMPTY)));
        
        //VBox rightPart = new VBox();
        //rightPart.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD, CornerRadii.EMPTY, Insets.EMPTY)));
        //rightPart.setAlignment(Pos.BOTTOM_LEFT);
        
        
        
        //VBox middlePart = new VBox();
        
        
        //playerField.getChildren().add(leftPart);
        //playerField.getChildren().add(middlePart);
        //playerField.getChildren().add(rightPart);
        
        //HearthstoneText tests = new HearthstoneText("non", 100, 100, 50, 50, 40);
        //advField.getChildren().add(tests);
        
        battlefield.getChildren().add(advField);
        battlefield.getChildren().add(playerField);
        
        root.getChildren().add(battlefield);
        
        //Display
        primaryStage.show();
        for(Node n : battlefield.getChildren()) {
            if (n instanceof PlayerField) ((PlayerField) n).resize();
            System.out.println(n.getLayoutBounds().getWidth());
        }
        
        //Resize
        //leftPart.setPrefWidth(playerField.getWidth()/3);
        //middlePart.setPrefWidth((2*playerField.getWidth())/3);
        //rightPart.setPrefWidth(Math.floor(playerField.getWidth()/3));   //Remove extra pixel
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
