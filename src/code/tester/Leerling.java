package code.tester;

public class Leerling {
    private int leerlingnummer;
    private String klas;
    private boolean aanwezig = true;
    public Leerling(int lN, String kl){
        this.leerlingnummer = lN;
        this.klas = kl;
    }

    public void setLeerlingnummer(int leerlingnummer) {
        this.leerlingnummer = leerlingnummer;
    }
}