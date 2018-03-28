package jeu.application.graphic.assets;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**Un HearthstoneText désigne un texte à afficher à l'écran
 *
 * @author Thømas
 */
public class HearthstoneText extends Parent {
    //protected static final Font FONT = Font.loadFont(HearthstoneText.class.getResourceAsStream("/jeu/application/graphic/ressources/font/BelweBdBTBold.ttf"), 40);
    
    private String str;
    private final double posX;
    private final double posY;
    
    private final int boxW;
    private final int boxH;
    private final int fontSize;
    
    private HBox box;
    private Text label;

    public HearthstoneText(String name, double posX, double posY, int boxW, int boxH, int fontSize) {
        this.str = name;
        this.posX = posX;
        this.posY = posY;
        this.boxH = boxH;
        this.boxW = boxW;
        this.fontSize = fontSize;
        
        
        box = new HBox();
        //box.setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));  //debug
        //box.setOpacity(0.5);                                                                                 //debug
        box.setPrefSize(boxW, boxH);
        box.setAlignment(Pos.CENTER);
        //box.
        
        
        label = new Text(str);
        label.setFill(Color.WHITE);
        label.setFont(Font.loadFont(getClass().getResourceAsStream("/jeu/application/graphic/ressources/font/BelweBdBTBold.ttf"), fontSize));
        label.setStroke(Color.BLACK);
        label.setStrokeWidth(2);
        label.setStrokeType(StrokeType.OUTSIDE);
        
        box.getChildren().add(label);
        this.getChildren().add(box);
        
        this.setTranslateX(posX);
        this.setTranslateY(posY);
    }
}
