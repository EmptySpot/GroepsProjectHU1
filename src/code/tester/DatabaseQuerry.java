package code.tester;

import java.sql.Connection;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class DatabaseQuerry {
    private static String jdbcURL = "jdbc:postgresql://tai.db.elephantsql.com:5432/drekyaap";
    private static String username = "drekyaap";
    private static String password = "xau6hudGv93WaILgmj_dk8MedlnhC4Uf";
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