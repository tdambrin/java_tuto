import java.awt.*;

public class Vehicule {

    private int tailleX;
    private int tailleY;
    private Color couleur;

    public Vehicule(int tailleX, int tailleY, Color couleur) {
        this.tailleX = tailleX;
        this.tailleY = tailleY;
        this.couleur = couleur;
    }

    public String toString() {
        return ("Vehicule de dimensions (" + this.tailleX + "," + this.tailleY + ")");
    }

}