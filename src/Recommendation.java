public class Recommendation {

    private final Song song;
    private final double similarity;

    public Recommendation(Song song, double similarity) {
        this.song = song;
        this.similarity = similarity;
    }

    public Song getSong() {
        return song;
    }

    public double getSimilarity() {
        return similarity;
    }

    @Override
    public String toString() {
        return song.getTitle() + " - " + song.getArtist() + " (" + song.getGenre() + ")";
    }
}
