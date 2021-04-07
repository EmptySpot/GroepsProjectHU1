package code.tester;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class SelectedStatics {
    private static OnlineLes les;
    private static Persoon persoon;
    private static String status;

    public static void setLes(OnlineLes les){
        SelectedStatics.les = les;
    }

    public static OnlineLes getLes(){
        return les;
    }

    public static void setPersoon(Persoon persoon){
        SelectedStatics.persoon = persoon;
    }

    public static Persoon getPersoon(){
        return persoon;
    }

    public static void setStatus(String status){
        SelectedStatics.status = status;
    }

    public static String getStatus(){
        return status;
    }

    public static boolean controleLes(OnlineLes les, Date date, Time time) {
        return (les.getTime() == time && les.getDatum() == date);
    }

    public static OnlineLes getLes(String string, ArrayList<OnlineLes> lessen) {
        for(OnlineLes les : lessen){
            if(les.getLesCode().equals(string)){
                return les;
            }
        }
        return null;
    }

    public static Leerling getLeerling(String string, ArrayList<Leerling> leerlingen) {
        for(Leerling leerling : leerlingen){
            if(leerling.getLeerlingnummer().equals(string)){
                return leerling;
            }
        }
        return null;
    }
}
