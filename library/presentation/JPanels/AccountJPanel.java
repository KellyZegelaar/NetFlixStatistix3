package library.presentation.JPanels;

import library.applicationLogic.AccountManager;
import library.domain.Account;
import library.presentation.ActionListenerOverviewMovieVsSerie;

import javax.swing.*;
import java.awt.*;

public class AccountJPanel extends JPanel {
    private AccountManager accountManager;
    private Account account;
    private JPanel overview;

    public AccountJPanel(AccountManager accountManager, Account account) {
        this.accountManager = accountManager;
        this.account = account;
    }

    public JPanel createAccountPanel() {
//         MoviesJPanel moviesJPanel = new MoviesJPanel(accountManager, account);
        JPanel accountPanel = new JPanel();
        accountPanel.setLayout(new BorderLayout());

        overview = new JPanel();
        overview.add(new JPanel());

        accountPanel.add(createButtonGroup(), BorderLayout.NORTH);
        accountPanel.add(overview, BorderLayout.CENTER);

        return accountPanel;
    }

    public JPanel createButtonGroup(){
        JPanel buttongroup = new JPanel();

        ButtonGroup group = new ButtonGroup();
        ActionListenerOverviewMovieVsSerie actionListenerOverviewMovieVsSerie = new ActionListenerOverviewMovieVsSerie(group, overview, new MoviesJPanel(accountManager, account));

        JRadioButton movies = new JRadioButton("Movie overview");
        JRadioButton series = new JRadioButton("Serie overview");

        movies.addActionListener(actionListenerOverviewMovieVsSerie);
        series.addActionListener(actionListenerOverviewMovieVsSerie);

        movies.setActionCommand("movie");
        series.setActionCommand("serie");

        group.add(movies);
        group.add(series);


        buttongroup.add(movies);
        buttongroup.add(series);

        return buttongroup;
    }


}
