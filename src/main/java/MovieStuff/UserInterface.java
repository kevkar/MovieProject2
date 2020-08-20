package MovieStuff;

import Buttons.*;

import java.awt.*;
import java.io.IOException;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;

    public UserInterface() {    }

    public JFrame getFrame() {
        return frame;
    }

    //creates GUI with title, dimensions
    @Override
    public void run() {
        frame = new JFrame("Movie Time");
        frame.setPreferredSize(new Dimension(750, 600));

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

        TextFileManipulator.textFileStuff(ListenerClass.getDB());

        GridLayout layout = new GridLayout(4, 3);
        container.setLayout(layout);

        JLabel nameText = new JLabel("  Movie Name: ");
        JTextField nameField = new JTextField();
        JLabel idText = new JLabel("  Movie Length: ");
        JTextField idField = new JTextField("Manually enter length here if adding fails");
        JButton removeButton = new JButton("Remove!");
        JButton movieInfoButton = new JButton("Movie info");
        JButton clearDB = new JButton("Remove all Movies");
        JButton addButton = new JButton("Add!");
        JLabel listMoviesText = new JLabel("List of Movies",SwingConstants.CENTER);
        JButton randomMovie = new JButton("Random Movie");
        JLabel stuffToPrint = PrinterToConsole.printArea();

        MovieRecordListener listener = new MovieRecordListener(nameField, idField);
        addButton.addActionListener(listener);
        movieInfoButton.addActionListener(new MovieSiteListener());
        removeButton.addActionListener(new MovieRemoveListener());
        clearDB.addActionListener(new MovieClearAllListener());
        randomMovie.addActionListener(new RandomMovieListener());

        JTextArea moviesList = MovieListListener.listenLabel();
        JScrollPane scrollableArea= new JScrollPane(moviesList);
        scrollableArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JOptionPane optioner = new JOptionPane();

        container.add(nameText);
        container.add(nameField);
        container.add(listMoviesText);
        container.add(idText);
        container.add(idField);
        container.add(scrollableArea);
        container.add(removeButton);
        container.add(addButton);
        container.add(stuffToPrint);
        container.add(movieInfoButton);
        container.add(clearDB);
        container.add(randomMovie);

    }


}
