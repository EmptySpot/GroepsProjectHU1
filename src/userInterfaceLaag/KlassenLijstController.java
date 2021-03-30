package userInterfaceLaag;

import code.tester.*;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class KlassenLijstController {
    @FXML private TableView leerlingenInLes;

    public void initialize() {
        Persoon huidigeGebruiker = SelectedStatics.getPersoon();
        Docent docent = (Docent) huidigeGebruiker;
        OnlineLes les = SelectedStatics.getLes();
        List<Leerling> leerlingenHuidigeKlas = les.getKlas().getLeerlingen();
        ObservableList<Leerling> data = FXCollections.observableArrayList();
        data.addAll(leerlingenHuidigeKlas);
        System.out.println(data);
        TableColumn leerlingNaam = new TableColumn("Naam");
        leerlingenInLes.getColumns().addAll(leerlingNaam);

        leerlingNaam.setCellValueFactory(new PropertyValueFactory<Leerling,String>("naam"));
        leerlingenInLes.setItems(data);

//            leerlingNaam.setCellValueFactory(new PropertyValue<Leerling,String>("naam"));
        }
//        TableColumn leerlingCode = new TableColumn("Leerlingnummer");
//        leerlingCode.setCellValueFactory(
//                new PropertyValueFactory<Leerling,String>("persoonCode")
//        );
//        TableColumn leerlingAfwezig = new TableColumn("Afwezig");
//        leerlingAfwezig.setCellValueFactory(
//                new PropertyValueFactory<Leerling,String>("naam")
//        );

//        leerlingenInLes.getColumns().addAll(leerlingNaam, leerlingCode, leerlingAfwezig);
}


