package jeu.application.graphic;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import jeu.application.graphic.assets.DrawableJoueur;
import jeu.application.graphic.assets.card.DrawableCarte;
import jeu.application.graphic.assets.card.DrawableServiteur;
import jeu.application.graphic.assets.card.DrawableSort;
import jeu.src.Heros;
import jeu.src.Joueur;
import jeu.src.capacite.AttaqueTotale;
import jeu.src.capacite.Cap_Lepreux;
import jeu.src.carte.Serviteur;
import jeu.src.carte.Sort;
import jeu.src.exception.HearthstoneException;

/**
 *
 * @author BAGNATO Thomas
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) throws HearthstoneException {
        primaryStage.setTitle("Hearthstone");               //Window title
        StackPane root = new StackPane();                   //Root group init
        Scene scene = new Scene(root, 1280, 720);           //Scene init
        
        //Elements
        DrawableServiteur carte = new DrawableServiteur(DrawableCarte.CardType.NEUTRAL_MOB, new Serviteur("Gnome Lépreux", 1, null, new Cap_Lepreux(), 1, 1));
        carte.setTranslateX(-300);
        root.getChildren().add(carte);
        
        DrawableSort carte2 = new DrawableSort(DrawableCarte.CardType.MAGE_SPELL, new Sort("Choc de flammes", 7, null, new AttaqueTotale("Attaque Massive", "Inflige 4 points de dégat aux serviteurs adverses", 4)));
        root.getChildren().add(carte2);
        
        //DrawableServiteur carte3 = new DrawableServiteur(DrawableCarte.CardType.NEUTRAL_MOB, new Serviteur("Missilière Téméraire", 1, null, null, 1, 1));
        //carte3.setTranslateX(300);
        //root.getChildren().add(carte3);
        
        DrawableJoueur j1 = new DrawableJoueur(new Joueur("LeoTheUnseen", Heros.getHeros("Jaina") ));
        root.getChildren().add(j1);
        j1.setTranslateX(400);
        
        //Display
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
