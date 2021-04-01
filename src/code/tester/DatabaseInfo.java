package code.tester;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;

public class DatabaseInfo {
    public static void lessenLeerling() throws SQLException {
        System.out.println("Heyayayayaya");
        Leerling leerling = (Leerling) SelectedStatics.getPersoon();
        Klas klas = leerling.getKlas();

        Connection connection = DatabaseQuerry.getDBConnection();

        Statement statement = connection.createStatement();
        Statement statement2 = connection.createStatement();

        System.out.println("Bram is een genius");
        ResultSet resultSet = statement.executeQuery("SELECT * from les WHERE klasklasnaam = '" + klas + "'");
        while(resultSet.next()){
//            String docentid = resultSet.getString(7);
            System.out.println("Bram is niet een genius");
            String docentid = resultSet.getString(7);
            ResultSet docentSet = statement2.executeQuery("SELECT * from persoon WHERE persoonid = '" + resultSet.getString(7) + "'");
            docentSet.next();
            System.out.println(resultSet);
            System.out.println(docentid);
            Docent docent = School.getDocent(docentid);
            if(docent == null) {
                docent = new Docent(docentSet.getString(2), docentSet.getString(1));
            }
            System.out.println(School.getDocenten());
            if(klas.getLes(resultSet.getString(1)) == null){
                new OnlineLes(resultSet.getDate(2), resultSet.getString(1), resultSet.getBoolean(4), resultSet.getString(5), resultSet.getString(6), klas, docent, resultSet.getTime(3));
            }
            System.out.println(klas.getLessen());
            System.out.println(resultSet.getString(1));
        }
    }
}
