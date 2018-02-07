package library.presentation.JPanels;

import javax.swing.*;

public class AccountJPanel extends JPanel {

    public AccountJPanel() {
        createAccountPanel();
    }

    public JPanel createAccountPanel() {
        JPanel accountPanel = new JPanel();
        JTextField textField = new JTextField("hello");
        accountPanel.add(textField);
        return accountPanel;
    }
}
