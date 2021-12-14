import java.awt.*;

public class MyMain {

    public static void main(String[] args){
        Parking park = new Parking(200, 100);
        Vehicule voit1 = new Voiture(5, 2, "Tesla", Color.BLACK);
        Vehicule velo1 = new Velo(5, 2, Color.BLACK);
        System.out.println(park.toString());
        System.out.println(voit1.toString());
        System.out.println(velo1.toString());

    }

}