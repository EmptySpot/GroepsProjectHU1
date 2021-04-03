package code.tester;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class School {
    private static ArrayList<Klas> klassen = new ArrayList<>();
    private static ArrayList<Docent> docenten = new ArrayList<>();
    private static School HU;

    public static School getSchool() {
        return HU;
    }

    public static void klassenAppenden(Klas klas){
        klassen.add(klas);
    }

    public static List<Klas> getKlassen() throws SQLException {
        klassen.clear();
        DatabaseInfo.getKlassen();
        return Collections.unmodifiableList(klassen);
    }

    public static void docentenAppenden(Docent docent){
        docenten.add(docent);
    }

    public static List<Docent> getDocenten() {
        return Collections.unmodifiableList(docenten);
    }

    public static Docent getDocent(String string) {
        for(Docent docent : docenten){
            if(docent.getDocentCode().equals(string)){
                return docent;
            }
        }
        return null;
    }

    public static Klas getKlas(String string) {
        for(Klas klas : klassen){
            if(klas.getNaam().equals(string)){
                return klas;
            }
        }
        return null;
    }
}
