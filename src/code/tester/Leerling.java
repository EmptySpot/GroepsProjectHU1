package code.tester;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leerling extends Persoon{
    private Klas klas;
    private String naam;
    private ArrayList<Aanwezigheid> aanwezigheidlist = new ArrayList<>();

    public Leerling(String leerlingNummer, Klas klas, String wachtWoord, String naam) throws IOException {
        super(leerlingNummer);
        this.klas = klas;
        this.naam = naam;
        klas.leerlingAppenden(this);
//        BufferedWriter writeLeerling = new BufferedWriter(new FileWriter("src/textfiles/leerlingen.txt", true));
//        writeLeerling.write(leerlingnummer + ":" + wachtWoord);
//        writeLeerling.newLine();
//        writeLeerling.close();

    }

    public void setAanwezigheid(String extraI, String aanw, OnlineLes les){
        Aanwezigheid a = new Aanwezigheid(this, extraI, aanw, les);
        aanwezigheidlist.add(a);
    }

    public String getLeerlingnummer() {
        return super.persoonCode;
    }

    public Klas getKlas() {
        return klas;
    }

    public String getLeerlingNaam() {return naam;}

    public List<Aanwezigheid> getAanwezigheidlist() {

        return Collections.unmodifiableList(aanwezigheidlist);
    }
    public void setLeerlingnummer(String leerlingnummer) {
        super.persoonCode = leerlingnummer;
    }

    @Override
    public String toString() {
        return "Leerling: " + super.persoonCode;
    }
}
