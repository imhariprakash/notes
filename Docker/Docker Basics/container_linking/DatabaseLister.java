import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class DatabaseLister {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://mysql-container:3306";
        // jdbc:mysql://host.docker.internal:3306 : host mysql
        // same container: jdbc:mysql://localhost:3306
        // different container: jdbc:mysql://container-name:3306
        String username = "root";
        String password = "root";
        JsonArray databases = new JsonArray();

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
                 Statement stmt = connection.createStatement();
                 ResultSet rs = stmt.executeQuery("SHOW DATABASES")) {

                while (rs.next()) {
                    JsonObject db = new JsonObject();
                    db.addProperty("database", rs.getString(1));
                    databases.add(db);
                }

            }

            System.out.println(databases.toString());
        } catch (Exception e) {
            System.err.println("An error occurred while listing databases: " + e.getMessage());
            e.printStackTrace();
        }
    }
}