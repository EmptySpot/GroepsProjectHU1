package userInterfaceLaag;

import code.tester.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KlassenLijstController {
    @FXML
    public TableView<Leerling> leerlingenInLes;
    @FXML
    TableColumn<Leerling, String> naamTabel;
    @FXML
    TableColumn<Leerling, String> leerlingnummerTabel;
    @FXML
    TableColumn<Aanwezigheid, String> aanwezigheid;
    public void initialize() throws IOException {
        Persoon huidigeGebruiker = SelectedStatics.getPersoon();
        Docent docent = (Docent) huidigeGebruiker;
        OnlineLes les = SelectedStatics.getLes();
        List<Leerling> leerlingenHuidigeKlas = les.getKlas().getLeerlingen();
        ObservableList<Leerling> data = FXCollections.observableArrayList(leerlingenHuidigeKlas);
//        System.out.println(data.get(0).getAanwezigheidlist());
        naamTabel.setCellValueFactory(new PropertyValueFactory<Leerling, String>("leerlingNaam"));
        leerlingnummerTabel.setCellValueFactory(new PropertyValueFactory<Leerling, String>("leerlingnummer"));
//        aanwezigheid.setCellValueFactory(new PropertyValueFactory<Aanwezigheid, String>("aanwezig"));
        leerlingenInLes.setItems(data);
        System.out.println(data);


    }
}

