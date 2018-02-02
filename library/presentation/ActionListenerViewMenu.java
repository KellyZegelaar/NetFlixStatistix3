package library.presentation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerViewMenu implements ActionListener {
    private ButtonGroup group;
    private JTextField infoPanel;

    public ActionListenerViewMenu(ButtonGroup group, JTextField infoPanel) {
        this.group = group;
        this.infoPanel = infoPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String choice = group.getSelection().getActionCommand();

        switch (choice){
            case "Account - Kelly":
                infoPanel.setText(choice);
                break;
            case "Account - Ingeborg":
                infoPanel.setText(choice);
                break;
            case "Account - Karel":
                infoPanel.setText(choice);
                break;
            case "Show all movies":
                infoPanel.setText(choice);
                break;
            case "Show all tv shows":
                infoPanel.setText(choice);
                break;
            case "Show statistix":
                infoPanel.setText(choice);
                break;
            default:
                infoPanel.setText("");
        }
    }
}
