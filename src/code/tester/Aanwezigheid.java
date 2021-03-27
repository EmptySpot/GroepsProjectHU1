package code.tester;

import java.util.ArrayList;

public class Aanwezigheid {
    private Leerling l;
    private String extraInformatie;
    private String aanwezig = "aanwezig";
    private OnlineLes onlineLes;
    private ArrayList<Aanwezigheid>aanwezigheids = new ArrayList<>();

    public Aanwezigheid(Leerling leerl, String extraI, String aanw, OnlineLes les){
        this.l = leerl;
        this.extraInformatie = extraI;
        this.aanwezig = aanw;
        this.onlineLes = les;
    }

}
//arraylist van leerlingen lessen reden en aanwezigheid