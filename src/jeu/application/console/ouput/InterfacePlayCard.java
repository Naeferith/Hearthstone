package jeu.application.console.ouput;

import java.util.Scanner;
import jeu.src.IPlateau;
import jeu.src.Plateau;
import jeu.src.capacite.AttaqueCiblee;
import jeu.src.carte.ICarte;
import jeu.src.exception.HearthstoneException;

/**
 *
 * @author Thømas
 */
public class InterfacePlayCard extends DialogInterface {

    public InterfacePlayCard(DialogInterface di) {
        super(di);
    }

    @Override
    public void executeRequest() throws HearthstoneException {
        IPlateau plateau = Plateau.getPlateau();
        Scanner scanIn = new Scanner(System.in);
        String input;
        
        System.out.println("Votre main :");
        for (ICarte carte : plateau.getJoueurCourant().getMain()) System.out.println(carte.toString());
        System.out.println("Votre choix :");
        input = scanIn.nextLine();
        ICarte carteSelect = plateau.getJoueurCourant().getCarteEnMain(input);
        if (carteSelect == null) System.out.println("Carte non trouvée");
        else if (carteSelect.getCapacite() != null && carteSelect.getCapacite() instanceof AttaqueCiblee) {
            Output.printOpponentBoard();
            System.out.println("Choisissez votre cible (0 pour le héros adverse)");
            input = scanIn.nextLine();
            try {
                if ("0".equals(input)) plateau.getJoueurCourant().jouerCarte(carteSelect, plateau.getAdversaire(plateau.getJoueurCourant()).getHeros());
                else plateau.getJoueurCourant().jouerCarte(carteSelect, plateau.getAdversaire(plateau.getJoueurCourant()).getCarteEnJeu(input));
            }
            catch (HearthstoneException e){System.out.println("Erreur : " + e.getMessage());}
        }
        else {
            try {
                plateau.getJoueurCourant().jouerCarte(carteSelect);
            }
            catch (HearthstoneException e) {System.out.println("Erreur : " + e.getMessage());}
        }
    }

    @Override
    public String getDescription() {
        return "Jouer une carte";
    }
    
}
