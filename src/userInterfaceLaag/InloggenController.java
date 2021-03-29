package userInterfaceLaag;

import code.tester.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class InloggenController {
    @FXML
    private TextField gebruikersnaamInput;
    @FXML
    private PasswordField wachtwoordInput;
    @FXML
    private Label foutmeldingLabel;

    public void initialize() {
    }

    public void inloggen(ActionEvent actionEvent) throws IOException {
        SelectedStatics.setPersoon(null);
//        FXMLLoader loader =
//                            new FXMLLoader(getClass().getResource("Dashboard.fxml"));
//                    Parent root = loader.load();
//
//                    Scene homePage = new Scene(root);
//                    Stage appStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
//                    appStage.setScene(homePage);
//                    appStage.show();

        BufferedReader reader = new BufferedReader(new FileReader("src/textfiles/leerlingen.txt")) ;
        String line;
        while ((line = reader.readLine()) != null) {
                String[] splitted = line.split(":");
                String inlognaam = gebruikersnaamInput.getText();
                if(inlognaam.equals(splitted[0]) && wachtwoordInput.getText().equals(splitted[1])) {
                    List<Klas> klassen = School.getKlassen();
                    for(Klas klas: klassen) {
                        List<Leerling> leerlingen = klas.getLeerlingen();
                        for (Leerling leerling : leerlingen) {
                            if (leerling.getLeerlingnummer().equals(inlognaam)) {
                                SelectedStatics.setStatus("Leerling");
                                SelectedStatics.setPersoon(leerling);
                                System.out.println("Brrr");
                                break;
                            }
                        }
                    }
                    System.out.println(SelectedStatics.getPersoon());
                    System.out.println("brrrrrr");
                    if(SelectedStatics.getPersoon() == null){
                        System.out.println("ASHJhnjedrfdjh");
                        List<Docent> docenten = School.getDocenten();
                        System.out.println(docenten);
                        for(Docent docent : docenten){
                            System.out.println("fffufufuufufufu");
                            if(docent.getDocentCode().equals(inlognaam)) {
                                System.out.println("Docent");
                                SelectedStatics.setStatus("Docent");
                                SelectedStatics.setPersoon(docent);
                                break;
                            }
                        }
                    }
                    FXMLLoader loader =
                            new FXMLLoader(getClass().getResource("MainView.fxml"));
                    Parent root = loader.load();

                    //TODO: Mensen aanmaken weer aanzetten + unieke personen codes.

                    Scene homePage = new Scene(root);
                    Stage appStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    appStage.setScene(homePage);
                    appStage.show();
                } else {
                    foutmeldingLabel.setText("verkeerd wachtwoord");
                }
            }
        }
    }

