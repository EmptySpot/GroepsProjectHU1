package userInterfaceLaag;

import code.tester.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class KalenderController {


    public ListView<OnlineLes> listViewTest;
    public Label testLabel;

    public void initialize(){
        Persoon huidigeGebruiker = SelectedStatics.getPersoon();
        List<OnlineLes> lessen;
        if(huidigeGebruiker instanceof  Leerling){
            Leerling leerling = (Leerling) huidigeGebruiker;
            lessen = leerling.getKlas().getLessen();
            ObservableList<OnlineLes> data = FXCollections.observableArrayList();
            data.addAll(lessen);
            listViewTest.setItems(data);
        }
        else if(huidigeGebruiker instanceof Docent) {
            Docent docent = (Docent) huidigeGebruiker;
            lessen = docent.getLessen();
            ObservableList<OnlineLes> data = FXCollections.observableArrayList();
            data.addAll(lessen);
            listViewTest.setItems(data);
        }
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
}


