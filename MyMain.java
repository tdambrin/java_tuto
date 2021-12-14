import java.awt.*;

public class MyMain {

    public static void main(String[] args){
        Parking park = new Parking(200, 100);
        Voiture voit1 = new Voiture(5, 2, "Tesla", Color.BLACK);
        Velo velo1 = new Velo(5, 2, Color.BLUE);
        System.out.println(park.toString());
        System.out.println(voit1.toString());
        System.out.println(velo1.toString());
    }

}