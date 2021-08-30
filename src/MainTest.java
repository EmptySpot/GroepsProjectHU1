import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class MainTest {
    public static void main(String[] args) {
        try {
            Connection con = getConnection("jdbc:postgresql://192.168.188.32:5432/projectDB", "postgres", "MenInBlue7");
            Statement statement = con.createStatement();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
}
