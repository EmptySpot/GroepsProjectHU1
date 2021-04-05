// deze klasse moet elke keer de afwezigheid van een student laten zien. // Waar haalt de klasse die info vandaan? // Eerst dummydata nodig? // De code moet een student hebben, diens klasseninfo hebben, voor elke les moet-ie doorspitten.  package userInterfaceLaag;  import code.tester.*; import javafx.fxml.FXML; import javafx.fxml.FXMLLoader; import javafx.scene.control.Label; import javafx.scene.control.RadioButton; import javafx.scene.control.TextArea; import javafx.scene.control.ToggleGroup; import javafx.scene.input.MouseEvent;  import java.io.IOException; import java.util.List;  public class GeschiedenisController {     @FXML     private Label afwezigCounterLabel;      public void initialize() {         if(SelectedStatics.getStatus().equals("Leerling")){             Leerling leerling = (Leerling) SelectedStatics.getPersoon();             System.out.println(leerling);             List<Aanwezigheid> aanwezigheidslist = leerling.getAanwezigheidlist();             System.out.println(
// deze klasse moet elke keer de afwezigheid van een student laten zien.
// Waar haalt de klasse die info vandaan?
// Eerst dummydata nodig?
// De code moet een student hebben, diens klasseninfo hebben, voor elke les moet-ie doorspitten.

package userInterfaceLaag;

import code.tester.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GeschiedenisController {
    @FXML private Label afwezigCounterLabel;

    @FXML private ListView<OnlineLes> aanwezigheidView;

    public void initialize() throws SQLException {
        if (SelectedStatics.getStatus().equals("Leerling")) {
            Leerling leerling = (Leerling) SelectedStatics.getPersoon();
            toonLessenGeschiedenis();

            try {
                ArrayList<Aanwezigheid> test = DatabaseInfo.getAbsentieLeerling(leerling);
                for (Aanwezigheid AanwezigheidInList : test) {
                }
                afwezigCounterLabel.setText("" + test.size());
            } catch (Exception e) {}


        }
    }
//    SELECT * FROM  aanwezigheid
//    WHERE aanwezigheid.aanwezigheid = 'Absent' and aanwezigheid.persoonpersoonid = 1 and leslescode = 2
    public void toonLessenGeschiedenis() throws SQLException {
        Persoon huidigeGebruiker = SelectedStatics.getPersoon();
        List<OnlineLes> lessen;
        if(huidigeGebruiker instanceof  Leerling){
            DatabaseInfo.getAbsentLessenLeerling();
            Leerling leerling = (Leerling) huidigeGebruiker;
            lessen = leerling.getKlas().getLessen();
            listViewLessen(lessen);
        }

    }

    public void listViewLessen(List<OnlineLes> lessen) throws SQLException {

        ObservableList<OnlineLes> data = FXCollections.observableArrayList();
        DatabaseQuerry.setDBConnection();
        Persoon huidigeGebruiker = SelectedStatics.getPersoon();
        Leerling leerling = (Leerling) huidigeGebruiker;
        Connection connection = DatabaseQuerry.getDBConnection();
        Statement statement = connection.createStatement();
        for(OnlineLes les : lessen){
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM  aanwezigheid\n" +
//                    "    WHERE aanwezigheid.aanwezigheid = 'Absent' and aanwezigheid.persoonpersoonid = "+leerling+" and leslescode = "+les.getLesCode());
//            if(resultSet.next()) {
                data.add(les);}
            aanwezigheidView.setItems(data);
            }
        }





