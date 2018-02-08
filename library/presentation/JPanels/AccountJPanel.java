package library.presentation.JPanels;

import library.applicationLogic.AccountManager;
import library.applicationLogic.MovieManager;
import library.domain.Account;
import library.domain.Movie;
import library.domain.Profile;

import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AccountJPanel extends JPanel {
    private AccountManager accountManager;
    private Account account;
    private MoviesJPanel moviesJPanel;

    public AccountJPanel(AccountManager accountManager, Account account) {
        this.accountManager = accountManager;
        this.account = account;
    }

    public JPanel createAccountPanel() {
        moviesJPanel = new MoviesJPanel(accountManager, account);
        JPanel accountPanel = new JPanel();
        accountPanel.setLayout(new BorderLayout());





        accountPanel.add(createButtonGroup(), BorderLayout.NORTH);
        accountPanel.add(moviesJPanel.createOverview(), BorderLayout.CENTER);

        return accountPanel;
    }

    public JPanel createButtonGroup(){
        JPanel buttongroup = new JPanel();

        ButtonGroup group = new ButtonGroup();

        JRadioButton movies = new JRadioButton("Movie overview");
        JRadioButton series = new JRadioButton("Serie overview");

        group.add(movies);
        group.add(series);

        buttongroup.add(movies);
        buttongroup.add(series);

        return buttongroup;
    }


}
