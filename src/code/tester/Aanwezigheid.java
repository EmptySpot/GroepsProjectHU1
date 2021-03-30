package code.tester;

import java.util.ArrayList;

public class Aanwezigheid {
    private Leerling leerling;
    private String extraInformatie;
    private String aanwezig = "Aanwezig";
    private OnlineLes onlineLes;


    public Aanwezigheid(Leerling leerling, String extraI, String aanw, OnlineLes les){
        this.leerling = leerling;
        this.extraInformatie = extraI;
        this.aanwezig = aanw;
        this.onlineLes = les;
    }

    public String getAanwezig() {
        return aanwezig;
    }

    @Override
    public String toString() {
        return "Aanwezigheid{" +
                "l=" + leerling +
                ", extraInformatie='" + extraInformatie + '\'' +
                ", aanwezig='" + aanwezig + '\'' +
                ", onlineLes=" + onlineLes +
                '}';
    }
}
//arraylist van leerlingen lessen reden en aanwezigheid