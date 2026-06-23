

void main() {

    SongRepository repository = new SongRepository();
    RecommendationService recommendationService = new RecommendationService(repository);

    Song inputSong = new Song(
            "Always Forever",
            "Bryson Tiller",
            Genre.RNB,
            0.65,  // energy
            0.70,  // danceability
            0.75,  // valence
            85,    // tempo
            0.45,  // acousticness
            0.05   // instrumentalness
    );


    List<Song> result = recommendationService.recommend(inputSong);

    for(Song song: result){
        System.out.println(song);
    }




}
