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

    public List<OnlineLes> getLessen() {
        return Collections.unmodifiableList(lessen);
    }

    public void lessenAppenden(OnlineLes les){
        lessen.add(les);
    }

    public List<Leerling> getLeerlingen() {
        return Collections.unmodifiableList(leerlingen);
    }

    public void leerlingAppenden(Leerling leerling){
        leerlingen.add(leerling);
    }
}
