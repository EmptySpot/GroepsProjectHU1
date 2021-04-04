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
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GeschiedenisController {
    @FXML private Label afwezigCounterLabel;

    public ListView<Aanwezigheid> aanwezigheidView;

    public void initialize() {
        if (SelectedStatics.getStatus().equals("Leerling")) {
            Leerling leerling = (Leerling) SelectedStatics.getPersoon();
            try {
                ArrayList<Aanwezigheid> test = DatabaseInfo.getAbsentieLeerling(leerling);
                for (Aanwezigheid AanwezigheidInList : test) {
                }
                afwezigCounterLabel.setText("" + test.size());
            } catch (Exception e) {}
        } else if (SelectedStatics.getStatus().equals("Docent")) {
//            Docent docent = (Docent) SelectedStatics.getPersoon();
        }
    }

//    public void toonLessen() throws SQLException {
//        Persoon huidigeGebruiker = SelectedStatics.getPersoon();
//        List<OnlineLes> lessen;
//
//        if(huidigeGebruiker instanceof  Leerling){
//            DatabaseInfo.getLessenLeerling();
//            Leerling leerling = (Leerling) huidigeGebruiker;
//            lessen = leerling.getKlas().getLessen();
//            listViewLessen(lessen);
//        }
//        else if(huidigeGebruiker instanceof Docent) {
////            DatabaseInfo.getLessenDocent();
////            Docent docent = (Docent) huidigeGebruiker;
////            lessen = docent.getLessen();
////            listViewLessen(lessen);
//        }
//    }
//
//    public void listViewLessen(List<OnlineLes> lessen){
//        ObservableList<OnlineLes> data = FXCollections.observableArrayList();
//        for(OnlineLes les : lessen){
//            if(getOnlinesles.getAanwezigheid().equals("Absent")){
//                data.add(les);
//            }
//        }
//        aanwezigheidView.setItems(data);
//    }


}


