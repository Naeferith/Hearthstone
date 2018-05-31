package jeu.application.console.ouput;

import java.util.Scanner;
import jeu.src.IPlateau;
import jeu.src.Plateau;
import jeu.src.carte.Serviteur;
import jeu.src.exception.HearthstoneException;

/**
 *
 * @author Thømas
 */
public class InterfaceMobAttack extends DialogInterface {

    public InterfaceMobAttack(DialogInterface di) {
        super(di);
    }

    @Override
    public void executeRequest() throws HearthstoneException {
        IPlateau plateau = Plateau.getPlateau();
        Scanner scanIn = new Scanner(System.in);
        String input;
        
        if (plateau.getJoueurCourant().getJeu().isEmpty()) System.out.println("Aucun servieur n'est sur le terrain.");
        else {
            Output.printCurrentBoard();
            System.out.println("Quel serviteur va attaquer ? :");
            input = scanIn.nextLine();
            Serviteur carteSelect = (Serviteur) plateau.getJoueurCourant().getCarteEnJeu(input);
            if (carteSelect == null) System.out.println("Erreur : Carte non trouvée");
            Output.printOpponentBoard();
            System.out.println("Choisissez votre cible (0 pour le héros adverse)");
            input = scanIn.nextLine();
            try {
                if ("0".equals(input)) plateau.getJoueurCourant().utiliserCarte(carteSelect, plateau.getAdversaire(plateau.getJoueurCourant()).getHeros());
                else plateau.getJoueurCourant().utiliserCarte(carteSelect, plateau.getAdversaire(plateau.getJoueurCourant()).getCarteEnJeu(input));
            }
            catch (HearthstoneException e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        }
    }

    @Override
    public String getDescription() {
        return "Attaquer avec un serviteur";
    }
}