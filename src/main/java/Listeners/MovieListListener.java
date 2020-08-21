package Listeners;

import java.awt.event.*;
import javax.swing.*;

// prints the database
public class MovieListListener implements ListenerInterface {

    private static JTextArea label = new JTextArea(db.toString());

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println(db);
        label.setText(db.toString());
    }

    public static void setList()
    {
        listenLabel().setText(db.toString());
    }

    public static JTextArea listenLabel()
    {
        return label;
    }
}