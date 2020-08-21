package Buttons;

import TextManipulation.FontClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public interface ButtonInterface {
    Font font = FontClass.getFont();

    public JButton makeButton(String text, ActionListener listener);
}
