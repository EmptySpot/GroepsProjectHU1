package code.tester;

import java.sql.Date;
import java.sql.Time;
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
    public void clearLessen(){
        lessen.clear();
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

    public OnlineLes getLes(String string) {
        return SelectedStatics.getLes(string, lessen);
    }

    public void updateLes(OnlineLes les, Date date, Time time) {
        int arrayListIndex = lessen.indexOf(les);
        les.setDatum(date);
        les.setTime(time);

        lessen.set(arrayListIndex, les);

    }

    @Override
    public String toString() {
        return docentNaam;
    }
}
