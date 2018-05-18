package jeu.application.graphic.assets;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import jeu.src.IJoueur;

/**
 *
 * @author Thømas
 */
public class DrawableJoueur extends Parent {
    private static final HashMap<String, String> HERO_CLASS = new HashMap<>();
    static {
        HERO_CLASS.put("Jaina", "hero_mage");
        HERO_CLASS.put("Rexxar", "hero_hunter");
    }
    
    private HearthstoneText pv;
    private HearthstoneText pseudo;
    private ImageView portrait;
    private ImageView herosOverlay;

    public DrawableJoueur(IJoueur joueur) {        
        String classH = "hero_container";
        for(Map.Entry<String, String> entry : HERO_CLASS.entrySet()) {
            if (joueur.getHeros().getNom().equals(entry.getKey())) {
                classH = entry.getValue();
                break;
            }
        }
        
        portrait = new ImageView(new Image(getClass().getResourceAsStream("/jeu/application/graphic/ressources/image/heros/" + joueur.getHeros().getNom() + ".png")));
        portrait.setTranslateX(53);
        portrait.setTranslateY(45);
        this.getChildren().add(portrait);
        
        herosOverlay = new ImageView(new Image(getClass().getResourceAsStream("/jeu/application/graphic/ressources/image/heros/" + classH + ".png")));
        this.getChildren().add(herosOverlay);
        
        pv = new HearthstoneText(Integer.toString(joueur.getHeros().getPv()), 315, 345, 50, 50, 50);
        this.getChildren().add(pv);
        
        pseudo = new HearthstoneText(joueur.getPseudo(), 100, 410, 211, 28, 28);
        this.getChildren().add(pseudo);
    }
}
