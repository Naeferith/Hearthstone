/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu.src.capacite;

import jeu.src.IJoueur;
import jeu.src.carte.Serviteur;

/**
 *
 * @author bagnato2u
 */
public final class Cap_ImageMiroir extends Invocation {

    public Cap_ImageMiroir(IJoueur joueur) {
        super("Image miroir", "Invoque 2 serviteurs 0/2 avec Provocation", new Serviteur("Image Rémanente", 1, joueur, new Provocation(), 0, 2), 2);
    }

    @Override
    public final void executerEffetMiseEnJeu(Object cible) {
        super.executerAction(cible); 
    }
}
