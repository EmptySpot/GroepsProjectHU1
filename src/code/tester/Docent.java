package code.tester;

import java.util.ArrayList;

public class Docent {
    private String docentNaam;
    private String docentCode;
    private ArrayList<OnlineLes>lessen= new ArrayList<>();

    public Docent(String docentNaam, String docentCode, ArrayList<OnlineLes>lessen){
        this.docentNaam=docentNaam;
        this.docentCode=docentCode;
        this.lessen=lessen;
    }

    public String getDocentNaam() {
        return docentNaam;
    }

    public String getDocentCode() {
        return docentCode;
    }

    public ArrayList<OnlineLes> getLessen() {
        return lessen;
    }


}
