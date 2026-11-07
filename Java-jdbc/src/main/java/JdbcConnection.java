import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
    public static void main(String[] args) {
        // Load .env file (ignore if missing, so env vars or fallback can be used)
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

        String DB_URL = dotenv.get("DB_URL", System.getenv("DB_URL"));
        String DB_USERNAME = dotenv.get("DB_USERNAME", System.getenv("DB_USERNAME"));
        String DB_PASSWORD = dotenv.get("DB_PASSWORD", System.getenv("DB_PASSWORD"));

        if (DB_URL == null || DB_USERNAME == null || DB_PASSWORD == null) {
            System.err.println("Error: Missing database credentials in environment or .env file.");
            return;
        }

        try(Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)){
            System.out.println("Connected: " + !connection.isClosed());
            System.out.println("Database: " + connection.getMetaData().getDatabaseProductName());
            System.out.println("Driver: " + connection.getMetaData().getDriverName());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
