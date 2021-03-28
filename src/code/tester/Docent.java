package code.tester;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Docent {
    private String docentNaam;
    private String docentCode;
    private ArrayList<OnlineLes>lessen= new ArrayList<>();

    public Docent(String docentNaam, String docentCode){
        this.docentNaam=docentNaam;
        this.docentCode=docentCode;
    }

    public void lessenAppenden(OnlineLes les){
        lessen.add(les);
    }

    public String getDocentNaam() {
        return docentNaam;
    }

    public String getDocentCode() {
        return docentCode;
    }

    public List<OnlineLes> getLessen() {
        return Collections.unmodifiableList(lessen);
    }

    @Override
    public String toString() {
        return docentNaam;
    }
}
