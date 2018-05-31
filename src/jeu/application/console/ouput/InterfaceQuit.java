package jeu.application.console.ouput;

/**
 *
 * @author Thømas
 */
public class InterfaceQuit extends DialogInterface {

    public InterfaceQuit(DialogInterface di) {
        super(di);
    }

    @Override
    public void executeRequest() {
        System.exit(0);
    }

    @Override
    public String getDescription() {
        return "Quitter";
    }
}