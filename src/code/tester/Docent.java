package code.tester;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Docent extends Persoon{
    private String docentNaam;
    private ArrayList<OnlineLes>lessen= new ArrayList<>();

    public Docent(String docentNaam, String docentCode){
        super(docentCode);
        this.docentNaam=docentNaam;
        School.docentenAppenden(this);
    }

    public void lessenAppenden(OnlineLes les){
        lessen.add(les);
    }

    public String getDocentNaam() {
        return docentNaam;
    }

    public String getDocentCode() {
        return super.persoonCode;
    }

    public List<OnlineLes> getLessen() {
        return Collections.unmodifiableList(lessen);
    }

    public void setAanwezigheid(String extraInformatie, String aanwezigheid, OnlineLes les){
        les.setStatus(aanwezigheid);
        System.out.println(extraInformatie);
    }

    @Override
    public String toString() {
        return docentNaam;
    }
}
