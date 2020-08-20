import MovieStuff.UserInterface;

import javax.swing.*;

public class Invoker {

    public static void StartProgram()
    {
        UserInterface ui = new UserInterface();
        SwingUtilities.invokeLater(ui);
    }

}
