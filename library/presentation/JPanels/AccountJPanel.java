package library.presentation.JPanels;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AccountJPanel extends JPanel {

    public AccountJPanel() {
        createAccountPanel();
    }

    public JPanel createAccountPanel() {
        JPanel accountPanel = new JPanel();
        accountPanel.add(createMovieOverview());
        return accountPanel;
    }

    private JTable createMovieOverview(){
        String[] columnNames = {"Id",
                "Titel",
                "Leeftijdsindicatie",
                "Taal",
                "Genre"};

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);

//        for(BekekenFilm bekekenFilm: profiel.getBekekenFilm()){
//            for(Film f: bekekenFilm.getFilms()){
//                Object [] data = {f.getId(), f.getTitel(), f.getLeeftijdsindicatie(), f.getTaal(), f.getGenre()};
//                tableModel.addRow(data);
//            }
//        }
        return table;
    }
}
