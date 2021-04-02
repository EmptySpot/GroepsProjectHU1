package userInterfaceLaag;

import code.tester.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class KalenderController {
    @FXML private DatePicker overzichtDatePicker;


    public ListView<OnlineLes> listViewTest;

    public void initialize() throws SQLException {
        overzichtDatePicker.setValue(LocalDate.now());
        toonLessen();
    }

    public void handleMouseClick(MouseEvent mouseEvent) throws IOException {
        OnlineLes l = listViewTest.getSelectionModel().getSelectedItem();
        if(l!=null){
            Persoon huidigeGebruiker = SelectedStatics.getPersoon();
            SelectedStatics.setLes(l);

            if(huidigeGebruiker instanceof  Leerling){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Afmelden.fxml"));
                mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
            }
            else if(huidigeGebruiker instanceof Docent) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("DocentKeuzeAfmelden.fxml"));
                mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
            }
        }
    }

    public void toonVorigeDag(ActionEvent actionEvent) {
        LocalDate dagEerder = overzichtDatePicker.getValue().minusDays(1);
        overzichtDatePicker.setValue(dagEerder);
    }

    public void toonVolgendeDag(ActionEvent actionEvent) {
        LocalDate dagLater = overzichtDatePicker.getValue().plusDays(1);
        overzichtDatePicker.setValue(dagLater);
    }

    public void toonLessen() throws SQLException {
        Persoon huidigeGebruiker = SelectedStatics.getPersoon();
        List<OnlineLes> lessen;
        if(huidigeGebruiker instanceof  Leerling){
            DatabaseInfo.lessenLeerling();
            Leerling leerling = (Leerling) huidigeGebruiker;
            lessen = leerling.getKlas().getLessen();
            listViewLessen(lessen);
        }
        else if(huidigeGebruiker instanceof Docent) {
            DatabaseInfo.lessenDocent();
            Docent docent = (Docent) huidigeGebruiker;
            lessen = docent.getLessen();
            listViewLessen(lessen);
        }
    }

    public void listViewLessen(List<OnlineLes> lessen){
        ObservableList<OnlineLes> data = FXCollections.observableArrayList();
        LocalDate geselecteerdeDatum =  overzichtDatePicker.getValue();
        for(OnlineLes les : lessen){
            LocalDate datum = les.getDatum().toLocalDate();
            if(geselecteerdeDatum.equals(datum)){
                data.add(les);
            }
        }
        listViewTest.setItems(data);
    }

    public void nieuweLes(ActionEvent actionEvent) {
    }
}


