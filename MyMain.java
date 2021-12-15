import java.awt.*;

public class MyMain {

    public static void main(String[] args){
        Parking park = new Parking(200, 100);
        Vehicule voit1 = new Voiture(5, 2, "Tesla", Color.BLACK);
        Vehicule velo1 = new Velo(2, 1, Color.BLUE);
        System.out.println(park.toString());
        System.out.println(voit1.toString());
        System.out.println(velo1.toString());

        int addedVoitureIndex = park.addVehicule(voit1, 10, 10);
        System.out.println("voiture1 in parking at index " + addedVoitureIndex);
        int addedVeloIndex = park.addVehicule(velo1, 10, 10);
        System.out.println("velo1 in parking at index " + addedVeloIndex);

        addedVeloIndex = park.addVehicule(velo1, 30, 30);
        System.out.println("velo1 in parking at index " + addedVeloIndex);

        int movedVoitureIndex = park.moveVehicule(addedVoitureIndex, 100, 30);
        System.out.println("voiture1 moved in parking , is now at index " + movedVoitureIndex);

        System.out.println(park.toString());

    }

}