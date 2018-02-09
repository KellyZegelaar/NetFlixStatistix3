package library.domain;

import java.util.HashMap;

public class Episode {
    private String id;
    private String serie;
    private String season;
    private String title;
    private String timeLength;
    private HashMap<String, String> timeWatched;

    public Episode(String id, String serie, String season, String title, String timeLength) {
        this.id = id;
        this.serie = serie;
        this.season = season;
        this.title = title;
        this.timeLength = timeLength;

        timeWatched = new HashMap<>();
    }

    public String getSeason() {
        return season;
    }

    public String getTitle() {
        return title;
    }

    public String getTimeLength() {
        return timeLength;
    }

    public void addWatched(String timeWatched, String profileName){
        this.timeWatched.put(profileName, timeWatched);
    }

    public HashMap<String, String> getTimeWatched() {
        return timeWatched;
    }

    public String getId() {
        return id;
    }

    public String getSerie() {
        return serie;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "id='" + id + '\'' +
                ", serie='" + serie + '\'' +
                ", season='" + season + '\'' +
                ", title='" + title + '\'' +
                ", timeLength='" + timeLength + '\'' +
                '}';
    }
}
