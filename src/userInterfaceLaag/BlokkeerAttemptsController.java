package userInterfaceLaag;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BlokkeerAttemptsController {
    @FXML private TextField pogingenTextfield;
    @FXML private Label meldingLabel;
    public void cancelButton1(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminDashboard.fxml"));
        mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
    }

    public void opslaan(ActionEvent actionEvent) throws IOException {
        Path pad = Path.of("src/textfiles/attempts.txt");
        BufferedWriter write = Files.newBufferedWriter(pad);

        write.write(pogingenTextfield.getText());
        write.close();
        meldingLabel.setText("U heeft succesvol het aantal pogingen aangepast naar: " + pogingenTextfield.getText());
    }
}
