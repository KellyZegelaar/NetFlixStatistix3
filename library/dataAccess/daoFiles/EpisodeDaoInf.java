package library.dataAccess.daoFiles;

import library.domain.Episode;

import java.util.ArrayList;

public interface EpisodeDaoInf {
    ArrayList<Episode> readEpisodes();
    ArrayList<Episode> readWatchedEpisodes();
}
