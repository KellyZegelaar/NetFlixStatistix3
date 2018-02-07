package library.presentation;

import library.applicationLogic.AccountManager;
import library.domain.Account;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerViewMenu implements ActionListener {
    private ButtonGroup group;
    private JTextField infoPanel;
    private AccountManager accountManager;

    public ActionListenerViewMenu(ButtonGroup group, JTextField infoPanel, AccountManager accountManager) {
        this.group = group;
        this.infoPanel = infoPanel;
        this.accountManager = accountManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String choice = group.getSelection().getActionCommand();

        for (Account a: accountManager.getAccounts()){
            String label = "Account - " + a.getName();
            if (label.equals(choice)){
                infoPanel.setText(choice);
            }
        }

        switch (choice){
            case "Show all movies":
                infoPanel.setText(choice);
                break;
            case "Show all tv shows":
                infoPanel.setText(choice);
                break;
            case "Show statistix":
                infoPanel.setText(choice);
                break;
        }
    }
}
