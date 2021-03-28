package code.tester;

import java.time.LocalDate;
import java.time.LocalTime;

public class OnlineLes {
    private LocalDate datum;
    private String lesCode;
    private boolean verplicht;
    private String lesNaam;
    private String vakNaam;
    private Klas klas;
    private Docent docent;
    private LocalTime time;

    public OnlineLes (LocalDate date, String lesC, boolean verpl, String lesN, String vakN, Klas klas, Docent docent, LocalTime time){
        this.datum = date;
        this.lesCode = lesC;
        this.verplicht = verpl;
        this.lesNaam = lesN;
        this.vakNaam = vakN;
        this.klas = klas;
        this.docent = docent;
        docent.lessenAppenden(this);
        klas.lessenAppenden(this);
        this.time = time;
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

    public boolean getVerplicht() {
        return verplicht;
    }

    public Klas getKlas() {
        return klas;
    }

    public Docent getDocent() {
        return docent;
    }

    public LocalTime getTime() {
        return time;
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
