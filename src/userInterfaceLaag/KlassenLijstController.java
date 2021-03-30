package userInterfaceLaag;

import code.tester.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
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

    public void initialize() throws IOException {
        Persoon huidigeGebruiker = SelectedStatics.getPersoon();
        Docent docent = (Docent) huidigeGebruiker;
        OnlineLes les = SelectedStatics.getLes();
        List<Leerling> leerlingenHuidigeKlas = les.getKlas().getLeerlingen();
        ObservableList<Aanwezigheid> data = FXCollections.observableArrayList();
        for(Leerling leerlingAanwezig : leerlingenHuidigeKlas){
            for(Aanwezigheid aanwezigheidPerLes : leerlingAanwezig.getAanwezigheidlist()){
                System.out.println(data);
                if(aanwezigheidPerLes.getOnlineLes() == les){
                    data.add(aanwezigheidPerLes);
                    break;
//                    && !data.contains(aanwezigheidPerLes
                }
            }

        }
        System.out.println(data);
//        System.out.println(data.get(0).getAanwezigheidlist());
        naamTabel.setCellValueFactory(new PropertyValueFactory<Aanwezigheid, String>("leerlingNaam"));
        leerlingnummerTabel.setCellValueFactory(new PropertyValueFactory<Aanwezigheid, String>("leerlingInfo"));
        aanwezigheid.setCellValueFactory(new PropertyValueFactory<Aanwezigheid, String>("aanwezig"));
        buttonTableColumn.setCellValueFactory(new PropertyValueFactory<Aanwezigheid, Button>("buttonAanwezig"));
        leerlingenInLes.setItems(data);
        System.out.println(data);


    }
}

