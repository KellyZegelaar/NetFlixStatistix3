package library.domain;

import java.util.ArrayList;

public class Serie {
    private String title;
    private String age;
    private String language;
    private String genre;
    private String comparableWith;

    public Serie(String title, String age, String language, String genre, String comparableWith) {
        this.title = title;
        this.age = age;
        this.language = language;
        this.genre = genre;
        this.comparableWith = comparableWith;
    }
}
