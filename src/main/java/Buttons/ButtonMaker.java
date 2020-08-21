package Buttons;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ButtonMaker implements ButtonInterface {
    JButton button = new JButton();

    @Override
    public JButton makeButton(String text, ActionListener listener) {
        button.setText(text);
        button.setFont(font);
        button.addActionListener(listener);

        return (JButton) button;
    }

}
