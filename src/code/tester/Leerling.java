package code.tester;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leerling {
    private String leerlingnummer;
    private String klas;
    private ArrayList<Aanwezigheid> aanwezigheidlist = new ArrayList<>();

    public Leerling(String lN, String kl){
        this.leerlingnummer = lN;
        this.klas = kl;

    }

    public void setAanwezigheid(String extraI, String aanw, OnlineLes les){
        Aanwezigheid a = new Aanwezigheid(this, extraI, aanw, les);
        aanwezigheidlist.add(a);
        System.out.println(a);
    }

    public String getLeerlingnummer() {
        return leerlingnummer;
    }

    public String getKlas() {
        return klas;
    }

    public List<Aanwezigheid> getAanwezigheidlist() {

        return Collections.unmodifiableList(aanwezigheidlist);
    }

    public void setLeerlingnummer(String leerlingnummer) {
        this.leerlingnummer = leerlingnummer;
    }

    @Override
    public String toString() {
        return "Leerling: " + leerlingnummer;
    }
}
