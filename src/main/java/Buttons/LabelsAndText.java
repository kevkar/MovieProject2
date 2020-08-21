package Buttons;

import TextManipulation.FontClass;

import javax.swing.*;
import java.awt.*;

public interface LabelsAndText {
    Font font = FontClass.getFont();

    JComponent makeComponent(String text);


}
