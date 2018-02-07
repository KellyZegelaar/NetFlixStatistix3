package library.applicationLogic;

import library.dataAccess.Factory;
import library.domain.Episode;
import library.domain.Serie;

import java.util.ArrayList;

public class SerieManager {
    private Factory factory;
    private ArrayList<Serie> series;

    public SerieManager(Factory factory) {
        this.factory = factory;
        readSeries();
        addEpisodes();
    }

    public ArrayList<Serie> getSeries(){
        return series;
    }

    private void readSeries(){
        series = factory.createSerieDao().readSerie();
    }

    private void addEpisodes(){
        ArrayList<Episode> episodes = factory.createEpisodeDao().readEpisodes();

        for (Serie s: series) {
            for (Episode a : episodes) {
                if (s.getTitle().equals(a.getSerie())) {
                    s.addEpisode(a);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "SerieManager{" +
                series +
                '}';
    }
}
