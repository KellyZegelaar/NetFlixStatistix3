package library.domain;

import java.util.ArrayList;
import java.util.HashMap;

public class Movie {
    private String id;
    private String title;
    private String age;
    private String language;
    private String timeLength;
    private String genre;
    private HashMap<String, String> timeWatched;

    public Movie(String id, String title, String age, String language, String timeLength, String genre) {
        this.id = id;
        this.title = title;
        this.age = age;
        this.language = language;
        this.timeLength = timeLength;
        this.genre = genre;

        timeWatched = new HashMap<>();
    }

    public void addWatched(String timeWatched, String profileName){
        this.timeWatched.put(timeWatched, profileName);
    }

    public HashMap<String, String> getTimeWatched() {
        return timeWatched;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", age='" + age + '\'' +
                ", language='" + language + '\'' +
                ", timeLength='" + timeLength + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
