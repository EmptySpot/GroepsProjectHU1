package code.tester;


import javafx.beans.property.SimpleStringProperty;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leerling extends Persoon{
    private Klas klas;
    private SimpleStringProperty naam;
    private ArrayList<Aanwezigheid> aanwezigheidlist = new ArrayList<>();

    public Leerling(String leerlingNummer, Klas klas, String wachtWoord, String naam) throws IOException, ClassNotFoundException {
        super(leerlingNummer);
        this.klas = klas;
        this.naam = new SimpleStringProperty(naam);
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

    public String getLeerlingNaam() {return naam.get();}

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
