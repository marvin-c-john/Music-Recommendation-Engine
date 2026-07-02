import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

    // Unsere echte Musik-Datenbankdatei im Hauptverzeichnis des Projekts
    private static final String URL = "jdbc:sqlite:music.db";

    // Gibt uns eine offene Verbindung zur Datenbank zurück
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    // Erstellt die Tabelle songs falls sie noch nicht existiert
    public static void createTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS songs (
                id TEXT PRIMARY KEY,
                title TEXT,
                artist TEXT,
                genre TEXT,
                energy REAL,
                danceability REAL,
                valence REAL,
                tempo REAL,
                acousticness REAL,
                instrumentalness REAL
            );
            """;


        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("SQLite-Tabelle 'songs' wurde erfolgreich initialisiert.");

        } catch (SQLException e) {
            System.err.println("Fehler beim Erstellen der Tabelle: " + e.getMessage());
        }
    }
}
