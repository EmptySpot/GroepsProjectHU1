package userInterfaceLaag;

import code.tester.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class MainViewController {
    @FXML private AnchorPane ViewContainer;
    @FXML private VBox dashBoardVbox;
    @FXML private VBox calendarVbox;
    @FXML private VBox historyVbox;


    public ListView<OnlineLes> listViewTest;
    public Label testLabel;

    public void initialize() throws IOException {
        mousePressedDashboard(null);
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
        Node node;
        node = (Node)FXMLLoader.load(getClass().getResource("/userInterfaceLaag/Dashboard.fxml"));
        System.out.println("Set main view to Dashboard");
        ViewContainer.getChildren().setAll(node);
    }

    public void mousePressedKalender(MouseEvent mouseEvent) throws IOException {
        Node node;
        System.out.println("brrr");
        node = (Node)FXMLLoader.load(getClass().getResource("/userInterfaceLaag/Kalender.fxml"));
        System.out.println("Set main view to Kalender");
        ViewContainer.getChildren().setAll(node);
    }

    public void mousePressedGeschiedenis(MouseEvent mouseEvent) throws IOException {
        Node node;
        node = (Node)FXMLLoader.load(getClass().getResource("/userInterfaceLaag/Geschiedenis.fxml"));
        System.out.println("Set main view to Geschiedenis");
        ViewContainer.getChildren().setAll(node);
    }


    public void mousePressedUitloggen(MouseEvent mouseEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("HU agenda");
        alert.setContentText("Weet je zeker dat je wilt uitloggen?");
        alert.setHeaderText(null);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.CANCEL) {
            alert.hide();
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Inloggen.fxml"));
            mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
        }
    }

    public void setIconColor(int opt){

    }

}


