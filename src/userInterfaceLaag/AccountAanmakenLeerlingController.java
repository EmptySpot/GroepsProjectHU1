package userInterfaceLaag;

import code.tester.Klas;
import code.tester.Leerling;
import code.tester.School;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class AccountAanmakenLeerlingController {

    @FXML private TextField naam;
    @FXML private TextField studentnummer;
    @FXML private TextField wachtwoord;
    @FXML private TextField wachtwoordHerhaal;
    @FXML private ChoiceBox<Klas> klassenList;
    @FXML private Label errorLocatie;

    public void initialize() {
        List<Klas> klassen = School.getKlassen();
        klassenList.getItems().addAll(klassen);
    }

    public void mousePressedUitloggen(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Inloggen.fxml"));
        mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
    }

    public void mousePressedAanmaken(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        errorLocatie.setText("");
        if(naam.getText().equals("")){
            errorLocatie.setText("Geef een naam op");
        } else if (studentnummer.getText().equals("")){
            errorLocatie.setText("Geef een studentnummer");
        } else if (wachtwoord.getText().equals("")){
            errorLocatie.setText("Geef een wachtwoord");
        } else if(!wachtwoord.getText().equals(wachtwoordHerhaal.getText())){
            errorLocatie.setText("Herhaal hetzelfde wachtwoord");
        } else if(klassenList.getSelectionModel().getSelectedItem()==null){
            errorLocatie.setText("Selecteer je klas");
        } else {
            Leerling nieuw = new Leerling(studentnummer.getText(), klassenList.getSelectionModel().getSelectedItem(), wachtwoord.getText(), naam.getText());
            BufferedWriter writeLeerling = new BufferedWriter(new FileWriter("src/textfiles/leerlingen.txt", true));
            writeLeerling.write(studentnummer.getText() + ":" + wachtwoord.getText());
            writeLeerling.newLine();
            writeLeerling.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Inloggen.fxml"));
            mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
        }

    }
}
