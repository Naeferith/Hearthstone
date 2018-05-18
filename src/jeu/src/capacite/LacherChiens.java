package jeu.src.capacite;

import jeu.src.IJoueur;
import jeu.src.Plateau;
import jeu.src.carte.Serviteur;
import jeu.src.exception.HearthstoneException;

/**Capacité de la carte Lacher les chiens
 *
 * @author BAGNATO Thomas
 */
public class LacherChiens extends Invocation {
    
    public LacherChiens(IJoueur joueur) {
        super("Lacher les chiens", "Invoque in chien 1/1 avec Charge pour chaque serviteur adverse sur le terrain", new Serviteur("Chien errant", 1, joueur, new Charge(), 1, 1), 0);
    }
    
    @Override
    public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
        this.effectif = Plateau.getPlateau().getAdversaire((IJoueur) cible).getJeu().size();
        super.executerAction(cible);
    }
}
