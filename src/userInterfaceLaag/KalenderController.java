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
        try{
            Leerling leerling = (Leerling) huidigeGebruiker;
            lessen = leerling.getKlas().getLessen();
            ObservableList<OnlineLes> data = FXCollections.observableArrayList();
            data.addAll(lessen);
            listViewTest.setItems(data);
            System.out.println(lessen);
        } catch (Exception e) {
            try {
                Docent docent = (Docent) huidigeGebruiker;
                assert docent != null;
                lessen = docent.getLessen();
                ObservableList<OnlineLes> data = FXCollections.observableArrayList();
                data.addAll(lessen);
                listViewTest.setItems(data);
                System.out.println(lessen);
            } catch (Exception e2){
                System.out.println("Code broke" + e2);
            }
        }
    }

    public void handleMouseClick(MouseEvent mouseEvent) throws IOException {
        OnlineLes l = listViewTest.getSelectionModel().getSelectedItem();
        if(l!=null){
            SelectedStatics.setLes(l);
            testLabel.setText(String.valueOf(listViewTest.getSelectionModel().getSelectedItem()));
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Afmelden.fxml"));
            mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
        }
    }

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

}


