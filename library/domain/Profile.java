package library.domain;

import java.util.ArrayList;

public class Profile {
    private String profileName;
    private String dateOfBirth;
    private String subscriberNumber;
    private ArrayList<Movie> watchedMovies;
    private ArrayList<Episode> watchedEpisodes;

    public Profile(String profileName, String dateOfBirth, String subscriberNumber) {
        this.profileName = profileName;
        this.dateOfBirth = dateOfBirth;
        this.subscriberNumber = subscriberNumber;

        watchedMovies = new ArrayList<>();
        watchedEpisodes = new ArrayList<>();
    }

    public void addWatchedMovie(Movie movie){
        watchedMovies.add(movie);
    }

    public ArrayList<Movie> getWatchedMovies() {
        return watchedMovies;
    }

    public void addWatchedEpisode(Episode episode){
        watchedEpisodes.add(episode);
    }

    public ArrayList<Episode> getWatchedEpisodes() {
        return watchedEpisodes;
    }

    public String getSubscriberNumber() {
        return subscriberNumber;
    }

    public String getProfileName() {
        return profileName;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "profileName='" + profileName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", subscriberNumber='" + subscriberNumber + '\'' +
                ", watchedMovies=" + watchedMovies +
                '}';
    }
}
