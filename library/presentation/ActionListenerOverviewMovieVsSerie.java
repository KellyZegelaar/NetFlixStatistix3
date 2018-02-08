package library.presentation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerOverviewMovieVsSerie implements ActionListener {
    private ButtonGroup group;

    public ActionListenerOverviewMovieVsSerie(ButtonGroup group) {
        this.group = group;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String choice = group.getSelection().getActionCommand();

        switch (choice){
            case "movie":
                System.out.println("movie");
                break;
            case "serie":
                System.out.println("serie");
                break;
        }
    }
}
