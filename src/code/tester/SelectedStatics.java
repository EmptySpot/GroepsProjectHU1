package code.tester;

public class SelectedStatics {
    private static OnlineLes les;
    private static Leerling leerling;

    public static void setLes(OnlineLes les){
        SelectedStatics.les = les;
    }

    public static OnlineLes getLes(){
        return les;
    }

    public static void setLeerling(Leerling leerling){
        SelectedStatics.leerling = leerling;
    }

    public static Leerling getLeerling(){
        return leerling;
    }
}
