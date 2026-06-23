import java.util.ArrayList;
import java.util.List;

public class RecommendationService {

    private final SongRepository repository;
    private final VectorService vectorService = new VectorService();

    public RecommendationService(SongRepository repository) {
        this.repository = repository;
    }

    public List<Song> recommend(Song inputSong) {
        double[] a = vectorService.toVector(inputSong);
        List<Recommendation> recommendationsList = new ArrayList<>();

        List<String> seenTitles = new ArrayList<>();

        List<Song> allSongs = repository.getAllSongs();

        for (Song song : allSongs) {
            if (song.getId().equals(inputSong.getId())) continue;

            if (inputSong.getGenre() == song.getGenre()) {

                if (seenTitles.contains(song.getTitle())) {
                    continue;
                }

                double[] b = vectorService.toVector(song);
                song.setVector(b);

                double similarity = vectorService.cosineSimilarity(a, b);

                Recommendation recommendation = new Recommendation(song, similarity);
                recommendationsList.add(recommendation);
                seenTitles.add(song.getTitle());
            }
        }

        return recommendationsList.stream()
                .sorted((r1, r2) -> Double.compare(r2.getSimilarity(), r1.getSimilarity()))
                .limit(10)
                .map(Recommendation::getSong)
                .toList();
    }
}