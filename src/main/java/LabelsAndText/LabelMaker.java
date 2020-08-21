package LabelsAndText;

import javax.swing.*;

//makes a new JLabel
public class LabelMaker implements LabelsAndText{

    @Override
    public JLabel makeComponent(String text)
    {
        JLabel label = new JLabel(text,SwingConstants.CENTER);
        label.setFont(font);

        return label;
    }

}
