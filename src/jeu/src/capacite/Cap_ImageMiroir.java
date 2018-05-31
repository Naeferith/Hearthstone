package jeu.src.capacite;

import jeu.src.Plateau;
import jeu.src.carte.Serviteur;

/**Capacité de la carte Image Miroir
 *
 * @author BAGNATO Thomas
 */
public final class Cap_ImageMiroir extends Invocation {

    public Cap_ImageMiroir() {
        super("Image miroir", "Invoque 2 serviteurs 0/2 avec Provocation", new Serviteur("Image Rémanente", 1, Plateau.getPlateau().getJoueurCourant(), new Provocation(), 0, 2), 2);
    }

    @Override
    public final void executerEffetMiseEnJeu(Object cible) {
        super.executerAction(cible);
    }
}