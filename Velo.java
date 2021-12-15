import java.awt.*;

public class Velo extends Vehicule {

    public Velo(int tailleX, int tailleY, Color couleur) {
        super(tailleX, tailleY, couleur);  
    }

    public Velo(){
        super(2, 1, Color.BLUE);  
    }
    
    public String toString() {
        return (super.toString() + " - type : Velo - couleur : " + this.couleur.toString());
    }
}