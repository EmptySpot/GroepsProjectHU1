package code.tester;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Klas {
    private String naam;
    private ArrayList<Leerling> leerlingen = new ArrayList<>();
    private ArrayList<OnlineLes> lessen = new ArrayList<>();

    public Klas(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public List<OnlineLes> getLessen() {
        return Collections.unmodifiableList(lessen);
    }

    public void lessenAppenden(OnlineLes les){
        for(Leerling leerling : leerlingen){
            leerling.setAanwezigheid(les);
        }
        lessen.add(les);
    }

    public List<Leerling> getLeerlingen() {
        return Collections.unmodifiableList(leerlingen);
    }

    public void leerlingAppenden(Leerling leerling){
        leerlingen.add(leerling);
    }

    @Override
    public String toString() {
        return naam;
    }

    public Leerling getLeerling(String string) {
        return SelectedStatics.getLeerling(string, leerlingen);
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

    public boolean controleLes(OnlineLes les, Date date, Time time) {
        return (les.getTime() == time && les.getDatum() == date);
    }


}

