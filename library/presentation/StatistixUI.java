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

    private void createComponents(Container container){

    }
}

