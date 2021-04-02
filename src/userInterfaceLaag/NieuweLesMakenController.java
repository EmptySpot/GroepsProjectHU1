package userInterfaceLaag;

import code.tester.Klas;
import code.tester.School;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import java.util.List;

public class NieuweLesMakenController {
    @FXML
    private ComboBox<Klas> klasComboBox;
    public void initialize() {
        List<Klas> klassen = School.getKlassen();
        klasComboBox.getItems().addAll(klassen);
    }
}
