package code.tester;

import java.util.ArrayList;

public class Docent {
    private String docentNaam;
    private String docentCode;
    private ArrayList<OnlineLes>lessen= new ArrayList<>();

    public Docent(String docentNaam, String docentCode){
        this.docentNaam=docentNaam;
        this.docentCode=docentCode;
    }

    public void setLessen(OnlineLes les){
        lessen.add(les);
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
