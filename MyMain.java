public class MyMain {

    public static void main(String[] args){
        Parking park = new Parking(200, 100);
        Vehicule v1 = new Voiture(5, 2, "Tesla");
        System.out.println(park.toString());
    }

}