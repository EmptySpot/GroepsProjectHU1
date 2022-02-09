package code.tester;

import java.sql.Connection;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class DatabaseQuerry {
    private static String jdbcURL = "jdbc:postgresql://ec2-54-195-76-73.eu-west-1.compute.amazonaws.com/dfcp0u2bt75cmc";
    private static String username = "zkzjnpljtbfprv";
    private static String password = "a714ae5e6c94d9adca5108300b199d3c3cda8d43ccb269393484647cb04300fc";
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


