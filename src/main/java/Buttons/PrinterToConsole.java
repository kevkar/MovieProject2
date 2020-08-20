package Buttons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
