/*  This class creates the visible UI using the Runnable interface.
    A javax.swing.* import is needed for the use of buttons ect.
*/

package library.presentation;

import javax.swing.*;
import java.awt.*;

public class StatistixUI implements Runnable {
    private JFrame frame;

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
        container.add(new JPanel(), BorderLayout.CENTER);
        container.add(createBottomApp(), BorderLayout.SOUTH);
    }

    private JTabbedPane createChooseAccount(){
        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Kelly", createOverview());

        return tabbedPane;
    }

    private JPanel createOverview(){
        JPanel panel = new JPanel();

        return panel;
    }

    //this creates the textline at the end of the app
    private JPanel createBottomApp(){
        JPanel bottomApp = new JPanel(new GridLayout(1, 2));

        bottomApp.add(new JLabel("Netflix Statistix"));
        bottomApp.add(new JLabel("Informatica 2018 - Kelly Zegelaar 2131095"));

        return bottomApp;
    }


}

