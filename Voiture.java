import java.awt.*;

public class Voiture extends Vehicule {

    private String marque;

    public Voiture(int tailleX, int tailleY, String marque, Color couleur) {
        super(tailleX, tailleY, couleur);
        this.marque = marque;
    }

    public Voiture(){
        super(10, 5, Color.WHITE);
        this.marque = "Audi";
    }
    
    public String toString() {
        return (super.toString() + " - type : Voiture - marque : " + this.marque + " - couleur : " + this.couleur.toString());
    }
}