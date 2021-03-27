package code.tester;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class School {
    private static ArrayList<Klas> klassen = new ArrayList<>();
    private static School HU;

    public static School getSchool() {
        return HU;
    }

    public static void klassenAppenden(Klas klas){
        klassen.add(klas);
    }

    public static List<Klas> getKlassen() {
        return Collections.unmodifiableList(klassen);
    }

}
