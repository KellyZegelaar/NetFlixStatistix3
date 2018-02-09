package library.presentation.JPanels;

import library.applicationLogic.SerieManager;
import library.domain.Movie;
import library.domain.Serie;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ShowSeriesJPanel extends JPanel {
    private SerieManager serieManager;

    public ShowSeriesJPanel(SerieManager serieManager) {
        this.serieManager = serieManager;
    }

    public JPanel createShowSeriesPanel(){
        JPanel showSeriesPanel = new JPanel();
        showSeriesPanel.setLayout(new BorderLayout());

        showSeriesPanel.add(createSerieOverview(), BorderLayout.CENTER);

        return showSeriesPanel;
    }

    private JTable createSerieOverview(){
        String[] columnNames = {
                "Titel",
                "Leeftijdsindicatie",
                "Taal",
                "Genre",
                "Vergelijkbaar"};

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);

        for (Serie s: serieManager.getSeries()){
            Object [] data = {s.getTitle(), s.getAge(), s.getLanguage(), s.getGenre(), s.getComparableWith()};
            tableModel.addRow(data);
        }

        return table;
    }


}
