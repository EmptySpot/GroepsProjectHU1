package code.tester;

public class SelectedStatics {
    private static OnlineLes les;

    public static void setLes(OnlineLes les){
        SelectedStatics.les = les;
    }

    public static OnlineLes getLes(){
        return les;
    }
}
