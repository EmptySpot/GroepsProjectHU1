package userInterfaceLaag;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class mousePressedControle {

    public static void mousePressedVerwerker(MouseEvent mouseEvent, FXMLLoader loader) throws IOException {
        Node node;
        node = (Node)loader.load();
        var test = ((Node)mouseEvent.getTarget()).getScene().getWindow();
        AnchorPane pane = (AnchorPane) test.getScene().lookup("#ViewContainer");
        pane.getChildren().setAll(node);
    }
}
