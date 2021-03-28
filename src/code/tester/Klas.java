package code.tester;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Klas {
    private String naam;
    private ArrayList<Leerling> leerlingen = new ArrayList<>();
//    private Docent d;


    public Klas(String naam) {
        this.naam = naam;
        School.klassenAppenden(this);
    }

    public List<Leerling> getLeerlingen() {
        return Collections.unmodifiableList(leerlingen);
    }

    public void leerlingAppenden(Leerling leerling){
        leerlingen.add(leerling);
    }
}
