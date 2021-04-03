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
        System.out.println(klassen);
        klassen.clear();
        System.out.println(klassen);
        DatabaseInfo.getKlassen();
        System.out.println(klassen);
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
        System.out.println("HIEEEER");
        for(Klas klas : klassen){
            System.out.println("HIEEEEEEEEEEEEEEEEEEEEER");
            if(klas.getNaam().equals(string)){
                System.out.println(klas);
                return klas;
            }
        }
        return null;
    }
}
