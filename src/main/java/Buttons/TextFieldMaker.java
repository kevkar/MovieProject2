package Buttons;

import javax.swing.*;

//makes a new text field
public class TextFieldMaker implements LabelsAndText {

    @Override
    public JComponent makeComponent(String text) {
        JTextField idField = new JTextField(text);
        idField.setFont(font);

        return idField;
    }
}
