import java.awt.*;

public class Voiture {

    private int tailleX;
    private int tailleY;
    private String marque;
    private Color couleur;

    public Voiture(int tailleX, int tailleY, String marque, Color couleur) {
        this.tailleX = tailleX;
        this.tailleY = tailleY;
        this.marque = marque;
        this.couleur = couleur;
    }

    public Voiture(){
        this.tailleX = 10;
        this.tailleY = 5;
        this.marque = "Audi";
        this.couleur = Color.WHITE;
    }
    
    public String toString() {
        return ("Vehicule - dimensions (" + this.tailleX + "," + this.tailleY + ")" + " - type : Voiture - marque : " + this.marque + " - couleur : " + this.couleur.toString());
    }
}