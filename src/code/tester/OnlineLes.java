package code.tester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class OnlineLes {
    private LocalDate datum;
    private String lesCode;
    private boolean verplicht;
    private String lesNaam;
    private String vakNaam;
    private Klas klas;


    public OnlineLes (LocalDate date, String lesC, boolean verpl, String lesN, String vakN, Klas k){
        this.datum = date;
        this.lesCode = lesC;
        this.verplicht = verpl;
        this.lesNaam = lesN;
        this.vakNaam = vakN;
        this.klas = k;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public String getLesCode() {
        return lesCode;
    }

    public String getLesNaam() {
        return lesNaam;
    }

    public String getVakNaam() {
        return vakNaam;
    }

    @Override
    public String toString() {
        return "OnlineLes{" +
                "datum=" + datum +
                ", lesGetal=" + lesCode +
                ", verplicht=" + verplicht +
                ", lesNaam='" + lesNaam + '\'' +
                ", vakNaam='" + vakNaam + '\'' +
                '}';
    }
}
