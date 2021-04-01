package code.tester;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class OnlineLes {
    private Date datum;
    private String lesCode;
    private boolean verplicht;
    private String lesNaam;
    private String vakNaam;
    private Klas klas;
    private Docent docent;
    private Time time;
    private String status;

    public OnlineLes (Date date, String lesC, boolean verpl, String lesN, String vakN, Klas klas, Docent docent, Time time){
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

    public boolean getVerplicht() {
        return verplicht;
    }

    public Klas getKlas() {
        return klas;
    }

    public Docent getDocent() {
        return docent;
    }

    public Time getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("%tR %s %s", time, lesNaam, docent);
    }
}
