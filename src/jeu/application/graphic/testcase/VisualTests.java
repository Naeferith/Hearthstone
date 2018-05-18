package jeu.application.graphic.testcase;

import javafx.animation.*;
import javafx.application.Application;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleLongProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.CacheHint;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import jeu.application.graphic.assets.DrawableHeroPower;
import jeu.application.graphic.assets.DrawableJoueur;
import jeu.application.graphic.assets.HearthstoneDisclaimer;
import jeu.application.graphic.assets.card.DrawableCarte;
import jeu.application.graphic.assets.card.DrawableServiteur;
import jeu.application.graphic.assets.card.DrawableSort;
import jeu.src.Heros;
import jeu.src.IJoueur;
import jeu.src.Joueur;
import jeu.src.capacite.AttaqueTotale;
import jeu.src.capacite.Cap_Lepreux;
import jeu.src.carte.Serviteur;
import jeu.src.carte.Sort;
import jeu.src.exception.HearthstoneException;

/**
 *
 * @author Thømas
 */
public class VisualTests extends Application {
    public static final int WINDOW_HEIGHT = 720;
    public static final int WINDOW_WIDTH  = 1280;
    public static final int PANNEL_WIDTH  = 200;
        
    private final FrameStats frameStats = new FrameStats() ;
    VBox btnList = new VBox();
    Pane visualContainer;
    int i = 0;
    
    
    @Override
    public void start(Stage primaryStage) throws HearthstoneException {
        primaryStage.setTitle("Hearthstone - Visual Tests");               //Window title
        BorderPane root = new BorderPane();                 //Root group init
        root.setBackground(new Background(new BackgroundFill(Color.BISQUE, CornerRadii.EMPTY, Insets.EMPTY)));
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);           //Scene init
        
        visualContainer = new Pane();
        root.setCenter(visualContainer);
        
        final Label stats = new Label() ;
        stats.textProperty().bind(frameStats.textProperty());
        root.setBottom(stats);

        
        
        //List des boutons
        btnList.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        root.setLeft(btnList);
        
        //Elements throwing Hearthstone exeption
        IJoueur joueur = new Joueur("LeoTheUnseen", Heros.getHeros("Jaina"));
        DrawableJoueur j1 = new DrawableJoueur(joueur);
        DrawableHeroPower hp1 = new DrawableHeroPower(joueur);
        
        //Boutons
        VisualButton btn = new VisualButton("Serviteur");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                clearVisual(visualContainer);
                DrawableServiteur carte = new DrawableServiteur(DrawableCarte.CardType.NEUTRAL_MOB, new Serviteur("Gnome Lépreux", 1, null, new Cap_Lepreux(), 1, 1));
                carte.setTranslateX((WINDOW_WIDTH - carte.getLayoutBounds().getWidth())/2 - carte.getLayoutBounds().getWidth()/2);
                carte.setTranslateY((WINDOW_HEIGHT - carte.getLayoutBounds().getHeight())/2);
                visualContainer.getChildren().add(carte);
            }
        });
        
        VisualButton fdth = new VisualButton("From Deck To Hand");
        fdth.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                clearVisual(visualContainer);
                DrawableSort carte = new DrawableSort(DrawableCarte.CardType.MAGE_SPELL, new Sort("Choc de flammes", 7, null, new AttaqueTotale("Attaque Massive", "Inflige 4 points de dégat aux serviteurs adverses", 4)));
                carte.setTranslateX((WINDOW_WIDTH - carte.getLayoutBounds().getWidth())/2 - carte.getLayoutBounds().getWidth()/2);
                carte.setTranslateY((WINDOW_HEIGHT - carte.getLayoutBounds().getHeight())/2);
                carte.setCache(true);
                carte.setCacheHint(CacheHint.SPEED);
                visualContainer.getChildren().add(carte);
                
                fdthAnimation(carte);
            }
        });
        
        VisualButton btn2 = new VisualButton("Sort");
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                clearVisual(visualContainer);
                DrawableSort carte = new DrawableSort(DrawableCarte.CardType.MAGE_SPELL, new Sort("Choc de flammes", 7, null, new AttaqueTotale("Attaque Massive", "Inflige 4 points de dégat aux serviteurs adverses", 4)));
                carte.setTranslateX((WINDOW_WIDTH - carte.getLayoutBounds().getWidth())/2 - carte.getLayoutBounds().getWidth()/2);
                carte.setTranslateY((WINDOW_HEIGHT - carte.getLayoutBounds().getHeight())/2);
                visualContainer.getChildren().add(carte);
            }
        });
        
        VisualButton btn3 = new VisualButton("Heros");
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                clearVisual(visualContainer);
                j1.setTranslateX((WINDOW_WIDTH - j1.getLayoutBounds().getWidth())/2 - j1.getLayoutBounds().getWidth()/2);
                j1.setTranslateY((WINDOW_HEIGHT - j1.getLayoutBounds().getHeight())/2);
                visualContainer.getChildren().add(j1);
            }
        });
        
        
        VisualButton btn4 = new VisualButton("Exception Disclaimer");
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                clearVisual(visualContainer);
                HearthstoneDisclaimer item = new HearthstoneDisclaimer("Ceci est une exception");
                item.setEffect(new Glow(0.9));
                item.setTranslateX((WINDOW_WIDTH - item.getLayoutBounds().getWidth())/2 - item.getLayoutBounds().getWidth()/2);
                item.setTranslateY((WINDOW_HEIGHT - item.getLayoutBounds().getHeight())/2);
                item.setCache(true);
                item.setCacheHint(CacheHint.SPEED);
                visualContainer.getChildren().add(item);
                
                ExceptionAnimation(item);
            }
        });
        
        VisualButton btn5 = new VisualButton("HeroPower");
        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                clearVisual(visualContainer);
                hp1.setTranslateX((WINDOW_WIDTH - hp1.getLayoutBounds().getWidth())/2 - hp1.getLayoutBounds().getWidth()/2);
                hp1.setTranslateY((WINDOW_HEIGHT - hp1.getLayoutBounds().getHeight())/2);
                visualContainer.getChildren().add(hp1);
            }
        });
        
        
        //Init
        DrawableServiteur carte = new DrawableServiteur(DrawableCarte.CardType.NEUTRAL_MOB, new Serviteur("Gnome Lépreux", 1, null, new Cap_Lepreux(), 1, 1));
        carte.setTranslateX((WINDOW_WIDTH - carte.getLayoutBounds().getWidth())/2 - carte.getLayoutBounds().getWidth()/2);
        carte.setTranslateY((WINDOW_HEIGHT - carte.getLayoutBounds().getHeight())/2);
        visualContainer.getChildren().add(carte);

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
    
    
    private static void clearVisual(Pane root) {
        if (root.getChildren().get(root.getChildren().size() -1).isCache()) root.getChildren().get(root.getChildren().size() -1).setCache(false);
        root.getChildren().remove(root.getChildren().size()-1);
    }
    
    
    public void fdthAnimation(Parent carte) {
        final LongProperty lastUpdateTime = new SimpleLongProperty(0);
        final AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long timestamp) {
                if (lastUpdateTime.get() > 0) {
                    long elapsedTime = timestamp - lastUpdateTime.get();
                    carte.setTranslateX(i++);
                    frameStats.addFrame(elapsedTime);
                }
                lastUpdateTime.set(timestamp);
            }

        };
        timer.start();
    }
    
    private void ExceptionAnimation(HearthstoneDisclaimer h) {
        Timeline  timeline = new Timeline();
        timeline.getKeyFrames().addAll(
            new KeyFrame(Duration.ZERO, new KeyValue(h.opacityProperty(), 0)),
            new KeyFrame(new Duration(1000), new KeyValue(h.opacityProperty(), 1)),
            new KeyFrame(new Duration(3000), new KeyValue(h.opacityProperty(), 1)),
            new KeyFrame(new Duration(4000), new KeyValue(h.opacityProperty(), 0))
        );
        timeline.play();
    }
    
    private class VisualButton extends Button {

        public VisualButton(String name) {
            this.setText(name);
            this.setMinWidth(PANNEL_WIDTH);
            btnList.getChildren().add(this);
        }
    }
    
    private static class FrameStats {
        private long frameCount ;
        private double meanFrameInterval ; // millis
        private final ReadOnlyStringWrapper text = new ReadOnlyStringWrapper(this, "text", "Frame count: 0 Average frame interval: N/A");
        
        public long getFrameCount() {
            return frameCount;
        }
        public double getMeanFrameInterval() {
            return meanFrameInterval;
        }
        
        public void addFrame(long frameDurationNanos) {
            meanFrameInterval = (meanFrameInterval * frameCount + frameDurationNanos / 1_000_000.0) / (frameCount + 1) ;
            frameCount++ ;
            text.set(toString());
        }
        
        public String getText() {
            return text.get();
        }
        
        public ReadOnlyStringProperty textProperty() {
            return text.getReadOnlyProperty() ;
        }
        
        @Override
        public String toString() {
            return String.format("Frame count: %,d Average frame interval: %.3f milliseconds", getFrameCount(), getMeanFrameInterval());
        }
    }
}
