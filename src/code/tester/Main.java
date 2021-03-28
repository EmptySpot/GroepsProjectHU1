package code.tester;

import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        LocalDate datum = LocalDate.now().plusWeeks(2);
        System.out.println("Een super mooie tester");
        System.out.println("Stephan is te laat!");
        System.out.println("Wilfred is zwanger -Jeroen");
        System.out.println("Dit moet als eerst worden uitgeprint");
        System.out.println("En dit moet als tweede worden uitgeprint");
    }
}
