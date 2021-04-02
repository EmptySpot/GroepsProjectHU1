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
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class HUApp extends Application {
    public static void main(String[] args) throws Exception {
//        String jdbcURL = "jdbc:postgresql://[82.197.208.233]:5432/postgres";

        LocalDate datum = LocalDate.parse("3020-12-17");
        Klas k1 = new Klas("BOB");
        Klas k2 = new Klas("VB2");

        Docent Stef = new Docent("Stef", "112");

        LocalTime time = LocalTime.parse("03:18");
        System.out.println(time);

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

