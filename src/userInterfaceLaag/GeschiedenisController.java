// deze klasse moet elke keer de afwezigheid van een student laten zien.
// Waar haalt de klasse die info vandaan?
// Eerst dummydata nodig?
// De code moet een student hebben, diens klasseninfo hebben, voor elke les moet-ie doorspitten.

package userInterfaceLaag;

import code.tester.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class GeschiedenisController {
    public void mousePressedDashboard(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
        mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
    }

    public void mousePressedKalender(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Kalender.fxml"));
        mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
    }

    public void mousePressedGeschiedenis(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Geschiedenis.fxml"));
        mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
    }

    public void mousePressedUitloggen(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Inloggen.fxml"));
        mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
    }

//    private HUApp account = new account.getHuidigeUser();
//
//    public void initialize() {
//        textField.setText("" + account.getAfwezigheid.size()); // aantal keren afwezig
//    }

//    Met een for-loop door de aanwezigheid, moet zoeken naar "student" in "rooster"
//    Allemaal in de initializer
//
//    <fx.id Label.text("Aantal keren afwezig: ") + getAanwezigheid().size();
    }

