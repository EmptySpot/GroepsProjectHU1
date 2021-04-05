package code.tester;

import javax.swing.plaf.nimbus.State;
import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class DatabaseInfo {
    //TODO: naam aanpassen
    public static void getLessenLeerling() throws SQLException {
        Leerling leerling = (Leerling) SelectedStatics.getPersoon();
        Klas klas = leerling.getKlas();

        Connection connection = DatabaseQuerry.getDBConnection();

        Statement statement = connection.createStatement();
        Statement statement2 = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * from les WHERE klasklasnaam = '" + klas + "'ORDER BY time ASC");

        while (resultSet.next()) {
            ResultSet docentSet = statement2.executeQuery("SELECT * from persoon WHERE persoonid = '" + resultSet.getString(7) + "'");
            docentSet.next();

            OnlineLes les = klas.getLes(resultSet.getString(1));
            String docentid = resultSet.getString(7);
            Docent docent = School.getDocent(docentid);
            if (docent == null) {
                docent = new Docent(docentSet.getString(2), docentSet.getString(1));
            }

            if (les == null) {
                new OnlineLes(resultSet.getDate(2), resultSet.getString(1), resultSet.getBoolean(4), resultSet.getString(5), resultSet.getString(6), klas, docent, resultSet.getTime(3));
            } else if (!SelectedStatics.controleLes(les, resultSet.getDate(2), resultSet.getTime(3))) {
                klas.updateLes(les, resultSet.getDate(2), resultSet.getTime(3));
            }
        }
    }

    public static void getLessenDocent() throws SQLException {
        Docent docent = (Docent) SelectedStatics.getPersoon();
        String docentid = docent.getDocentCode();

        Connection connection = DatabaseQuerry.getDBConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM les WHERE persoonpersoonid ='" + docentid + "'ORDER BY time ASC ");
        docent.clearLessen();
        while (resultSet.next()) {
            Klas klas = School.getKlas(resultSet.getString(8));
            if (klas == null) {
                klas = new Klas(resultSet.getString(8));
            }

            OnlineLes les = klas.getLes(resultSet.getString(1));


            if (les == null) {
                new OnlineLes(resultSet.getDate(2), resultSet.getString(1), resultSet.getBoolean(4), resultSet.getString(5), resultSet.getString(6), klas, docent, resultSet.getTime(3));
            } else if (!SelectedStatics.controleLes(les, resultSet.getDate(2), resultSet.getTime(3))) {
                OnlineLes vergelijkLes = docent.getLes(resultSet.getString(1));
                if(vergelijkLes == null){
                    docent.lessenAppenden(les);
                }
                docent.updateLes(les, resultSet.getDate(2), resultSet.getTime(3));
            }
        }
    }

    public static void getKlasLeerlingen() throws SQLException {
        OnlineLes les = SelectedStatics.getLes();
        Klas klas = les.getKlas();

        Connection connection = DatabaseQuerry.getDBConnection();
        Statement statement = connection.createStatement();


        ResultSet resultSet = statement.executeQuery("SELECT * FROM persoon WHERE klasklasnaam ='" + klas + "'");
        while(resultSet.next()){
            Leerling leerling = klas.getLeerling(resultSet.getString(1));
            if (leerling == null) {
                new Leerling(resultSet.getString(1), klas, resultSet.getString(3), resultSet.getString(2));
            }
        }
    }

    public static Aanwezigheid getAbsentieLeerlingLes(OnlineLes les, Leerling leerling) throws SQLException {
        Connection connection = DatabaseQuerry.getDBConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM aanwezigheid WHERE persoonpersoonid ='" + leerling.getLeerlingnummer() + "' AND leslescode ='" + les.getLesCode() +"'");
        if(resultSet.next()){
            return new Aanwezigheid(leerling, resultSet.getString(3), resultSet.getString(4), les);
        } else {
            return new Aanwezigheid(leerling, "", "Aanwezig", les);
        }
    }

    public static ArrayList<Aanwezigheid> getAbsentieLeerling(Leerling leerling) throws SQLException {
        Connection connection = DatabaseQuerry.getDBConnection();
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM aanwezigheid WHERE persoonpersoonid ='" + SelectedStatics.getPersoon().persoonCode+ "'";
        ResultSet resultSet = statement.executeQuery(query);
        ArrayList<Aanwezigheid> test = new ArrayList<Aanwezigheid>();
        while(resultSet.next()) {
            String lesCode = resultSet.getString(2);
            //ResultSet resultSet2 = statement.executeQuery("SELECT * FROM les WHERE lescode = 'SD-1'");
            //OnlineLes les = new OnlineLes(null, lesCode, false, resultSet2.getString(5), resultSet2.getString(6), null, null, null);
            OnlineLes les = null;
            test.add(new Aanwezigheid((Leerling)SelectedStatics.getPersoon(), resultSet.getString(3), resultSet.getString(4), les));
        }
        return test;
//        if(resultSet.next()){
//            return new Aanwezigheid(leerling, resultSet.getString(3), resultSet.getString(4), les);
//        } else {
//            return new Aanwezigheid(leerling, "", "Aanwezig", les);
//        }
    }

    public static void setAbsentieLeerlingLes(Aanwezigheid aanwezigheid) throws SQLException {
        Connection connection = DatabaseQuerry.getDBConnection();
        Statement statement = connection.createStatement();
        System.out.println(aanwezigheid);

        ResultSet resultSet = statement.executeQuery("SELECT * FROM aanwezigheid WHERE persoonpersoonid ='" + aanwezigheid.getLeerlingInfo().getLeerlingnummer() + "' AND leslescode ='" + aanwezigheid.getOnlineLes().getLesCode() +"'");
        if(resultSet.next()){
            statement.execute("" +
                    "UPDATE aanwezigheid" +
                    " SET aanwezigheid = '"+ aanwezigheid.getAanwezig() +"', extrainformatie = '" + aanwezigheid.getExtraInformatie() + "'" +
                    " WHERE persoonpersoonid = '"+ aanwezigheid.getLeerlingInfo().getLeerlingnummer() +"' AND leslescode = '" + aanwezigheid.getOnlineLes().getLesCode() + "'");

        } else {
            statement.execute("INSERT INTO aanwezigheid" +
                    " VALUES ("+ aanwezigheid.getLeerlingInfo().getLeerlingnummer() +", '"+ aanwezigheid.getOnlineLes().getLesCode() +"', '" + aanwezigheid.getExtraInformatie() +"', '"+ aanwezigheid.getAanwezig()+"')");
        }
    }

    public static void getKlassen() throws SQLException {
        Connection connection = DatabaseQuerry.getDBConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM klas");
        while(resultSet.next()){
            new Klas(resultSet.getString(1));
        }
    }

    public static String setLeerling(String naam, String wachtwoord, Klas klas) throws SQLException {
        Connection connection = DatabaseQuerry.getDBConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("INSERT INTO persoon(persoonnaam, persoonwachtwoord, persoonstatus, klasklasnaam)" +
                "VALUES('"+ naam +"','"+ wachtwoord+"','Leerling','"+ klas.getNaam() +"')" +
                " RETURNING persoonid");
        resultSet.next();
        return resultSet.getString(1);
    }

    public static void setLes(String klasnaam, Date datum, Time tijd, boolean verplicht, String lesnaam, String vaknaam,
                              String persoonid, String duratie) throws SQLException{
        Connection connection = DatabaseQuerry.getDBConnection();
        Statement statement = connection.createStatement();
        statement.execute("insert into les(klasklasnaam, datum, time, verplicht, lesnaam, vaknaam, persoonpersoonid, duratie)" +
                "VALUES ('" + klasnaam + "','" + datum + "','" + tijd + "','" + verplicht + "','" + lesnaam + "','" +
                        vaknaam + "','" + persoonid + "','" + duratie + "')");
    }

    public static void setGeblokkeerd(String leerlingid) throws SQLException {
        Connection connection = DatabaseQuerry.getDBConnection();
        Statement statement = connection.createStatement();
        statement.execute("update persoon SET geblokkeerd = 'Geblokkeerd' WHERE persoonid =" + leerlingid + "" );
    }

    public static void setDeblokkeren(String id) throws  SQLException {
        Connection connection = DatabaseQuerry.getDBConnection();
        Statement statement = connection.createStatement();
       statement.execute("update persoon SET geblokkeerd = null WHERE persoonid =" + id + "" );
    }

    public static String setDocent(String naam, String wachtwoord) throws SQLException {
        Connection connection = DatabaseQuerry.getDBConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("INSERT INTO persoon(persoonnaam, persoonwachtwoord, persoonstatus)" +
                "VALUES('"+ naam +"','"+ wachtwoord+"','Docent')" +
                " RETURNING persoonid");
        resultSet.next();
        return resultSet.getString(1);
    }

    public static void setKlas(String klasnaam) throws SQLException {
        Connection connection = DatabaseQuerry.getDBConnection();
        Statement statement = connection.createStatement();
        statement.execute("INSERT INTO klas(klasnaam)" +
                "VALUES('"+klasnaam+"')");

    }
    public static void setBlokkeerAttempts(int pogingen) throws SQLException {
        Connection connection = DatabaseQuerry.getDBConnection();
        Statement statement = connection.createStatement();
        statement.execute("UPDATE inlogattempts set toegestanepogingen = "+pogingen+" WHERE inlogid = 1");

    }
    public static int getBlokkeerAttempts()throws SQLException{
        DatabaseQuerry.setDBConnection();
        Connection connection = DatabaseQuerry.getDBConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM inlogattempts WHERE inlogid = 1");
        resultSet.next();
        int pogingen =resultSet.getInt(1);
        return pogingen;
    }

}
