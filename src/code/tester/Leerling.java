package code.tester;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leerling {
    private String leerlingnummer;
    private Klas klas;
    private ArrayList<Aanwezigheid> aanwezigheidlist = new ArrayList<>();

    public Leerling(String lN, Klas kl, String wachtWoord) throws IOException {
        this.leerlingnummer = lN;
        this.klas = kl;
        kl.leerlingAppenden(this);
//        BufferedWriter writeLeerling = new BufferedWriter(new FileWriter("src/textfiles/leerlingen.txt", true));
//        writeLeerling.write(leerlingnummer + ":" + wachtWoord);
//        writeLeerling.newLine();
//        writeLeerling.close();

    }

    public void setAanwezigheid(String extraI, String aanw, OnlineLes les){
        Aanwezigheid a = new Aanwezigheid(this, extraI, aanw, les);
        aanwezigheidlist.add(a);
        System.out.println(a);
    }

    public String getLeerlingnummer() {
        return leerlingnummer;
    }

    public Klas getKlas() {
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
