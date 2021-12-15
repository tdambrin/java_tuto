import java.awt.* ;
import javax.swing.JFrame ;
import java.awt.event.*;

public class ParkingViz extends JFrame implements MouseListener {
    private Parking parking;
    private int selectedVehiculeIndex;

    int ZOOM_FACTOR = 15;
    public ParkingViz() {
        super("Parking vizualization");
        this.parking = new Parking(100, 100);
        this.selectedVehiculeIndex = -1;
        setSize(100*ZOOM_FACTOR, 100*ZOOM_FACTOR);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        addMouseListener(this);
    }

    public ParkingViz(Parking parking) {
        super("Parking vizualization");
        this.parking = parking;
        this.selectedVehiculeIndex = -1;
        setSize(parking.getLongueur()*ZOOM_FACTOR, parking.getLargeur()*ZOOM_FACTOR);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        addMouseListener(this);
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

    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseClicked(MouseEvent e){
        int selectedIndex = this.parking.getVehiculeIndexByPosition((int) e.getX()/ZOOM_FACTOR, (int) e.getY()/ZOOM_FACTOR);
        if (selectedIndex == this.selectedVehiculeIndex){
            this.selectedVehiculeIndex = -1;
        } else if (this.selectedVehiculeIndex >= 0 && selectedIndex < 0) {
            int newIndex = this.parking.moveVehicule(this.selectedVehiculeIndex, (int) e.getX()/ZOOM_FACTOR, (int) e.getY()/ZOOM_FACTOR);
            if (newIndex >= 0){
                this.selectedVehiculeIndex = -1;
                repaint();
            }
        } else if (selectedIndex >= 0) {
            this.selectedVehiculeIndex = selectedIndex;
        } 
    }
}