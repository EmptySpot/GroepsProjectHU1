package userInterfaceLaag;

import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class DocentKeuzeAfmeldenController {

    public void mousePressedKlas(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("KlassenLijst.fxml"));
        mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
    }

    public void mousePressedSelf(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Afmelden.fxml"));
        mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
    }

    public void mousePressedCancel(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Kalender.fxml"));
        mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
    }
}
