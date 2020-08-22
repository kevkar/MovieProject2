package Listeners;

import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

//listens to namefield and numberfield to add movies
public class MovieRecordListener implements ListenerInterface {

    private static JTextField nameField;
    private static JTextField idField;

    public MovieRecordListener(JTextField nameField, JTextField idField) {
        this.nameField= nameField;
        this.idField = idField;
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
            if(db.addMovieGUI(text(),number()))
                MovieListListener.setList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}