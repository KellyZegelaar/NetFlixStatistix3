package library.presentation;

import library.applicationLogic.AccountManager;
import library.applicationLogic.MovieManager;
import library.domain.Account;
import library.presentation.JPanels.AccountJPanel;
import library.presentation.JPanels.ShowMoviesJPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerViewMenu implements ActionListener {
    private ButtonGroup group;
    private JTabbedPane infoPanel;
    private AccountManager accountManager;
    private MovieManager movieManager;

    public ActionListenerViewMenu(ButtonGroup group, JTabbedPane infoPanel, AccountManager accountManager, MovieManager movieManager) {
        this.group = group;
        this.infoPanel = infoPanel;
        this.accountManager = accountManager;
        this.movieManager = movieManager;
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
                infoPanel.removeAll();
                infoPanel.addTab("Tv Shows", new JPanel());
                break;
            case "Show statistix":
                infoPanel.removeAll();
                infoPanel.addTab("Statistix", new JPanel());
                break;
        }
    }
}
