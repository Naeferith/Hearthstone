package jeu.application.graphic.assets.card;


import javafx.animation.AnimationTimer;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.Transition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jeu.application.graphic.assets.HearthstoneText;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;
import jeu.src.carte.ICarte;

/**
 *
 * @author Thømas
 */
public abstract class DrawableCarte extends Parent {
    
    public static enum CardType {
        NEUTRAL_MOB  ("neutral_mob"),
        NEUTRAL_SPELL("neutral_spell"),
        HUNTER_MOB   ("hunter_mob"),
        HUNTER_SPELL ("hunter_spell"),
        MAGE_MOB     ("mage_mob"),
        MAGE_SPELL   ("mage_spell");
        
        private final String text;
        
        CardType (final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }
    
    protected final ObservableList<Text> parts = FXCollections.observableArrayList();
    protected final ObservableList<PathTransition> transitions = FXCollections.observableArrayList();
    
    protected ICarte carte;
    private ImageView cardOverlay;
    protected ImageView illustration;
    protected HearthstoneText _mana;
    protected Text description;
    //private CardNameLabel cardName;
    
    protected final double CARD_W;
    protected final double CARD_H;
    
    public DrawableCarte(CardType type, ICarte carte) {
        this.carte = carte;
        Image img = new Image(getClass().getResourceAsStream("/jeu/application/graphic/ressources/image/"+ type +".png"));
        CARD_H = img.getHeight();
        CARD_W = img.getWidth();
        
        //debug
        //Rectangle debug = new Rectangle(CARD_W, CARD_H, Color.BISQUE);
        //this.getChildren().add(debug);
        
        illustration = new ImageView(new Image(getClass().getResourceAsStream("/jeu/application/graphic/ressources/image/"+ carte.getNom() +".png")));
        this.getChildren().add(illustration);
        
        cardOverlay = new ImageView(img);
        this.getChildren().add(cardOverlay);
        
        //CubicCurve txtCurve = new CubicCurve((CARD_W-width)/2, 192, CARD_W/2, 180, CARD_W/2 + 40, 160, CARD_W - ((CARD_W-width)/2), 185);
        //this.getChildren().add(txtCurve);
        
        this.getChildren().addAll(getCardName());
        
        description = new Text("");
        if (carte.getCapacite() != null) {
            description.setText(carte.getCapacite().getDescription());
            description.setFont(Font.font(14));
            description.setTranslateX(52);
            description.setTranslateY(250);
            description.setTextAlignment(TextAlignment.CENTER);
        }
        this.getChildren().add(description);
        
        _mana = new HearthstoneText(Integer.toString(carte.getCout()), 0, 0, 50, 50, 40);
        this.getChildren().add(_mana);
        
    }
    
    protected ObservableList<Text> getCardName() {
        final Text text = new Text(carte.getNom());
        text.setFont(Font.loadFont(getClass().getResourceAsStream("/jeu/application/graphic/ressources/font/BelweBdBTBold.ttf"), 18));
        text.setStrokeWidth(2);
        text.setStrokeType(StrokeType.OUTSIDE);
        final double width = text.getLayoutBounds().getWidth();
        
        
        //final Text space = new Text(" ");
        //text.setFont(Font.loadFont(getClass().getResourceAsStream("/jeu/application/graphic/ressources/font/BelweBdBTBold.ttf"), 18));
        //text.setStrokeWidth(2);
        //text.setStrokeType(StrokeType.OUTSIDE);
        //final double spacewidth = text.getLayoutBounds().getWidth();
        
        //while (text.getLayoutBounds().getWidth() < CARD_W) text.setText(" " + text.getText() + " ");
        
        final CubicCurve curve = new CubicCurve((CARD_W-width)/2, 192, CARD_W/2, 180, CARD_W/2 + 40, 160, CARD_W - ((CARD_W-width)/2) + 20, 185);
        
        for (char character : text.textProperty().get().toCharArray()) {
            Text part = new Text(character + "");
            part.setFill(Color.WHITE);
            part.setFont(Font.loadFont(getClass().getResourceAsStream("/jeu/application/graphic/ressources/font/BelweBdBTBold.ttf"), 18));
            part.setStroke(Color.BLACK);
            part.setStrokeWidth(2);
            part.setStrokeType(StrokeType.OUTSIDE);
            parts.add(part);
            part.setVisible(false);

            transitions.add(createPathTransition(curve, part));
        }
        
        for (int i = 0; i < parts.size(); i++) {
            parts.get(i).setVisible(true);
            final Transition transition = transitions.get(i);
            transition.stop();
            transition.jumpTo(Duration.seconds(10).multiply((i + 0.5) * 1 / parts.size()));
            // just play a single animation frame to display the curved text, then stop
            AnimationTimer timer = new AnimationTimer() {
                int frameCounter = 0;

                @Override
                public void handle(long l) {
                    frameCounter++;
                    if (frameCounter == 1) {
                        transition.stop();
                        stop();
                    }
                }
            };
            timer.start();
            transition.play();
        }
        return parts;
    }
    
    private PathTransition createPathTransition(CubicCurve curve, Text text) {
        final PathTransition transition = new PathTransition(Duration.seconds(10), curve, text);

        transition.setAutoReverse(false);
        transition.setCycleCount(PathTransition.INDEFINITE);
        transition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        transition.setInterpolator(Interpolator.LINEAR);

        return transition;
    }
    
}
