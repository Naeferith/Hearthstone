package jeu.application.console.ouput;

import java.util.Scanner;
import jeu.src.IPlateau;
import jeu.src.Plateau;
import jeu.src.capacite.AttaqueCiblee;
import jeu.src.exception.HearthstoneException;

/**
 *
 * @author Thømas
 */
public class InterfaceHeroPowerAttack extends DialogInterface {

    public InterfaceHeroPowerAttack(DialogInterface di) {
        super(di);
    }

    @Override
    public void executeRequest() throws HearthstoneException {
        IPlateau plateau = Plateau.getPlateau();
        Scanner scanIn = new Scanner(System.in);
        String input;
        
        if (plateau.getJoueurCourant().getHeros().getPouvoir() instanceof AttaqueCiblee) {
            Output.printOpponentBoard();
            System.out.println("Choisissez votre cible (0 pour le héros adverse)");
            input = scanIn.nextLine();
            try {
                if ("0".equals(input)) plateau.getJoueurCourant().utiliserPouvoir(plateau.getAdversaire(plateau.getJoueurCourant()).getHeros());
                else plateau.getJoueurCourant().utiliserPouvoir(plateau.getAdversaire(plateau.getJoueurCourant()).getCarteEnJeu(input));
            }
            catch (HearthstoneException e){System.out.println("Erreur : " + e.getMessage());}
        }
        else {
            try {
                plateau.getJoueurCourant().utiliserPouvoir(plateau.getAdversaire(plateau.getJoueurCourant()));
            }
            catch (HearthstoneException e) {System.out.println("Erreur : " + e.getMessage());}
        }
    }

    @Override
    public String getDescription() {
        return "Utiliser le pouvoir héroique";
    }
}