import java.awt.* ;
import javax.swing.JFrame ;

public class ParkingViz extends JFrame {
    private Parking parking;

    int ZOOM_FACTOR = 15;
    public ParkingViz() {
        super("Parking vizualization");
        this.parking = new Parking(100, 100);
        setSize(100*ZOOM_FACTOR, 100*ZOOM_FACTOR);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public ParkingViz(Parking parking) {
        super("Parking vizualization");
        this.parking = parking;
        setSize(parking.getLongueur()*ZOOM_FACTOR, parking.getLargeur()*ZOOM_FACTOR);
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
            g.drawLine(x*ZOOM_FACTOR, 0, x*ZOOM_FACTOR, getSize().height);
        }
        for (int y = 0; y < this.parking.getLargeur(); y++) {
            g.drawLine(0, y*ZOOM_FACTOR, getSize().width, y*ZOOM_FACTOR);
        }

        // vehicules
        int nbVehicules = this.parking.getNbVehicules();
        System.out.println("Parking in viz : \n" + this.parking.toString());
        for (int i = 0; i < nbVehicules; i++){
            Vehicule vehiculeCourant = parking.getVehicule(i);
            g.setColor( vehiculeCourant.getCouleur());
            g.fillRect( parking.getPosX(i)*ZOOM_FACTOR, 
                        parking.getPosY(i)*ZOOM_FACTOR,
                        vehiculeCourant.getTailleX()*ZOOM_FACTOR,
                        vehiculeCourant.getTailleY()*ZOOM_FACTOR
            );
        }
    }
}