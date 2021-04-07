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

    public void mousePressedZoek(MouseEvent mouseEvent) throws SQLException {
        if(zoekNaam.getText().matches("-?(0|[1-9]\\d*)")){
            Leerling leerling = DatabaseInfo.getLeerling(zoekNaam.getText());
            if(leerling!=null) {
                Docent docent = (Docent) SelectedStatics.getPersoon();
                SelectedStatics.setPersoon(leerling);
                listViewLessen(leerling);
                SelectedStatics.setPersoon(docent);
            }
        }
    }
}





