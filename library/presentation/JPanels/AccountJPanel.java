package library.presentation.JPanels;

import library.applicationLogic.AccountManager;
import library.domain.Account;

import javax.swing.*;
import java.awt.*;

public class AccountJPanel extends JPanel {
    private AccountManager accountManager;
    private Account account;
    private JPanel accountPanel;
    private JTabbedPane overview;

    public AccountJPanel(AccountManager accountManager, Account account) {
        this.accountManager = accountManager;
        this.account = account;
    }

    public JPanel createAccountPanel() {
        accountPanel = new JPanel();
        accountPanel.setLayout(new BorderLayout());

        overview = new JTabbedPane();
        overview.addTab("", new JPanel());

        accountPanel.add(createButtonGroup(), BorderLayout.NORTH);
        accountPanel.add(overview, BorderLayout.CENTER);

        return accountPanel;
    }

    public JPanel createButtonGroup(){
        MoviesOverviewJPanel moviesOverviewJPanel = new MoviesOverviewJPanel(accountManager, account);
        SeriesOverviewJPanel seriesOverviewJPanel = new SeriesOverviewJPanel(accountManager, account);
        JPanel buttongroup = new JPanel();

        ButtonGroup group = new ButtonGroup();
//        ActionListenerOverviewMovieVsSerie actionListenerOverviewMovieVsSerie = new ActionListenerOverviewMovieVsSerie(group, overview, new MoviesOverviewJPanel(accountManager, account));

        JButton movies = new JButton("Movie overview");
        JButton series = new JButton("Serie overview");

        movies.addActionListener( event -> {
            overview.removeAll();
            overview.addTab("Movie Overview: ", moviesOverviewJPanel.createOverview());
        });

        series.addActionListener( event -> {
            overview.removeAll();
            overview.addTab("Serie overview: ", seriesOverviewJPanel.createOverview());
        });

//        movies.addActionListener(actionListenerOverviewMovieVsSerie);
//        series.addActionListener(actionListenerOverviewMovieVsSerie);

//        movies.setActionCommand("movie");
//        series.setActionCommand("serie");

        group.add(movies);
        group.add(series);

        buttongroup.add(movies);
        buttongroup.add(series);

        return buttongroup;
    }


}
