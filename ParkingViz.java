import java.awt.* ;
import javax.swing.JFrame ;

public class ParkingViz extends JFrame {
    private Parking parking;

    public ParkingViz() {
        super("Parking vizualization");
        this.parking = new Parking(100, 100);
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public ParkingViz(Parking parking) {
        super("Parking vizualization");
        this.parking = parking;
        setSize(parking.getLongueur()*10, parking.getLargeur()*10);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void paint(Graphics g) {
        // background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getSize().width, getSize().height);

        // quadrillage
        g.setColor(Color.GRAY);
        for (int x = 0; x < this.parking.getLongueur(); x++) {
            g.drawLine(x*10, 0, x*10, getSize().height);
        }
        for (int y = 0; y < this.parking.getLargeur(); y++) {
            g.drawLine(0, y*10, getSize().width, y*10);
        }

        // vehicules
        int nbVehicules = this.parking.getNbVehicules();
        System.out.println("Parking in viz : \n" + this.parking.toString());
        for (int i = 0; i < nbVehicules; i++){
            Vehicule vehiculeCourant = parking.getVehicule(i);
            g.setColor( vehiculeCourant.getCouleur());
            g.fillRect( parking.getPosX(i)*10, 
                        parking.getPosY(i)*10,
                        vehiculeCourant.getTailleX()*10,
                        vehiculeCourant.getTailleY()*10
            );
        }
    }
}