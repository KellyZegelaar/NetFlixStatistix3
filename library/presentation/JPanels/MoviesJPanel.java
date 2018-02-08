package library.presentation.JPanels;

import library.applicationLogic.AccountManager;
import library.domain.Account;
import library.domain.Movie;
import library.domain.Profile;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MoviesJPanel extends JPanel {
    private AccountManager accountManager;
    private Account account;

    public MoviesJPanel(AccountManager accountManager, Account account) {
        this.accountManager = accountManager;
        this.account = account;
    }

    public JPanel createOverview(){
        JPanel overviewPanel = new JPanel();
        overviewPanel.setLayout(new BorderLayout());

        overviewPanel.add(new JLabel("Movie Overview - " + account.getProfiles().get(0).getProfileName()), BorderLayout.NORTH);
        overviewPanel.add(new JScrollPane(createMovieOverview(account.getProfiles().get(0))), BorderLayout.CENTER);
        return overviewPanel;
    }

    private JTable createMovieOverview(Profile profile){
        String[] columnNames = {"Id",
                "Titel",
                "Leeftijdsindicatie",
                "Taal",
                "Genre",
                "Tijdbekeken"};

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);

        for (Movie m: profile.getWatchedMovies()){
            Object [] data = {m.getId(), m.getTitle(), m.getAge(), m.getLanguage(), m.getGenre(), m.getTimeWatched().get(profile.getProfileName())};
            tableModel.addRow(data);
        }

        return table;
    }
}
