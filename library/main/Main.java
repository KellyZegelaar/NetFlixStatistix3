package library.main;

import library.presentation.StatistixUI;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args){
        StatistixUI ui = new StatistixUI();

        //wat hieronder staat kan als het goed is later weg gewerkt worden\
        //de vraag is alleen hoe..
        //Als dit is gebeurd dan moet ook de import javax.swing.SwingUtilities weggehaald worden.
        SwingUtilities.invokeLater(ui);
    }

}
