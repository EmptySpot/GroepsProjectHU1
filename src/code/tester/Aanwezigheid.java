package code.tester;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.util.ArrayList;

public class Aanwezigheid {
    private Leerling leerlingInfo;
    private String extraInformatie;
    private String aanwezig;
    private OnlineLes onlineLes;
    private Button buttonAanwezig;


    public Aanwezigheid(Leerling leerling, String extraI, String aanw, OnlineLes les){
        this.leerlingInfo = leerling;
        this.extraInformatie = extraI;
        this.aanwezig = aanw;
        this.onlineLes = les;
        this.buttonAanwezig = new Button("Absent");
    }

    public Leerling getLeerlingInfo() {
        return leerlingInfo;
    }

    public String getLeerlingNaam() {
        return leerlingInfo.getLeerlingNaam();
    }

    public String getAanwezig() {
        return aanwezig;
    }

    public void setAanwezig(String input){
        this.aanwezig = input;
    }

    public String getExtraInformatie() {
        return extraInformatie;
    }

    public void setExtraInformatie(String extraInformatie) {
        this.extraInformatie = extraInformatie;
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