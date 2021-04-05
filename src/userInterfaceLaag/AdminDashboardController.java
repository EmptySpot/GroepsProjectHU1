package userInterfaceLaag;

import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class AdminDashboardController {
    public void docentAanmakenButton(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DocentAanmaken.fxml"));
        mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
    }
    public void wachtwoordOpvragenButton(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("WachtwoordOpvragen.fxml"));
        mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
    }
    public void BlokkeerAttemptsButton(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BlokkeerAttempts.fxml"));
        mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
    }
    public void deblokkerenButton(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Beveiliging.fxml"));
        mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
    }

}
