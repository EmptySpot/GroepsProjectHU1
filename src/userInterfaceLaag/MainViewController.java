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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.*;

public class MainViewController {
    @FXML private AnchorPane ViewContainer;
    @FXML private GridPane sideBarGrid;
    @FXML private VBox dashBoardVbox;
    @FXML private VBox calendarVbox;
    @FXML private VBox historyVbox;


    public ListView<OnlineLes> listViewTest;
    public Label testLabel;

    public void initialize() throws IOException {
        mousePressedDashboard(null);
        setIconColor(0);
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
        ViewContainer.getChildren().setAll(node);
        setIconColor(0);
    }

    public void mousePressedKalender(MouseEvent mouseEvent) throws IOException {
        Node node;
        node = (Node)FXMLLoader.load(getClass().getResource("/userInterfaceLaag/Kalender.fxml"));
        ViewContainer.getChildren().setAll(node);
        setIconColor(1);
    }

    public void mousePressedGeschiedenis(MouseEvent mouseEvent) throws IOException {
        Node node;
        node = (Node)FXMLLoader.load(getClass().getResource("/userInterfaceLaag/Geschiedenis.fxml"));
//        System.out.println("Set main view to Geschiedenis");
        ViewContainer.getChildren().setAll(node);
        setIconColor(2);
    }


    public void mousePressedUitloggen(MouseEvent mouseEvent) throws IOException, SQLException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("HU agenda");
        alert.setContentText("Weet je zeker dat je wilt uitloggen?");
        alert.setHeaderText(null);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.CANCEL) {
            alert.hide();
        } else {
            DatabaseQuerry.closeDBConnection();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Inloggen.fxml"));
            mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
        }
    }

    public void setIconColor(int paginaNummer){

        Pane dbvbox = (Pane) dashBoardVbox.getChildren().get(0);
        Label dbvlabel = (Label) dashBoardVbox.getChildren().get(1);
        dbvbox.setId("dashboardShape");
        dbvlabel.setId("fontNotSelected");


        Pane cdvbox = (Pane) calendarVbox.getChildren().get(0);
        Label cdvlabel = (Label) calendarVbox.getChildren().get(1);
        cdvbox.setId("calendarShape");
        cdvlabel.setId("fontNotSelected");



        Pane hsvbox = (Pane) historyVbox.getChildren().get(0);
        Label hsvlabel = (Label) historyVbox.getChildren().get(1);
        hsvbox.setId("historyShape");
        hsvlabel.setId("fontNotSelected");



       if(paginaNummer == 0) {
           dbvbox.setId("dashboardShapeSelected");
           dbvlabel.setId("fontSelected");
       } else if (paginaNummer == 1) {
               cdvbox.setId("calendarShapeSelected");
               cdvlabel.setId("fontSelected");
           } else if(paginaNummer == 2) {
                   hsvbox.setId("historyShapeSelected");
                   hsvlabel.setId("fontSelected");
                }
        }
}




