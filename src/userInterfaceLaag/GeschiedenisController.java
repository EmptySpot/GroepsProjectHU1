// deze klasse moet elke keer de afwezigheid van een student laten zien. // Waar haalt de klasse die info vandaan? // Eerst dummydata nodig? // De code moet een student hebben, diens klasseninfo hebben, voor elke les moet-ie doorspitten.  package userInterfaceLaag;  import code.tester.*; import javafx.fxml.FXML; import javafx.fxml.FXMLLoader; import javafx.scene.control.Label; import javafx.scene.control.RadioButton; import javafx.scene.control.TextArea; import javafx.scene.control.ToggleGroup; import javafx.scene.input.MouseEvent;  import java.io.IOException; import java.util.List;  public class GeschiedenisController {     @FXML     private Label afwezigCounterLabel;      public void initialize() {         if(SelectedStatics.getStatus().equals("Leerling")){             Leerling leerling = (Leerling) SelectedStatics.getPersoon();             System.out.println(leerling);             List<Aanwezigheid> aanwezigheidslist = leerling.getAanwezigheidlist();             System.out.println(
// deze klasse moet elke keer de afwezigheid van een student laten zien.
// Waar haalt de klasse die info vandaan?
// Eerst dummydata nodig?
// De code moet een student hebben, diens klasseninfo hebben, voor elke les moet-ie doorspitten.

package userInterfaceLaag;

import code.tester.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GeschiedenisController {
    @FXML private Button zoekButton;
    @FXML private TextField zoekNaam;
    @FXML private Label afwezigCounterLabel;
    @FXML private ListView<OnlineLes> aanwezigheidView;

    public void initialize() throws SQLException {
        if (SelectedStatics.getStatus().equals("Leerling")) {
            zoekNaam.setVisible(false);
            zoekButton.setVisible(false);
            Persoon huidigeGebruiker = SelectedStatics.getPersoon();
            Leerling leerling = (Leerling) huidigeGebruiker;
            listViewLessen(leerling);
        }
    }

    public void listViewLessen(Leerling leerling) throws SQLException {
        ObservableList<OnlineLes> data = FXCollections.observableArrayList();

        ArrayList<OnlineLes> absentlessen = DatabaseInfo.getAbsentieLessen(leerling);
        data.addAll(absentlessen);
        aanwezigheidView.setItems(data);
        afwezigCounterLabel.setText("" + data.size());
    }

    public void mousePressedZoek(MouseEvent mouseEvent) {
//        Leerling leerling = zoekNaam.getText();
//        listViewLessen(leerling);
    }
}





