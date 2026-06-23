import java.util.ArrayList;
import java.util.List;

public class RecommendationService {

    private final SongRepository repository;
    private final VectorService vectorService = new VectorService();


    public RecommendationService(SongRepository repository) {
        this.repository = repository;
    }


    public List<Song> recommend(Song inputSong){

        double[] a = vectorService.toVector(inputSong);
        List<Recommendation> recommendationsList = new ArrayList<>();

        //Fügt die verglichenen songs in Liste hinzu
        for(Song song: repository.getAllSongs()){
            if(song.getId().equals(inputSong.getId())) continue;
            double[] b = song.getVector();
            if (inputSong.getGenre() == song.getGenre()){
                double similarity = vectorService.cosineSimilarity(a,b);
                Recommendation recommendation = new Recommendation(song, similarity);
                recommendationsList.add(recommendation);
            }
        }

        // Sotiert absteigend
        return recommendationsList.stream()
                .sorted((r1, r2) -> Double.compare(r2.getSimilarity(), r1.getSimilarity()))
                .limit(5)
                .map(Recommendation::getSong)
                .toList();
    }


}
