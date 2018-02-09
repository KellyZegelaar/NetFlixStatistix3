package library.presentation;

import library.applicationLogic.AccountManager;
import library.applicationLogic.MovieManager;
import library.applicationLogic.SerieManager;
import library.domain.Account;
import library.presentation.JPanels.AccountJPanel;
import library.presentation.JPanels.ShowMoviesJPanel;
import library.presentation.JPanels.ShowSeriesJPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerViewMenu implements ActionListener {
    private ButtonGroup group;
    private JTabbedPane infoPanel;
    private AccountManager accountManager;
    private MovieManager movieManager;
    private SerieManager serieManager;

    public ActionListenerViewMenu(ButtonGroup group, JTabbedPane infoPanel, AccountManager accountManager, MovieManager movieManager, SerieManager serieManager) {
        this.group = group;
        this.infoPanel = infoPanel;
        this.accountManager = accountManager;
        this.movieManager = movieManager;
        this.serieManager = serieManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String choice = group.getSelection().getActionCommand();

        for (Account a: accountManager.getAccounts()){
            String label = "Account - " + a.getName();
            if (label.equals(choice)){
                AccountJPanel accountJPanel = new AccountJPanel(accountManager, a);
                infoPanel.removeAll();
                infoPanel.addTab("Account",accountJPanel.createAccountPanel());
            }
        }

        switch (choice){
            case "Show all movies":
                ShowMoviesJPanel showMoviesJPanel = new ShowMoviesJPanel(movieManager);
                infoPanel.removeAll();
                infoPanel.addTab("Movies", showMoviesJPanel.createShowMoviesPanel());
                break;
            case "Show all tv shows":
                ShowSeriesJPanel showSeriesJPanel = new ShowSeriesJPanel(serieManager);
                infoPanel.removeAll();
                infoPanel.addTab("Tv Shows", showSeriesJPanel.createShowSeriesPanel());
                break;
            case "Show statistix":
                infoPanel.removeAll();
                infoPanel.addTab("Statistix", new JPanel());
                break;
        }
    }
}
