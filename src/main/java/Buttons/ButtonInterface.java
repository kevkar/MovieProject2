package Buttons;

import TextManipulation.FontClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// buttons have set font in FontClass and have text + action listener
public interface ButtonInterface {
    Font font = FontClass.getFont();

    JButton makeButton(String text, ActionListener listener);
}
