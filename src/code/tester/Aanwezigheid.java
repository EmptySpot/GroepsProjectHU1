package code.tester;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class Aanwezigheid {
    private Leerling leerlingInfo;
    private Docent docentInfo;
    private String extraInformatie;
    private SimpleStringProperty aanwezig;
    private OnlineLes onlineLes;
    private Button buttonAanwezig;
    private ComboBox<String> aanwezigheidComboBox;

    public Aanwezigheid(Leerling leerling, String extraI, String aanwezigheid, OnlineLes les){
        this.leerlingInfo = leerling;
        this.extraInformatie = extraI;
        this.aanwezig = new SimpleStringProperty(aanwezigheid);
        this.onlineLes = les;
        this.buttonAanwezig = new Button("Info");
        this.aanwezigheidComboBox = new ComboBox<String>();
    }
    
    public Aanwezigheid(Docent docent, String aanwezigheid, OnlineLes les){
        this.docentInfo = docent;
        this.aanwezig = new SimpleStringProperty(aanwezigheid);
        this.onlineLes = les;
        this.buttonAanwezig = new Button("Absent");
        this.aanwezigheidComboBox = new ComboBox<String>();
    }

    public ComboBox<String> getAanwezigheidComboBox() {
        ObservableList<String> data = FXCollections.observableArrayList("Aanwezig","Absent", "Vertraagd");
        aanwezigheidComboBox.setItems(data);
        aanwezigheidComboBox.setValue(getAanwezig());
        return aanwezigheidComboBox;
    }

    public Leerling getLeerlingInfo() {
        return leerlingInfo;
    }

    public String getLeerlingNaam() {
        return leerlingInfo.getLeerlingNaam();
    }

    public String getAanwezig() {
        return aanwezig.get();
    }

    public void setAanwezig(String input){
        this.aanwezig = new SimpleStringProperty(input);
    }

    public String getExtraInformatie() {
        return extraInformatie;
    }

    public void setExtraInformatie(String extraInformatie) {
        this.extraInformatie = extraInformatie;
    }


    public Button getButtonAanwezig() {
        if(extraInformatie.equals("")){
           buttonAanwezig.setVisible(false);
        } else {
            buttonAanwezig.setOnAction((ActionEvent event) -> {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(getLeerlingNaam());
                alert.setContentText(extraInformatie);
                alert.setHeaderText(null);
                alert.show();

            });
        }
        return buttonAanwezig;
    }

    public OnlineLes getOnlineLes() {
        return onlineLes;
    }

    @Override
    public String toString() {
        return "Aanwezigheid{" +
                "l=" + leerlingInfo +
                ", extraInformatie='" + extraInformatie + '\'' +
                ", aanwezig='" + aanwezig + '\'' +
                ", onlineLes=" + onlineLes +
                '}';
    }

    public String aanwezigheidComboBoxGetSelected() {
        return aanwezigheidComboBox.getSelectionModel().getSelectedItem();
    }

    public String getNummer() {
        if(leerlingInfo!=null){
            return leerlingInfo.getLeerlingnummer();
        } else {
            return docentInfo.getDocentCode();
        }
    }
}
//arraylist van leerlingen lessen reden en aanwezigheid