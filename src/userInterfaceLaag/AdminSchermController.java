package userInterfaceLaag;

import code.tester.DatabaseQuerry;
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
    private VBox wachtwoordVbox;
    @FXML
    private VBox uitloggenVbox;


    public ListView<OnlineLes> listViewTest;
    public Label testLabel;

    public void initialize() throws IOException {
        mousePressedDashboard(null);
        setIconColor(0);
    }

    public void mousePressedDashboard(MouseEvent mouseEvent) throws IOException {
        Node node;
        node = FXMLLoader.load(getClass().getResource("/userInterfaceLaag/AdminDashboard.fxml"));
        ViewContainer.getChildren().setAll(node);
        setIconColor(0);
    }

    public void mousePressedDocentAanmaken(MouseEvent mouseEvent) throws IOException {
        Node node;
        node = FXMLLoader.load(getClass().getResource("/userInterfaceLaag/DocentAanmaken.fxml"));
        ViewContainer.getChildren().setAll(node);
        setIconColor(1);
    }

    public void mousePressedBeveiliging(MouseEvent mouseEvent) throws IOException {
        Node node;
        node = FXMLLoader.load(getClass().getResource("/userInterfaceLaag/Beveiliging.fxml"));
        ViewContainer.getChildren().setAll(node);
        setIconColor(2);
    }
    public void mousePressedKlasMaken(MouseEvent mouseEvent)throws  IOException{
        Node node;
        node = FXMLLoader.load(getClass().getResource("/userInterfaceLaag/KlasAanmaken.fxml"));
        ViewContainer.getChildren().setAll(node);
        setIconColor(3);
    }
    public void mousePressedWachtwoordOpvragen(MouseEvent mouseEvent)throws  IOException{
        Node node;
        node = FXMLLoader.load(getClass().getResource("/userInterfaceLaag/WachtwoordOpvragen.fxml"));
        ViewContainer.getChildren().setAll(node);
        setIconColor(4);
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

        Pane beveiligingBox = (Pane) BeveiligingVbox.getChildren().get(0);
        Label beveiligingLabel = (Label) BeveiligingVbox.getChildren().get(1);
        beveiligingBox.setId("Beveiliging");
        beveiligingLabel.setId("uit");

        Pane klasMakenBox = (Pane) klasMakenVbox.getChildren().get(0);
        Label klasMakenLabel = (Label)klasMakenVbox.getChildren().get(1);
        klasMakenBox.setId("klasMaken");
        klasMakenLabel.setId("uit");

        Pane wachtwoordBox = (Pane) wachtwoordVbox.getChildren().get(0);
        Label wachtwoordLabel = (Label) wachtwoordVbox.getChildren().get(1);
        wachtwoordBox.setId("wachtwoord");
        wachtwoordLabel.setId("uit");

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
                    beveiligingBox.setId("BeveiligingAan");
                    beveiligingLabel.setId("aan");
                }else if(nummer == 3){
                       klasMakenBox.setId("klasMakenAan");
                       klasMakenLabel.setId("aan");
                    }else if(nummer == 4){
                            wachtwoordBox.setId("wachtwoordAan");
                            wachtwoordLabel.setId("aan");
        }
    }
}




