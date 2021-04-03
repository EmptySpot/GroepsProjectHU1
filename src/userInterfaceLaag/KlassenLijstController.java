package userInterfaceLaag;

import code.tester.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class KlassenLijstController {
    @FXML
    public TableView<Aanwezigheid> leerlingenInLes;
    @FXML
    TableColumn<Aanwezigheid, String> naamTabel;
    @FXML
    TableColumn<Aanwezigheid, String> leerlingnummerTabel;
    @FXML
    TableColumn<Aanwezigheid, String> aanwezigheid;
    @FXML
    TableColumn<Aanwezigheid, Button> buttonTableColumn;
    @FXML
    TableColumn<Aanwezigheid, ComboBox> RadioButtonColumn;

    public void initialize() throws IOException, SQLException {
        Persoon huidigeGebruiker = SelectedStatics.getPersoon();
        Docent docent = (Docent) huidigeGebruiker;
        OnlineLes les = SelectedStatics.getLes();
        DatabaseInfo.klasLeerlingen();
        DatabaseInfo.absentieLeerlingen();
        List<Leerling> leerlingenHuidigeKlas = les.getKlas().getLeerlingen();
        ObservableList<Aanwezigheid> data = FXCollections.observableArrayList();
        for (Leerling leerlingAanwezig : leerlingenHuidigeKlas) {
            for (Aanwezigheid aanwezigheidPerLes : leerlingAanwezig.getAanwezigheidlist()) {
                if (aanwezigheidPerLes.getOnlineLes() == les) {
                    data.add(aanwezigheidPerLes);
                    break;
                }
            }
            naamTabel.setCellValueFactory(new PropertyValueFactory<Aanwezigheid, String>("leerlingNaam"));
            leerlingnummerTabel.setCellValueFactory(new PropertyValueFactory<Aanwezigheid, String>("leerlingInfo"));
            aanwezigheid.setCellValueFactory(new PropertyValueFactory<Aanwezigheid, String>("aanwezig"));
            buttonTableColumn.setCellValueFactory(new PropertyValueFactory<Aanwezigheid, Button>("buttonAanwezig"));
            RadioButtonColumn.setCellValueFactory(new PropertyValueFactory<Aanwezigheid, ComboBox>("aanwezigheidComboBox"));
            leerlingenInLes.setEditable(true);
            leerlingenInLes.setItems(data);


        }
    }

    public void mousePressedDashboard(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
        mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
    }

    public void updateTable(){
        leerlingenInLes.refresh();
    }

    public void buttonOk(ActionEvent actionEvent) {
        for(Aanwezigheid aanwezigheid : leerlingenInLes.getItems()){
            aanwezigheid.getLeerlingInfo().updateAanwezigheid(aanwezigheid, aanwezigheid.aanwezigheidComboBoxGetSelected());
            }
        updateTable();
    }
}

