package library.domain;

import java.util.ArrayList;

public class Serie {
    private String title;
    private String age;
    private String language;
    private String genre;
    private String comparableWith;
    private ArrayList<Episode> episodes;

    public Serie(String title, String age, String language, String genre, String comparableWith) {
        this.title = title;
        this.age = age;
        this.language = language;
        this.genre = genre;
        this.comparableWith = comparableWith;

        episodes = new ArrayList<>();
    }

    public String getAge() {
        return age;
    }

    public String getLanguage() {
        return language;
    }

    public String getGenre() {
        return genre;
    }

    public String getComparableWith() {
        return comparableWith;
    }

    public void addEpisode(Episode episode){
        episodes.add(episode);
    }

    public ArrayList<Episode> getEpisodes() {
        return episodes;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "title='" + title + '\'' +
                ", age='" + age + '\'' +
                ", language='" + language + '\'' +
                ", genre='" + genre + '\'' +
                ", comparableWith='" + comparableWith + '\'' +
                ", episodes=" + episodes +
                '}';
    }
}
