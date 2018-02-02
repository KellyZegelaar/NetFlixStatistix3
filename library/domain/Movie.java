package library.domain;

public class Movie {
    private String id;
    private String title;
    private String age;
    private String language;
    private String timeLength;
    private String genre;

    public Movie(String id, String title, String age, String language, String timeLength, String genre) {
        this.id = id;
        this.title = title;
        this.age = age;
        this.language = language;
        this.timeLength = timeLength;
        this.genre = genre;
    }
}
