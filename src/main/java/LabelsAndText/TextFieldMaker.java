package LabelsAndText;

import javax.swing.*;

//makes a new JTextField
public class TextFieldMaker implements LabelsAndText {

    @Override
    public JComponent makeComponent(String text) {
        JTextField idField = new JTextField(text);
        idField.setFont(font);

        return idField;
    }
}
