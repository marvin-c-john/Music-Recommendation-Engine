import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SongRepository {

    /**
     * Holt alle importierten Songs aus der SQLite-Datenbank und
     * wandelt sie in echte Java-Song-Objekte um.
     */
    public List<Song> getAllSongs() {
        List<Song> songs = new ArrayList<>();
        String sql = "SELECT id, title, artist, genre, energy, danceability, valence, tempo, acousticness, instrumentalness FROM songs";

        // Try-with-resources öffnet die DB-Verbindung und schließt sie danach automatisch
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            // Wir gehen Zeile für Zeile durch die Ergebnisse der Datenbank
            while (rs.next()) {
                String title = rs.getString("title");
                String artist = rs.getString("artist");
                String genreStr = rs.getString("genre");

                double energy = rs.getDouble("energy");
                double danceability = rs.getDouble("danceability");
                double valence = rs.getDouble("valence");
                double tempo = rs.getDouble("tempo");
                double acousticness = rs.getDouble("acousticness");
                double instrumentalness = rs.getDouble("instrumentalness");

                // Den Text aus der DB ("RNB", "HIPHOP", "POP") wieder in dein echtes Enum umwandeln
                Genre genre = Genre.valueOf(genreStr);

                // Ein neues Song-Objekt erstellen
                Song song = new Song(title, artist, genre, energy, danceability, valence, tempo, acousticness, instrumentalness);


                songs.add(song);
            }

            System.out.println("Erfolgreich " + songs.size() + " Songs aus der SQLite-Datenbank geladen!");

        } catch (SQLException e) {
            System.err.println("Fehler beim Laden der Songs aus der Datenbank: " + e.getMessage());
        }

        return songs;
    }
}