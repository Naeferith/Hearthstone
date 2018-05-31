package jeu.application.console.ouput;

/**
 *
 * @author Thømas
 */
public class InterfaceDisplayHand extends DialogInterface {

    public InterfaceDisplayHand(DialogInterface di) {
        super(di);
    }

    @Override
    public void executeRequest() {
        Output.printHand();
    }

    @Override
    public String getDescription() {
        return "Afficher la main";
    }
}