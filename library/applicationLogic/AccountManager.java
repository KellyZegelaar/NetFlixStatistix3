package library.applicationLogic;

import library.dataAccess.Factory;
import library.domain.*;

import java.util.ArrayList;

public class AccountManager {
    private Factory factory;
    private ArrayList<Account> accounts;
    private ArrayList<Movie> movies;
    private ArrayList<Episode> episodes;

    public AccountManager(Factory factory) {
        this.factory = factory;
        readAccounts();
        addProfiles();
        addMovies();
        addEpisodes();
    }

    public ArrayList<Account> getAccounts(){
        return accounts;
    }

    private void readAccounts(){
        accounts = factory.createAccountDao().readAccounts();
    }

    private void addProfiles() {
        ArrayList<Profile> profiles = factory.createProfileDao().readProfiles();

        for (Account a: accounts) {
            for (Profile p : profiles) {
                if(p.getSubscriberNumber().equals(a.getSubscriberNumber())){
                    a.addProfile(p);
                }
            }
        }
    }

    private void addMovies(){
        movies = factory.createMovieDao().readWatchedMovies();

        for (Movie m: movies){
            for (Account a: accounts){
                for (Profile p: a.getProfiles()){
                    if(m.getTimeWatched().containsKey(p.getProfileName())){
                        p.addWatchedMovie(m);
                    }
                }
            }
        }
    }

    private void addEpisodes(){
        episodes = factory.createEpisodeDao().readWatchedEpisodes();

        for (Episode e: episodes){
            for (Account a: accounts){
                for (Profile p: a.getProfiles()){
                    if(e.getTimeWatched().containsKey(p.getProfileName())){
                        p.addWatchedEpisode(e);
                    }
                }
            }
        }
    }

    public ArrayList<Movie> getWatchedMovies(){
        return movies;
    }

    public ArrayList<Episode> getWatchedEpisodes() {
        return episodes;
    }

    @Override
    public String toString() {
        return "AccountManager {" + accounts + "}";
    }
}
