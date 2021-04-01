import code.tester.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class HUApp extends Application {
    public static void main(String[] args) throws Exception {
//        String jdbcURL = "jdbc:postgresql://[127.0.0.1:54775]:5433/HU_App";
//        String jdbcURL = "jdbc:postgresql://[82.197.208.233]:5432/postgres";
        String jdbcURL = "jdbc:postgresql://tai.db.elephantsql.com:5432/drekyaap";
        //TODO: portforwarding van raspi naar port 5432
        String username = "drekyaap";
        String password = "xau6hudGv93WaILgmj_dk8MedlnhC4Uf";
        try (Connection connection = getConnection(jdbcURL, username, password)){
            System.out.println("werkt");
            connection.close();
        }catch(SQLException e){
            System.out.println("ging fout"+e);
        }
        LocalDate datum = LocalDate.now().plusWeeks(2);
        Klas k1 = new Klas("BOB");
        Klas k2 = new Klas("VB2");

        Leerling l1 = new Leerling("1234", k1, "ww", "Jan");
        Leerling l2 = new Leerling("4321", k1, "bob", "Bram");
        Leerling l3 = new Leerling("djdj", k2, "bobbie", "Bobbie");

        Docent Stef = new Docent("Stef", "112");

        LocalTime time = LocalTime.parse("03:18");
        System.out.println(time);

        OnlineLes projectLes1= new OnlineLes(datum, "SD", true, "Project les 1", "project", k2, Stef, time);
        OnlineLes projectLes2= new OnlineLes(datum.plusWeeks(2), "SD", true, "Project les 2", "project", k2, Stef, time);
        OnlineLes projectLes3= new OnlineLes(datum.plusDays(1), "SD", true, "Project les 1", "project", k1, Stef, time);
        OnlineLes projectLes4= new OnlineLes(datum.plusDays(1), "SD", true, "Project les 1", "project", k1, Stef, time);

        l1.updateAanwezigheid(l1.getAanwezigheidLes(projectLes3), "Absent");
        l1.updateAanwezigheid(l1.getAanwezigheidLes(projectLes4), "Absent");

        List<Klas> klappen = School.getKlassen();

        System.out.println(klappen);
        for(Klas k : klappen){
            System.out.println(k.getLeerlingen());
        }
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        String fxmlPagina = "userInterfaceLaag/Inloggen.fxml";
        //fxmlPagina = "userInterfaceLaag/MainView.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPagina));

        Parent root = loader.load();

        stage.setTitle("HU-rooster hulpprogramma");
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image("Pictures/cropped-cropped-hogeschool-utrecht-logo.png"));
        stage.show();
    }
}

