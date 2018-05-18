package jeu.application.graphic;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import jeu.application.graphic.assets.DrawableJoueur;
import jeu.application.graphic.assets.card.DrawableCarte;
import jeu.application.graphic.assets.card.DrawableServiteur;
import jeu.application.graphic.assets.card.DrawableSort;
import static jeu.application.graphic.testcase.VisualTests.WINDOW_HEIGHT;
import static jeu.application.graphic.testcase.VisualTests.WINDOW_WIDTH;
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
        
        
        
        root.setBackground(new Background(new BackgroundImage(new Image(getClass().getResourceAsStream("/jeu/application/graphic/ressources/image/bg.jpg")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        //root.setStyle("-fx-background-size : 100%");
        Scene scene = new Scene(root, 1280, 720);           //Scene init
        
        VBox btnList = new VBox();
        btnList.setTranslateX(WINDOW_WIDTH/3);
        btnList.setTranslateY(WINDOW_HEIGHT/3);
        btnList.setPrefWidth(WINDOW_WIDTH/3);
        
        Button btnPlay = new Button("Jouer");
        btnPlay.setPrefWidth(WINDOW_WIDTH/3);
        btnPlay.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
            }
        });
        
        btnList.getChildren().add(btnPlay);
        
        
        
        //Ajout liste bouton
        root.getChildren().add(btnList);
        
        primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> {
            btnList.setTranslateX((Double) newVal/3);
            btnList.setPrefWidth((Double) newVal/3);
            for(Node b : btnList.getChildren()) ((Button) b).setPrefWidth((Double) newVal/3);
        });

        primaryStage.heightProperty().addListener((obs, oldVal, newVal) -> {
            btnList.setTranslateY((Double) newVal/3);
        });
        
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
