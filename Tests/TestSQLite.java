import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestSQLite {
    public static void main(String[] args) {
        DatabaseManager.createTable();
        CsvImporter.importCsvToDatabase("dataset.csv");
    }
}