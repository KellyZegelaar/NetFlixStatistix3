/*  This class creates the visible UI using the Runnable interface.
    A javax.swing.* import is needed for the use of buttons ect.
*/

package library.presentation;

import javax.swing.*;
import java.awt.*;

public class StatistixUI implements Runnable {
    private JFrame frame;
    private JTextField accountInfo;

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

        container.add(createChooseAccount(), BorderLayout.NORTH);
        container.add(createBottomApp(), BorderLayout.SOUTH);
    }

    private JMenuBar createChooseAccount(){
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("View");

        ButtonGroup options = new ButtonGroup();

        JRadioButton account1 = new JRadioButton("Account - Kelly");
        JRadioButton account2 = new JRadioButton("Account - Ingeborg");
        JRadioButton account3 = new JRadioButton("Account - Karel");

        JRadioButton movies = new JRadioButton("Show all movies");
        JRadioButton series = new JRadioButton("Show all tv shows");
        JRadioButton statistix = new JRadioButton("Show statistix");

        options.add(account1);
        options.add(account2);
        options.add(account3);
        options.add(movies);
        options.add(series);
        options.add(statistix);

        menu.add(account1);
        menu.add(account2);
        menu.add(account3);
        menu.addSeparator();
        menu.add(movies);
        menu.add(series);
        menu.add(statistix);

        menuBar.add(menu);
        return menuBar;
    }

    //this creates the textline at the end of the app
    private JPanel createBottomApp(){
        JPanel bottomApp = new JPanel(new GridLayout(1, 2));

        bottomApp.add(new JLabel("Netflix Statistix"));
        bottomApp.add(new JLabel("Informatica 2018 - Kelly Zegelaar 2131095"));

        return bottomApp;
    }


}

