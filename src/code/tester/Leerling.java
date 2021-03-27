package code.tester;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leerling {
    private int leerlingnummer;
    private String klas;
    private ArrayList<Aanwezigheid> aanwezigheidlist = new ArrayList<>();
    public Leerling(int lN, String kl){
        this.leerlingnummer = lN;
        this.klas = kl;
    }

    public void setAanwezigheid(String extraI, String aanw, OnlineLes les){
        Aanwezigheid a = new Aanwezigheid(this, extraI, aanw, les);
        aanwezigheidlist.add(a);
    }

    public List<Aanwezigheid> getAanwezigheidlist() {

        return Collections.unmodifiableList(aanwezigheidlist);
    }

    public void setLeerlingnummer(int leerlingnummer) {
        this.leerlingnummer = leerlingnummer;
    }
}
