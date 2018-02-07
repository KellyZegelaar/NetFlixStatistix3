package library.domain;

public class Episode {
    private String id;
    private String serie;
    private String season;
    private String title;
    private String timeLength;

    public Episode(String id, String serie, String season, String title, String timeLength) {
        this.id = id;
        this.serie = serie;
        this.season = season;
        this.title = title;
        this.timeLength = timeLength;
    }

    public String getSerie() {
        return serie;
    }
}
