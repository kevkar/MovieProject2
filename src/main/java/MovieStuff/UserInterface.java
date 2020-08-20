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
        frame.setPreferredSize(new Dimension(725, 450));

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

        Font font = new Font("Helvetica", Font.PLAIN,21);

        GridLayout layout = new GridLayout(4, 3);
        container.setLayout(layout);

        JLabel nameText = new JLabel("  Movie Name: ",SwingConstants.CENTER);
        nameText.setFont(font);
        JTextField nameField = new JTextField();
        JLabel idText = new JLabel("  Movie Length: ",SwingConstants.CENTER);
        idText.setFont(font);
        JTextField idField = new JTextField("Manually enter length here if adding fails");
        JButton removeButton = new JButton("Remove!");
        removeButton.setFont(font);
        JButton movieInfoButton = new JButton("Movie info");
        movieInfoButton.setFont(font);
        JButton clearDB = new JButton("Remove all Movies");
        clearDB.setFont(font);
        JButton addButton = new JButton("Add!");
        addButton.setFont(font);
        JLabel listMoviesText = new JLabel("List of Movies",SwingConstants.CENTER);
        listMoviesText.setVerticalAlignment(JLabel.BOTTOM);
        listMoviesText.setFont(font);
        JButton randomMovie = new JButton("Random Movie");
        randomMovie.setFont(font);
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
