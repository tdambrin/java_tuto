import java.awt.*;

public class Voiture {

    private int tailleX;
    private int tailleY;
    private Color couleur;

    public Velo(int tailleX, int tailleY, Color couleur) {
        // code here
    }

    public Velo(){
        //code here
    }
    
    public String toString() {
        return ("Vehicule - dimensions (" + this.tailleX + "," + this.tailleY + ")" + " - type : Velo - couleur : " + this.couleur.toString());
    }
}