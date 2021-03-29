package code.tester;

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
}
