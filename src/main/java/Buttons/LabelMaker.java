package Buttons;

import javax.swing.*;

public class LabelMaker implements LabelsAndText{

    @Override
    public JLabel makeComponent(String text)
    {
        JLabel label = new JLabel(text,SwingConstants.CENTER);
        label.setFont(font);

        return label;
    }

}
