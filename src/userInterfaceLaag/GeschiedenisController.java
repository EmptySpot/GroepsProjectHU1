// deze klasse moet elke keer de afwezigheid van een student laten zien. // Waar haalt de klasse die info vandaan? // Eerst dummydata nodig? // De code moet een student hebben, diens klasseninfo hebben, voor elke les moet-ie doorspitten.  package userInterfaceLaag;  import code.tester.*; import javafx.fxml.FXML; import javafx.fxml.FXMLLoader; import javafx.scene.control.Label; import javafx.scene.control.RadioButton; import javafx.scene.control.TextArea; import javafx.scene.control.ToggleGroup; import javafx.scene.input.MouseEvent;  import java.io.IOException; import java.util.List;  public class GeschiedenisController {     @FXML     private Label afwezigCounterLabel;      public void initialize() {         if(SelectedStatics.getStatus().equals("Leerling")){             Leerling leerling = (Leerling) SelectedStatics.getPersoon();             System.out.println(leerling);             List<Aanwezigheid> aanwezigheidslist = leerling.getAanwezigheidlist();             System.out.println(
// deze klasse moet elke keer de afwezigheid van een student laten zien.
// Waar haalt de klasse die info vandaan?
// Eerst dummydata nodig?
// De code moet een student hebben, diens klasseninfo hebben, voor elke les moet-ie doorspitten.

package userInterfaceLaag;

import code.tester.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.List;

public class GeschiedenisController {
    @FXML private Label afwezigCounterLabel;

    public void initialize() {
        if (SelectedStatics.getStatus().equals("Leerling")) {
            Leerling leerling = (Leerling) SelectedStatics.getPersoon();
            List<Aanwezigheid> aanwezigheidslist = leerling.getAanwezigheidlist();
            int afwezigheidCounter = 0;
            for (Aanwezigheid aanwezigheidInList : aanwezigheidslist) {
                if (aanwezigheidInList.getAanwezig().equals("Absent")) {
                    afwezigheidCounter += 1;
                }
            }
            afwezigCounterLabel.setText("" + afwezigheidCounter);
        } else if (SelectedStatics.getStatus().equals("Docent")) {
//            Docent docent = (Docent) SelectedStatics.getPersoon();
        }
    }

//    public String AfwezigheidPerLes(){
//        if (SelectedStatics.getStatus().equals("Leerling")) {
//            Leerling leerling = (Leerling) SelectedStatics.getPersoon();
//            List<Aanwezigheid> aanwezigheidslist = leerling.getAanwezigheidlist();
//            int afwezigheidCounter = 0;
//            for (Aanwezigheid aanwezigheidInList : aanwezigheidslist) {
//                if (aanwezigheidInList.getAanwezig().equals("Absent")) {
//                    afwezigheidCounter += 1;
//                }
//            }
//            afwezigCounterLabel.setText("" + afwezigheidCounter);
//        }
//    }
}
