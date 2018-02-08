package library.presentation;

import library.presentation.JPanels.MoviesJPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerOverviewMovieVsSerie implements ActionListener {
    private ButtonGroup group;
    private JPanel overview;
    private MoviesJPanel moviesJPanel;

    public ActionListenerOverviewMovieVsSerie(ButtonGroup group, JPanel overview, MoviesJPanel moviesJPanel) {
        this.group = group;
        this.overview = overview;
        this.moviesJPanel = moviesJPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String choice = group.getSelection().getActionCommand();

        switch (choice){
            case "movie":
                overview.removeAll();
                overview.add(moviesJPanel.createOverview());
                overview.revalidate();
                break;
            case "serie":
                overview.removeAll();
                overview.add(new JPanel());
                overview.revalidate();
                break;
        }
    }
}
