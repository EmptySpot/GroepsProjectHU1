package code.tester;

import java.util.ArrayList;

public class Aanwezigheid {
    private Leerling l;
    private String extraInformatie;
    private String aanwezig = "Aanwezig";
    private OnlineLes onlineLes;


    public Aanwezigheid(Leerling leerl, String extraI, String aanw, OnlineLes les){
        this.l = leerl;
        this.extraInformatie = extraI;
        this.aanwezig = aanw;
        this.onlineLes = les;
    }

    @Override
    public String toString() {
        return "Aanwezigheid{" +
                "l=" + l +
                ", extraInformatie='" + extraInformatie + '\'' +
                ", aanwezig='" + aanwezig + '\'' +
                ", onlineLes=" + onlineLes +
                '}';
    }
}
//arraylist van leerlingen lessen reden en aanwezigheid