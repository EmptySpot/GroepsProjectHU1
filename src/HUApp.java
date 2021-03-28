import code.tester.Klas;
import code.tester.Leerling;
import code.tester.School;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.List;

public class HUApp extends Application {
    public static void main(String[] args) throws Exception {
        Klas k1 = new Klas("BOB");
        Leerling l1 = new Leerling("1234", k1, "ww");
        Leerling l2 = new Leerling("4321", k1, "bob");
        Klas k2 = new Klas("VB2");
        Leerling l3 = new Leerling("djdj", k2, "bobbie");
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPagina));

        Parent root = loader.load();

        stage.setTitle("Agenda");
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image("Pictures/cropped-cropped-hogeschool-utrecht-logo.png"));
        stage.show();
    }
}

