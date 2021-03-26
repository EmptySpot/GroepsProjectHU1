import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HUApp extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        String fxmlPagina = "userInterfaceLaag/Inloggen.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPagina));

        Parent root = loader.load();

        stage.setTitle("HU Agenda");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
