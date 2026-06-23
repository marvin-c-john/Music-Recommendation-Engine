void main() {
    DatabaseManager.createTable();
    CsvImporter.importCsvToDatabase("/Users/marvinjohn/Downloads/dataset.csv");

    SongRepository repository = new SongRepository();
    RecommendationService recommendationService = new RecommendationService(repository);

    Song inputSong = new Song(
            "Always Forever", "Bryson Tiller", Genre.RNB,
            0.65, 0.70, 0.75, 85, 0.45, 0.05
    );

    Song chopperCity = new Song(
            "Chopper City",
            "NBA YoungBoy",
            Genre.HIPHOP,
            0.78, 0.82, 0.35, 140,
            0.12, 0.01
    );


    Song holdOnTight = new Song(
            "Hold On Tight",
            "The Weeknd",
            Genre.POP,
            0.70, 0.78, 0.55, 95,
            0.22, 0.01
    );

    Song yukon = new Song(
            "Yukon",
            "Justin Bieber",
            Genre.POP,
            0.68, 0.72, 0.60, 88,
            0.25, 0.03
    );

    System.out.println("\nSuche Top 5 Empfehlungen in der Datenbank für: " + yukon + "...\n");

    List<Song> result = recommendationService.recommend(yukon);

    System.out.println("Gefundene Matches:");
    for (Song song : result) {
        System.out.println(song);
    }
}