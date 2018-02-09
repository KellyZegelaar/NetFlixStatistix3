package library.presentation.JPanels;

import library.applicationLogic.MovieManager;
import library.domain.Movie;
import library.domain.Profile;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ShowMoviesJPanel extends JPanel {
    private MovieManager movieManager;

    public ShowMoviesJPanel(MovieManager movieManager) {
        this.movieManager = movieManager;
    }

    public JPanel createShowMoviesPanel(){
       JPanel showMoviesPanel = new JPanel();
       showMoviesPanel.setLayout(new BorderLayout());

        showMoviesPanel.add(createMovieOverview(), BorderLayout.CENTER);

       return showMoviesPanel;
    }

    private JTable createMovieOverview(){
        String[] columnNames = {"Id",
                "Titel",
                "Leeftijdsindicatie",
                "Taal",
                "Genre", };

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);

        for (Movie m: movieManager.getMovies()){
            Object [] data = {m.getId(), m.getTitle(), m.getAge(), m.getLanguage(), m.getGenre()};
            tableModel.addRow(data);
        }

        return table;
    }
}
