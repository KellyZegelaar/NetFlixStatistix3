package library.applicationLogic;

import library.dataAccess.Factory;
import library.domain.Account;
import library.domain.Movie;
import library.domain.Profile;

import java.util.ArrayList;

public class AccountManager {
    private Factory factory;
    private ArrayList<Account> accounts;
    private ArrayList<Movie> movies;

    public AccountManager(Factory factory) {
        this.factory = factory;
        readAccounts();
        addProfiles();
        addMovies();
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

//        for (Account a: accounts){
//            for(Profile p: a.getProfiles()){
//                for (Movie m : movies){
//                    for (String key: m.getTimeWatched().keySet()){
//                        System.out.println(key + m.getTimeWatched().get(key));
//                        System.out.println("========================================");
//                        if (p.getProfileName().equals(key)){
//                            p.addWatchedMovie(m);
//                        }
//                    }
//                }
//            }
//        }

//        for (Account a: accounts){
//            for (Profile p: a.getProfiles()){
//                for(Movie m : movies){
//                    for (String key : m.getTimeWatched().keySet()){
//                        p.addWatchedMovie(m);
//                    }
//                }
//            }
//        }
        for (Movie m: movies){
            for (Account a: accounts){
                for (Profile p: a.getProfiles()){
                    if(m.getTimeWatched().containsKey(p.getProfileName())){
                        p.addWatchedMovie(m);
                    }
                }
            }
        }

//        for(Movie m : movies){
//            for (String key : m.getTimeWatched().keySet()){
//                System.out.println(key + "" + m);
//            }
//        }

//        for (Movie m: movies){
//            System.out.println(m);
//        }
    }

    public ArrayList<Movie> getWatchedMovies(){
        return movies;
    }

    @Override
    public String toString() {
        return "AccountManager {" + accounts + "}";
    }
}
