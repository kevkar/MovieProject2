import MovieStuff.UserInterface;

import javax.swing.*;

public class Invoker {

    public static void StartProgram()
    {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception ignored){}
        UserInterface ui = new UserInterface();
        SwingUtilities.invokeLater(ui);
    }

}
