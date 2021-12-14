public class Voiture {

    private int tailleX;
    private int tailleY;
    private String marque;

    public Voiture(int tailleX, int tailleY, String marque) {
        // code here
    }

    public Voiture(){
        //code here
    }
    
    public String toString() {
        return ("Vehicule - dimensions (" + this.tailleX + "," + this.tailleY + ")" + " - type : Voiture - marque : " + this.marque + " - couleur : " + this.couleur.toString());
    }
}