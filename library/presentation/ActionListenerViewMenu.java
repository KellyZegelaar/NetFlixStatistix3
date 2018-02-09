package library.presentation;

import library.applicationLogic.AccountManager;
import library.applicationLogic.MovieManager;
import library.domain.Account;
import library.presentation.JPanels.AccountJPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerViewMenu implements ActionListener {
    private ButtonGroup group;
    private JTabbedPane infoPanel;
    private AccountManager accountManager;

    public ActionListenerViewMenu(ButtonGroup group, JTabbedPane infoPanel, AccountManager accountManager) {
        this.group = group;
        this.infoPanel = infoPanel;
        this.accountManager = accountManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String choice = group.getSelection().getActionCommand();
        System.out.println(choice);

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
                infoPanel.removeAll();
                infoPanel.addTab("Movies", new JPanel());
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
