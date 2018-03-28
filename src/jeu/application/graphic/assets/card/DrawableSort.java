package jeu.application.graphic.assets.card;

import jeu.src.ICarte;

/**
 *
 * @author Thømas
 */
public class DrawableSort extends DrawableCarte {
    
    public DrawableSort(CardType type, ICarte carte) {
        super(type, carte);
        illustration.setTranslateX(32);
        illustration.setTranslateY(30);
        
        description.setWrappingWidth(140);
        
        _mana.setTranslateX(8);
        _mana.setTranslateY(3);
    }
    
}
