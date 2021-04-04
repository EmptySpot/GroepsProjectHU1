package userInterfaceLaag;

import code.tester.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import static java.sql.DriverManager.getConnection;

public class InloggenController {
    @FXML
    private TextField gebruikersnaamInput;
    @FXML
    private PasswordField wachtwoordInput;
    @FXML
    private Label foutmeldingLabel;
    @FXML
    private Button inlogButton;
    private int counter = 0;

    public void initialize() {
        //VERWIJDEREN BIJ RELEASE
        gebruikersnaamInput.setText("69");
        wachtwoordInput.setText("ww");
    }

    public void inloggen(ActionEvent actionEvent) throws IOException, InterruptedException, SQLException {
        Path pad = Path.of("src/textfiles/attempts.txt");
        BufferedReader br = Files.newBufferedReader(pad);
        String regel = br.readLine();
        int attempt = Integer.parseInt(regel);
            SelectedStatics.setPersoon(null);
            String inlognaam = gebruikersnaamInput.getText();
            String wachtwoord = wachtwoordInput.getText();

            try {
                DatabaseQuerry.setDBConnection();
                Connection connection = DatabaseQuerry.getDBConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * from persoon WHERE persoonID = '" + inlognaam + "'");
                resultSet.next();
                if (wachtwoord.equals(resultSet.getString(3))&& resultSet.getString(6) == null) {
                    counter = 0;

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
                    counter++;

                    foutmeldingLabel.setText("Wachtwoord onjuist.");
                }
                if (resultSet.getString(6) != null) {
                    foutmeldingLabel.setText("Account is geblokkeerd.");
                }
            } catch (SQLException e) {
                try {
                    DatabaseQuerry.closeDBConnection();
                } catch (SQLException throwables) {
                    foutmeldingLabel.setText("Error met de database");
                }
                counter++;
                foutmeldingLabel.setText("Inlognaam onjuist.");

            }
            if (counter >= attempt) {
                foutmeldingLabel.setText("Te veel foute inlogpogingen.");
                DatabaseInfo.setGeblokkeerd(gebruikersnaamInput.getText());
        }

    }

    public void tempAccountAanmaken(MouseEvent mouseEvent) throws IOException, SQLException {
        DatabaseQuerry.setDBConnection();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AccountAanmakenLeerling.fxml"));
        mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
    }

    public void tempWachtwoordVergeten(MouseEvent mouseEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("HU agenda");
        alert.setHeaderText("Neem contact op met het volgende E-mail adress om u wachtwoord te herstellen");
        alert.setContentText("HUHelpdesk@outlook.com");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            alert.hide();
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Inloggen.fxml"));
            mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
        }

    }



}

