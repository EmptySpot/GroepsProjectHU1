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
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        String fxmlPagina = "userInterfaceLaag/Inloggen.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPagina));

        Parent root = loader.load();

        stage.setTitle("HU-rooster hulpprogramma");
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image("Pictures/cropped-cropped-hogeschool-utrecht-logo.png"));
        stage.show();
    }
}

