package jeu.application.console.ouput;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import jeu.application.Main;
import jeu.src.IPlateau;
import jeu.src.Joueur;
import jeu.src.Plateau;
import jeu.src.exception.HearthstoneException;
import jeu.src.heros.Heros;

/**
 *
 * @author Thømas
 */
public class InterfaceAddPlayer extends DialogInterface {

    public InterfaceAddPlayer(DialogInterface di) {
        super(di);
    }

    @Override
    public void executeRequest() {
        Scanner scanIn = new Scanner(System.in);
        IPlateau plateau = Plateau.getPlateau();
        String pseudo = "";
        Heros heros = null;
        
        do {
            System.out.print("Pseudo : ");
            pseudo = scanIn.nextLine();
            System.out.print("Choix du héros : ");
            //multicatch not working
            try {
                heros = Heros.getHeros(scanIn.nextLine());
            } 
            catch (InstantiationException ex) { Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);} 
            catch (IllegalAccessException ex) { Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);} 
            catch (HearthstoneException e)    { System.out.println("Erreur : " + e.getMessage());}
        
        }
        while("".equals(pseudo) || heros == null);
        
        try {
            plateau.ajouterJoueur(new Joueur(pseudo, heros));
        }
        catch(HearthstoneException e) { System.out.println("Erreur : " + e.getMessage());}
    }
    
    @Override
    public String getDescription() {
        return "Ajouter un joueur à la partie";
    }
}