package userInterfaceLaag;

import code.tester.DatabaseInfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.sql.SQLException;

public class DeblokkerenController {
    @FXML private TextField gebruikersnaamInput;
    public void deblokkeren(ActionEvent actionEvent) throws SQLException {
        DatabaseInfo.setDeblokkeren(gebruikersnaamInput.getText());
    }

    public void cancelButton(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminDashboard.fxml"));
        mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
    }
}
