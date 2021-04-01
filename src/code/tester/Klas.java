package code.tester;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Klas {
    private String naam;
    private ArrayList<Leerling> leerlingen = new ArrayList<>();
    private ArrayList<OnlineLes> lessen = new ArrayList<>();

    public Klas(String naam) {
        this.naam = naam;
        School.klassenAppenden(this);
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

    public OnlineLes getLes(String string) {
        for(OnlineLes les : lessen){
            if(les.getLesCode().equals(string)){
                return les;
            }
        }
        return null;
    }
}
