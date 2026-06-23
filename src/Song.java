import java.util.UUID;

public class Song {

    private double[] vector;
    private final String title;
    private final String artist;
    private final Genre genre;
    private final double energy;
    private final double danceability;
    private final double valence;
    private final double tempo;
    private final double acousticness;
    private final double instrumentalness;
    private final String id;



    public Song(String title, String artist, Genre genre, double energy, double danceability, double valence, double tempo, double acousticness,double instrumentalness) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.energy = energy;
        this.danceability = danceability;
        this.valence = valence;
        this.tempo = tempo;
        this.acousticness = acousticness;
        this.instrumentalness = instrumentalness;
        this.id = UUID.randomUUID().toString();
    }

    public double[] getVector() {
        return vector;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getId() {
        return id;
    }

    public double getEnergy() {
        return energy;
    }

    public double getDanceability() {
        return danceability;
    }

    public double getValence() {
        return valence;
    }

    public double getTempo() {
        return tempo;
    }

    public double getAcousticness() {
        return acousticness;
    }

    public double getInstrumentalness() {
        return instrumentalness;
    }

    public void setVector(double[] vector) {
        this.vector = vector;
    }


    @Override
    public String toString() {
        return artist + " - " + title + " (" + genre +")";
    }
}