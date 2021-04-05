package userInterfaceLaag;

import code.tester.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class NieuweLesMakenController {
    @FXML private ToggleGroup verplichtToggleGroup;
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
    //@FXML private TextField minimumTextBox;
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

    public void opslaan() throws SQLException {
        if (datePicker.getValue() == null) {
            errorLabel.setText("Vul een datum in");
        } else if (lescodeTextBox.getText().equals("")) {
            errorLabel.setText("Vul de vakcode in");
        } else if (lesnaamTextBox.getText().equals("")) {
            errorLabel.setText("Vul een lesnaam in");
        } else if (vaknaamTextBox.getText().equals("")) {
            errorLabel.setText("Vul een vaknaam in");
        } else if (klasComboBox.getSelectionModel().getSelectedItem() == null) {
            errorLabel.setText("Vul een klas in");
        } else if (urenComboBox.getSelectionModel().getSelectedItem() == null) {
            errorLabel.setText("Vul de tijden in");
//        } else if {minimumTextBox.getText().equals("")) {
//            errorLabel.setText("Vul een minimum aantal uren in");
        } else {
            String klasnaam = klasComboBox.getSelectionModel().getSelectedItem().getNaam();
            Date datum = Date.valueOf(datePicker.getValue());
            String selectedUren = urenComboBox.getSelectionModel().getSelectedItem();
            String selectedMinuten = kwartierenComboBox.getSelectionModel().getSelectedItem();
            Time tijd = Time.valueOf(selectedUren + ":" + selectedMinuten + ":00");
            RadioButton oma = (RadioButton) verplichtToggleGroup.getSelectedToggle();
            boolean verplicht = oma.getText().equals("Ja");
            String lesnaam = lesnaamTextBox.getText();
            String vaknaam = vaknaamTextBox.getText();
            Docent docent = (Docent) SelectedStatics.getPersoon();
            String persoonid = docent.getDocentCode();
            String vakcode = lescodeTextBox.getText();
//            int minimum = minimumTextBox.getText();

            DatabaseInfo.setLes(klasnaam, datum, tijd, verplicht, lesnaam, vaknaam, persoonid, vakcode);
        }

        //todo }

    }

}