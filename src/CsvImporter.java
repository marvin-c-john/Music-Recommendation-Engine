import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class CsvImporter {

    public static void importCsvToDatabase(String csvPath) {
        String insertSql = """
            INSERT INTO songs (id, title, artist, genre, energy, danceability, valence, tempo, acousticness, instrumentalness)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
            """;

        String csvSplitBy = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";

        System.out.println("Starte optimierten CSV-Import...");

        try (BufferedReader br = new BufferedReader(new FileReader(csvPath));
             Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(insertSql)) {

            conn.setAutoCommit(false);
            String line;
            br.readLine(); // Header überspringen

            int count = 0;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy, -1);
                if (data.length < 21) continue;

                try {
                    String artist = data[2].replace("\"", "").trim();
                    String title = data[4].replace("\"", "").trim();
                    int popularity = Integer.parseInt(data[5]); // Popularität holen
                    String rawGenre = data[20].toLowerCase().trim();

                    //nur bekannte songs
                    if (popularity < 55) {
                        continue;
                    }

                    String mappedGenre = null;

                    // R&B / Soul / Trap Soul
                    if (rawGenre.equals("r-n-b") || rawGenre.equals("soul") || rawGenre.contains("urban contemporary")) {
                        mappedGenre = "RNB";
                    }
                    // Moderner HipHop / Rap / Trap
                    else if (rawGenre.equals("hip-hop") || rawGenre.equals("rap") || rawGenre.equals("trap")) {
                        mappedGenre = "HIPHOP";
                    }
                    // Pop / Dance Pop
                    else if (rawGenre.equals("pop") || rawGenre.equals("dance")) {
                        mappedGenre = "POP";
                    }

                    // wenn es nicht passt weiter
                    if (mappedGenre == null) {
                        continue;
                    }

                    double danceability = Double.parseDouble(data[8]);
                    double energy = Double.parseDouble(data[9]);
                    double acousticness = Double.parseDouble(data[14]);
                    double instrumentalness = Double.parseDouble(data[15]);
                    double valence = Double.parseDouble(data[17]);
                    double tempo = Double.parseDouble(data[18]);

                    String id = UUID.randomUUID().toString();

                    pstmt.setString(1, id);
                    pstmt.setString(2, title);
                    pstmt.setString(3, artist);
                    pstmt.setString(4, mappedGenre);
                    pstmt.setDouble(5, energy);
                    pstmt.setDouble(6, danceability);
                    pstmt.setDouble(7, valence);
                    pstmt.setDouble(8, tempo);
                    pstmt.setDouble(9, acousticness);
                    pstmt.setDouble(10, instrumentalness);

                    pstmt.addBatch();
                    count++;

                    if (count % 1000 == 0) {
                        pstmt.executeBatch();
                    }

                } catch (Exception e) {
                    continue;
                }
            }

            pstmt.executeBatch();
            conn.commit();
            System.out.println("Fertig " + count + " hoch-relevante, moderne Songs in SQLite importiert!");

        } catch (IOException | SQLException e) {
            System.err.println("Fehler beim Import: " + e.getMessage());
        }
    }
}