package code.tester;

import com.sun.javafx.collections.ImmutableObservableList;

import java.util.ArrayList;

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

    public ArrayList<Aanwezigheid> getAanwezigheidlist() {

        return ImmutableObservableList(aanwezigheidlist);
    }

    public void setLeerlingnummer(int leerlingnummer) {
        this.leerlingnummer = leerlingnummer;
    }
}
