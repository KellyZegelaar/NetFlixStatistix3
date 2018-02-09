package library.presentation.JPanels;

import library.applicationLogic.AccountManager;
import library.domain.Account;
import library.domain.Episode;
import library.domain.Movie;
import library.domain.Profile;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SeriesJPanel {
    private AccountManager accountManager;
    private Account account;

    public SeriesJPanel(AccountManager accountManager, Account account) {
        this.accountManager = accountManager;
        this.account = account;
    }

    public JPanel createOverview(){
        JPanel overviewPanel = new JPanel();
        overviewPanel.setLayout(new BorderLayout());

        overviewPanel.add(new JLabel("Serie Overview - " + account.getProfiles().get(0).getProfileName()), BorderLayout.NORTH);
        overviewPanel.add(new JScrollPane(createSerieOverview(account.getProfiles().get(0))), BorderLayout.CENTER);
        return overviewPanel;
    }

    private JTable createSerieOverview(Profile profile){
        String[] columnNames = {"Id",
                "Serie",
                "Seizoen",
                "Titel",
                "Tijdsduur",
                "Tijdbekeken"};

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);

        for (Episode e: profile.getWatchedEpisodes()){
            Object [] data = {e.getId(), e.getSerie(), e.getSeason(), e.getTitle(), e.getTimeLength(), e.getTimeWatched()};
            tableModel.addRow(data);
        }

        return table;
    }
}
