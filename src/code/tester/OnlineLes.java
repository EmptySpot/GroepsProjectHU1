package code.tester;

import java.util.ArrayList;
import java.util.Date;

public class OnlineLes {
    private Date datum;
    private String lesCode;
    private boolean verplicht;
    private String lesNaam;
    private String vakNaam;
    private Leerling l;
    private boolean aanwezig = true;

    public OnlineLes (Date date, String lesC, boolean verpl, String lesN, String vakN){
        this.datum = date;
        this.lesCode = lesC;
        this.verplicht = verpl;
        this.lesNaam = lesN;
        this.vakNaam = vakN;
    }

    public Date getDatum() {
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
