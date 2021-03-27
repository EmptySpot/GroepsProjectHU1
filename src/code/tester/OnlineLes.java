package code.tester;

import java.time.LocalDate;

public class OnlineLes {
    private LocalDate datum;
    private String lesCode;
    private boolean verplicht;
    private String lesNaam;
    private String vakNaam;
    private Leerling l;
    private boolean aanwezig = true;

    public OnlineLes (LocalDate date, String lesC, boolean verpl, String lesN, String vakN){
        this.datum = date;
        this.lesCode = lesC;
        this.verplicht = verpl;
        this.lesNaam = lesN;
        this.vakNaam = vakN;
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
