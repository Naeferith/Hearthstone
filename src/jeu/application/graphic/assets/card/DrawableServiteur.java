package jeu.application.graphic.assets.card;

import jeu.application.graphic.assets.HearthstoneText;
import jeu.src.carte.Serviteur;

/**
 *
 * @author Thømas
 */
public class DrawableServiteur extends DrawableCarte {    
    private HearthstoneText _atk;
    private HearthstoneText _pv;
    
    public DrawableServiteur(CardType type, Serviteur s) {
        super(type, s);
        illustration.setTranslateX(55);
        description.setWrappingWidth(150);
        _mana.setTranslateX(9);
        _mana.setTranslateY(9);
        
        _atk = new HearthstoneText(Integer.toString(s.getAtk()), 14, CARD_H - 59, 50, 50, 40);
        this.getChildren().add(_atk);
        _pv = new HearthstoneText(Integer.toString(s.getPv()), CARD_W - 50, CARD_H - 58, 50, 50, 40);
        this.getChildren().add(_pv);
    }
}
