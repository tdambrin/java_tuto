import java.awt.*;

public class Velo {

    private int tailleX;
    private int tailleY;
    private Color couleur;

    public Velo(int tailleX, int tailleY, Color couleur) {
        this.tailleX = tailleX;
        this.tailleY = tailleY;
        this.couleur = couleur;    }

    public Velo(){
        this.tailleX = 2;
        this.tailleY = 1;
        this.couleur = Color.BLUE;    }
    
    public String toString() {
        return ("Vehicule - dimensions (" + this.tailleX + "," + this.tailleY + ")" + " - type : Velo - couleur : " + this.couleur.toString());
    }
}