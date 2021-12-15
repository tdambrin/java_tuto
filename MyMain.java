import java.awt.*;

public class MyMain {

    public static void main(String[] args){
        
        Parking park = new Parking(100, 100);

        /*
                CREATION DES VEHICULES
        */

        Vehicule voit1 = new Voiture(15, 4, "Tesla", Color.BLACK);
        Vehicule velo1 = new Velo(7, 1, Color.BLUE);
        System.out.println(park.toString());
        System.out.println(voit1.toString());
        System.out.println(velo1.toString());

        /*
                AJOUT DES VEHICULES AU PARKING
        */
        int addedVoitureIndex = park.addVehicule(voit1, 20, 30);
        System.out.println("voiture1 in parking at index " + addedVoitureIndex);

        int addedVeloIndex = park.addVehicule(velo1, 20, 30);
        System.out.println("velo1 in parking at index " + addedVeloIndex);

        addedVeloIndex = park.addVehicule(velo1, 70, 80);
        System.out.println("velo1 in parking at index " + addedVeloIndex);

        int movedVoitureIndex = park.moveVehicule(addedVoitureIndex, 20, 40);
        System.out.println("voiture1 moved in parking , is now at index " + movedVoitureIndex);

        //System.out.println(park.toString());

        /*
                INTERFACE GRAPHIQUE
        */
        ParkingViz viz = new ParkingViz(park); 
    }

}