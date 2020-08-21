package Buttons;

import javax.swing.*;

public class ScrollPane {

    private static JTextArea moviesList = MovieListListener.listenLabel();

        public static JScrollPane makePane()
        {
            JScrollPane scrollableArea= new JScrollPane(moviesList);
            scrollableArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

            return scrollableArea;
        }
}
