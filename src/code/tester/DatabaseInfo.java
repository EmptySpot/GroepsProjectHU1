package code.tester;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;

public class DatabaseInfo {
    public static void lessenLeerling() throws SQLException {
        Leerling leerling = (Leerling) SelectedStatics.getPersoon();
        Klas klas = leerling.getKlas();

        Connection connection = DatabaseQuerry.getDBConnection();

        Statement statement = connection.createStatement();
        Statement statement2 = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * from les WHERE klasklasnaam = '" + klas + "'");
        while(resultSet.next()){
            ResultSet docentSet = statement2.executeQuery("SELECT * from persoon WHERE persoonid = '" + resultSet.getString(7) + "'");
            docentSet.next();

            OnlineLes les = klas.getLes(resultSet.getString(1));
            String docentid = resultSet.getString(7);
            Docent docent = School.getDocent(docentid);
            if(docent == null) {
                docent = new Docent(docentSet.getString(2), docentSet.getString(1));
            }

            if(les == null){
                new OnlineLes(resultSet.getDate(2), resultSet.getString(1), resultSet.getBoolean(4), resultSet.getString(5), resultSet.getString(6), klas, docent, resultSet.getTime(3));
            } else if(!klas.controleLes(les, resultSet.getDate(2), resultSet.getTime(3))){
                klas.updateLes(les, resultSet.getDate(2), resultSet.getTime(3));
            }
        }
    }
}
