package userInterfaceLaag;

import code.tester.Klas;
import code.tester.School;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NieuweLesMakenController {
    @FXML
    private ComboBox<Klas> klasComboBox;
    @FXML
    private ComboBox<String> urenComboBox;
    @FXML
    private ComboBox<String> kwartierenComboBox;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Label errorLabel;
    @FXML
    private TextField lescodeTextBox;
    @FXML
    private TextField lesnaamTextBox;
    @FXML
    private TextField vaknaamTextBox;
    private ArrayList<String> urenArray = new ArrayList<>();
    private ArrayList<String> kwartierenArray = new ArrayList<>();

    public void initialize() throws SQLException {
        int counter = 0;
        while (counter < 24) {
            urenArray.add("" + counter);
            counter++;
        }
        kwartierenArray.add("0");
        kwartierenArray.add("15");
        kwartierenArray.add("30");
        kwartierenArray.add("45");
        kwartierenComboBox.getItems().addAll(kwartierenArray);
        urenComboBox.getItems().addAll(urenArray);
        List<Klas> klassen = School.getKlassen();
        klasComboBox.getItems().addAll(klassen);
    }

    public void opslaan() {
        if (datePicker.getValue() == null) {
            errorLabel.setText("Vul een datum in");
        } else if (lescodeTextBox.getText().equals("")) {
            errorLabel.setText("Vul de lescode in");
        } else if (lesnaamTextBox.getText().equals("")) {
            errorLabel.setText("Vul een lesnaam in");
        } else if (vaknaamTextBox.getText().equals("")) {
            errorLabel.setText("Vul een vaknaam in");
        } else if (klasComboBox.getSelectionModel().getSelectedItem() == null) {
            errorLabel.setText("Vul een klas in");
        } else if (urenComboBox.getSelectionModel().getSelectedItem() == null) {
            errorLabel.setText("Vul de tijden in");
        } // todo else database {

        //todo }
    }
}