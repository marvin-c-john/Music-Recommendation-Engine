import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        Collections.sort(recommendationsList, new Comparator<Recommendation>() {
            @Override
            public int compare(Recommendation o1, Recommendation o2) {
                return Double.compare(o2.getSimilarity(), o1.getSimilarity());
            }
        });

                //Nur die 5 ähnlichsten Songs oder die ganze List wenn < 5
               int listSize = Math.min(5,recommendationsList.size());
               List<Recommendation>  newRecommendation = new ArrayList<>();
               for(int i = 0; i < listSize; i++){
                   Recommendation r = recommendationsList.get(i);
                   newRecommendation.add(r);

               }




        return newRecommendation.stream()
                .map(Recommendation::getSong)
                .toList();
    }


}
