package code.tester;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import userInterfaceLaag.KlassenLijstController;

import javax.swing.*;
import java.util.ArrayList;

public class Aanwezigheid {
    private Leerling leerlingInfo;
    private String extraInformatie;
    private SimpleStringProperty aanwezig;
    private OnlineLes onlineLes;
    private Button buttonAanwezig;
    private ButtonGroup aanwezigAfwezig = new ButtonGroup();
    private JRadioButton radioButtonAanwezig1;
    private JRadioButton radioButtonAfwezig1;

    public Aanwezigheid(Leerling leerling, String extraI, String aanwezigheid, OnlineLes les){
        this.leerlingInfo = leerling;
        this.extraInformatie = extraI;
        this.aanwezig = new SimpleStringProperty(aanwezigheid);
        this.onlineLes = les;
        this.buttonAanwezig = new Button("Absent");
        this.radioButtonAanwezig1 = new JRadioButton("Aanwezig");
        this.radioButtonAfwezig1 = new JRadioButton("Afwezig");
        this.aanwezigAfwezig.add(radioButtonAanwezig1);
        this.aanwezigAfwezig.add(radioButtonAfwezig1);
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

    public JRadioButton getRadioButtonAanwezig1() {
        return radioButtonAanwezig1;
    }

    public JRadioButton getRadioButtonAfwezig1() {
        return radioButtonAfwezig1;
    }

    public Button getButtonAanwezig() {
        buttonAanwezig.setOnAction((ActionEvent event) -> {
            leerlingInfo.updateAanwezigheid(this, "Absent");

        });
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
}
//arraylist van leerlingen lessen reden en aanwezigheid