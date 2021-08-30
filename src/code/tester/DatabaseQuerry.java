package code.tester;

import java.sql.Connection;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class DatabaseQuerry {
    private static String jdbcURL = "jdbc:postgresql://94.211.18.124:5432/postgres";
    private static String username = "pi";
    private static String password = "GoedWachtwoord12";
    private static Connection connection;

    public static void setDBConnection() throws SQLException {
        DatabaseQuerry.connection = getConnection(jdbcURL, username, password);
    }

    public static Connection getDBConnection() {
        return connection;
    }

    public static void closeDBConnection() throws SQLException {
        connection.close();
    }

}
