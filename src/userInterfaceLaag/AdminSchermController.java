package userInterfaceLaag;

import code.tester.DatabaseQuerry;
import code.tester.Klas;
import code.tester.OnlineLes;
import code.tester.SelectedStatics;
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
import java.util.Optional;


public class AdminSchermController{
    @FXML
    private AnchorPane ViewContainer;
    @FXML
    private VBox dashBoardVbox;
    @FXML
    private VBox DocentAanmakenVbox;
    @FXML
    private VBox BeveiligingVbox;
    @FXML
    private VBox klasMakenVbox;
    @FXML
    private VBox uitloggenVbox;


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
        node = (Node)FXMLLoader.load(getClass().getResource("/userInterfaceLaag/AdminDashboard.fxml"));
        ViewContainer.getChildren().setAll(node);
        setIconColor(0);
    }

    public void mousePressedDocentAanmaken(MouseEvent mouseEvent) throws IOException {
        Node node;
        node = (Node)FXMLLoader.load(getClass().getResource("/userInterfaceLaag/DocentAanmaken.fxml"));
        ViewContainer.getChildren().setAll(node);
        setIconColor(1);
    }

    public void mousePressedBeveiliging(MouseEvent mouseEvent) throws IOException {
        Node node;
        node = (Node)FXMLLoader.load(getClass().getResource("/userInterfaceLaag/Deblokkeren.fxml"));
        ViewContainer.getChildren().setAll(node);
        setIconColor(2);
    }
    public void mousePressedKlasMaken(MouseEvent mouseEvent)throws  IOException{
        Node node;
        node = (Node)FXMLLoader.load(getClass().getResource("/userInterfaceLaag/KlasAanmaken.fxml"));
        ViewContainer.getChildren().setAll(node);
        setIconColor(3);
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

    public void setIconColor(int nummer){
        Pane dashboardbox = (Pane) dashBoardVbox.getChildren().get(0);
        Label dashboardLabel = (Label) dashBoardVbox.getChildren().get(1);
        dashboardbox.setId("dashboard");
        dashboardLabel.setId("uit");

        Pane docentAanmakenbox = (Pane) DocentAanmakenVbox.getChildren().get(0);
        Label docentMakenLabel = (Label) DocentAanmakenVbox.getChildren().get(1);
        docentAanmakenbox.setId("DocentMaken");
        docentMakenLabel.setId("uit");

        Pane beveiligingbox = (Pane) BeveiligingVbox.getChildren().get(0);
        Label beveiligingLabel = (Label) BeveiligingVbox.getChildren().get(1);
        beveiligingbox.setId("Beveiliging");
        beveiligingLabel.setId("uit");

        Pane klasMakenbox = (Pane) klasMakenVbox.getChildren().get(0);
        Label klasMakenLabel = (Label)klasMakenVbox.getChildren().get(1);
        klasMakenbox.setId("klasMaken");
        klasMakenLabel.setId("uit");

        Pane uitloggenBox = (Pane) uitloggenVbox.getChildren().get(0);
        Label uitloggenLabel = (Label) uitloggenVbox.getChildren().get(1);
        uitloggenBox.setId("uitloggen");
        uitloggenLabel.setId("uit");

        if(nummer == 0) {
            dashboardbox.setId("dashboardAan");
            dashboardLabel.setId("aan");
        } else if (nummer == 1) {
            docentAanmakenbox.setId("DocentMakenAan");
                docentMakenLabel.setId("aan");
            } else if(nummer == 2){
                    beveiligingbox.setId("BeveiligingAan");
                    beveiligingLabel.setId("aan");
                }else if(nummer == 3){
                       klasMakenbox.setId("klasMakenAan");
                       klasMakenLabel.setId("aan");
        }
    }
}




