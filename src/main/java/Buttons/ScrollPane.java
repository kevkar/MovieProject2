package Buttons;

import javax.swing.*;

// makes the scrollpane of the movies list
public class ScrollPane {

    private static JTextArea moviesList = MovieListListener.listenLabel();

        public static JScrollPane makePane()
        {
            JScrollPane scrollableArea= new JScrollPane(moviesList);
            scrollableArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

            return scrollableArea;
        }
}
