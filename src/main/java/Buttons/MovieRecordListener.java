package Buttons;

import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;


public class MovieRecordListener extends ListenerClass implements ActionListener {

    private static JTextField nameField;
    private static JTextField idField;

    public MovieRecordListener(JTextField nameField, JTextField idField) {
        this.nameField = nameField;
        this.idField = idField;
    }

    public static JTextField nameField() {
        return nameField;
    }

    public static String text()
    {
        return nameField.getText();
    }

    public static String number()
    {
        return idField.getText();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {

            db.addMovieGUI();

            MovieListListener.listenLabel().setText(db.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}