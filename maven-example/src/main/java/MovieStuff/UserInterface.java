package MovieStuff;

import Buttons.*;

import java.awt.*;
import java.io.IOException;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;

    public UserInterface() {    }

    //creates GUI with title, dimensions
    @Override
    public void run() {
        frame = new JFrame("Movie Time");
        frame.setPreferredSize(new Dimension(500, 700));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        try {
            createComponents(frame.getContentPane());
        } catch (Exception e) {
            e.printStackTrace();
        }

        frame.pack();
        frame.setVisible(true);
    }

    //creates the grid and buttons
    private void createComponents(Container container) throws Exception {

        GridLayout layout = new GridLayout(6, 2);
        container.setLayout(layout);

        JLabel nameText = new JLabel("Movie Name: ");
        JTextField nameField = new JTextField();
        JLabel idText = new JLabel("Movie Length: ");
        JTextField idField = new JTextField("Manually enter length here if adding fails");
        JButton removeButton = new JButton("Remove!");
        JButton randomMovieButton = new JButton("Random Movie");
        JButton movieInfoButton = new JButton("Movie info");
        JButton listMovies = new JButton("List Movies");
        JButton clearDB = new JButton("Remove all Movies");

        JButton addButton = new JButton("Add!");
        MovieRecordListener listener = new MovieRecordListener(nameField, idField);
        addButton.addActionListener(listener);
        randomMovieButton.addActionListener(new RandomMovieListener());
        movieInfoButton.addActionListener(new MovieSiteListener());
        removeButton.addActionListener(new MovieRemoveListener());
        listMovies.addActionListener(new MovieListListener());
        clearDB.addActionListener(new MovieClearAllListener());

        container.add(nameText);
        container.add(nameField);
        container.add(idText);
        container.add(idField);
        container.add(removeButton);
        container.add(addButton);
        container.add(new JLabel(" "));
        container.add(new JLabel(" "));
        container.add(randomMovieButton);
        container.add(movieInfoButton);
        container.add(listMovies);
        container.add(clearDB);

        TextFileManipulator.textFileStuff(ListenerClass.getDB());
    }

    public JFrame getFrame() {
        return frame;
    }
}
