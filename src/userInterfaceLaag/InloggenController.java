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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class InloggenController {
    @FXML
    private TextField gebruikersnaamInput;
    @FXML
    private PasswordField wachtwoordInput;
    @FXML
    private Label foutmeldingLabel;

    public void initialize() {
        //VERWIJDEREN BIJ RELEASE
        gebruikersnaamInput.setText("1");
        wachtwoordInput.setText("ww");
    }

    public void inloggen(ActionEvent actionEvent) throws IOException {
        SelectedStatics.setPersoon(null);

        String inlognaam = gebruikersnaamInput.getText();
        String wachtwoord = wachtwoordInput.getText();

        try {
            DatabaseQuerry.setDBConnection();
            Connection connection = DatabaseQuerry.getDBConnection();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from persoon WHERE persoonID = '" + inlognaam + "'");
            resultSet.next();
            if (wachtwoord.equals(resultSet.getString(3))) {
                SelectedStatics.setStatus(resultSet.getString(4));
                if (resultSet.getString(4).equals("Docent")) {
                    Docent docent = new Docent(resultSet.getString(2), resultSet.getString(1));
                    SelectedStatics.setPersoon(docent);
                } else if (resultSet.getString(4).equals("Leerling")) {
                    Klas klas = new Klas(resultSet.getString(5));
                    Leerling leerling = new Leerling(resultSet.getString(1), klas, resultSet.getString(3), resultSet.getString(2));
                    SelectedStatics.setPersoon(leerling);
                }
                FXMLLoader loader =
                        new FXMLLoader(getClass().getResource("MainView.fxml"));
                Parent root = loader.load();
                Scene homePage = new Scene(root);
                Stage appStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                appStage.setScene(homePage);
                appStage.setMinWidth(appStage.getWidth());
                appStage.setMinHeight(appStage.getHeight());
                appStage.show();
            } else {
                foutmeldingLabel.setText("Wachtwoord / inlognaam onjuist.");
            }
        } catch (SQLException e) {
            try {
                DatabaseQuerry.closeDBConnection();
            } catch (SQLException throwables) {
                foutmeldingLabel.setText("Error met de database");
            }
            foutmeldingLabel.setText("Wachtwoord / inlognaam onjuist.");
        }
    }

    public void tempAccountAanmaken(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AccountAanmakenLeerling.fxml"));
        mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
    }
}

