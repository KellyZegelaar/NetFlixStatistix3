/*  This class creates the visible UI using the Runnable interface.
    A javax.swing.* import is needed for the use of buttons ect.
*/

package library.presentation;

import library.applicationLogic.AccountManager;
import library.applicationLogic.MovieManager;
import library.applicationLogic.SerieManager;
import library.domain.Account;

import javax.swing.*;
import java.awt.*;

public class StatistixUI implements Runnable {
    private AccountManager accountManager;
    private MovieManager movieManager;
    private SerieManager serieManager;
    private JFrame frame;
    private JTabbedPane infoPanel;

    public StatistixUI(AccountManager accountManager, MovieManager movieManager, SerieManager serieManager) {
        this.accountManager = accountManager;
        this.movieManager = movieManager;
        this.serieManager = serieManager;
    }

    @Override
    public void run() {
        frame = new JFrame("Netflix Statistix");
        frame.setPreferredSize(new Dimension(1200, 750));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    //here are all the components created that are visible in the application
    private void createComponents(Container container){
        container.setLayout(new BorderLayout());

        infoPanel = new JTabbedPane();
        infoPanel.addTab("empty", new JPanel());

        container.add(createMenuBar(), BorderLayout.NORTH);
        container.add(infoPanel, BorderLayout.CENTER);
        container.add(createBottomApp(), BorderLayout.SOUTH);
    }

    private JMenuBar createMenuBar(){
        JMenuBar menuBar = new JMenuBar();

        menuBar.add(createViewMenu());
        return menuBar;
    }

    private JMenu createViewMenu(){
        JMenu menu = new JMenu("View");

        ButtonGroup options = new ButtonGroup();

        JRadioButton movies = new JRadioButton("Show all movies");
        JRadioButton series = new JRadioButton("Show all tv shows");
        JRadioButton statistix = new JRadioButton("Show statistix");

        ActionListenerViewMenu actionListenerViewMenu = new ActionListenerViewMenu(options,infoPanel, accountManager, movieManager);

        for(Account a: accountManager.getAccounts()){
            String label = "Account - " + a.getName();
            JRadioButton account = new JRadioButton(label);
            account.addActionListener(actionListenerViewMenu);
            account.setActionCommand(label);
            options.add(account);
            menu.add(account);
        }

        movies.addActionListener(actionListenerViewMenu);
        series.addActionListener(actionListenerViewMenu);
        statistix.addActionListener(actionListenerViewMenu);

        movies.setActionCommand(movies.getText());
        series.setActionCommand(series.getText());
        statistix.setActionCommand(statistix.getText());

        options.add(movies);
        options.add(series);
        options.add(statistix);

        menu.addSeparator();
        menu.add(movies);
        menu.add(series);
        menu.add(statistix);

        return menu;
    }

    //this creates the textline at the end of the app
    private JPanel createBottomApp(){
        JPanel bottomApp = new JPanel(new GridLayout(1, 2));

        bottomApp.add(new JLabel("Netflix Statistix"));
        bottomApp.add(new JLabel("Informatica 2018 - Kelly Zegelaar 2131095"));

        return bottomApp;
    }


}

