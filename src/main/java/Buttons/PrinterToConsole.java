package Buttons;

import javax.swing.*;

// scrollable area with all the movies go here
public class PrinterToConsole  {

    private static JLabel printer = new JLabel("Output printed here",SwingConstants.CENTER);

    public static JLabel printArea()
    {
        return printer;
    }

    public static void printText(String text)
    {
        printer.setText(text);
    }
}
