public class Parking {

    int MAX_VEHICULES = 50;

    private int longueur;
    private int largeur;
    private int nbVehicules;
    private Vehicule[] vehicules;
    private int[] positionsX;
    private int[] positionsY;

    public Parking(int longueur, int largeur){
        this.longueur = longueur;
        this.largeur = largeur;
        this.nbVehicules = 0;
        this.vehicules = new Vehicule[MAX_VEHICULES];
        this.positionsX = new int[MAX_VEHICULES];
        this.positionsY = new int[MAX_VEHICULES];
    }

    @Override
    public String toString() {
        String res =  "Parking - longueur : " + this.longueur + " - largeur : " + this.largeur + " - nb vehicules : " + this.nbVehicules;
        if (this.nbVehicules > 0) {
            res += "\n vehicules : [\n";
            for (int i = 0; i < this.nbVehicules; i ++) {
                res += " - " + this.vehicules[i].toString() + " at position (" + this.positionsX[i] + "," + this.positionsY[i] + ")\n";
            }
            res += "]";
        }
        return res;
    }

    public int addVehicule(Vehicule v, int x, int y){

        if (x + v.getTailleX() >= this.longueur || y + v.getTailleY() >= this.largeur) {
            return -1;
        }

        // check if no vehicule already there
        for (int i = 0; i < this.nbVehicules; i++){
            if (vehiculesSuperpose(v, x, y, i)) {
                return -1;
            }
        }
        this.vehicules[nbVehicules] = v;
        this.positionsX[nbVehicules] = x;
        this.positionsY[nbVehicules] = y;
        this.nbVehicules += 1;

        return this.nbVehicules - 1;
    }

    public int moveVehicule(int indexParked, int newX, int newY) {
        int addedVehiculeIndex = addVehicule(this.vehicules[indexParked], newX, newY);
        if (addedVehiculeIndex > 0) {
            deleteVehicule(indexParked);
        }
        return addedVehiculeIndex - 1;
    }

    public void deleteVehicule(int indexParked) {
        if (this.nbVehicules > indexParked) {
            for (int i = indexParked; i < this.nbVehicules - 1; i ++) {
                this.vehicules[i] = this.vehicules[i+1];
                this.positionsX[i] = this.positionsX[i+1];
                this.positionsY[i] = this.positionsY[i+1];
            }
            this.nbVehicules -= 1;
        } 
    }

    private boolean vehiculesSuperpose(Vehicule v, int x, int y, int indexParked) {
        boolean res = false;
        if (positionsX[indexParked] <= x && x <= positionsX[indexParked] + this.vehicules[indexParked].getTailleX()) {
            if (positionsY[indexParked] <= y && y <= positionsY[indexParked] + this.vehicules[indexParked].getTailleY()) {
                res = true;
            } else if (positionsY[indexParked] <= y + v.getTailleY() && y + v.getTailleY() <= positionsY[indexParked] + this.vehicules[indexParked].getTailleY()) {
                res = true;
            }
        } else if (positionsX[indexParked] <= x + v.getTailleX() && x + v.getTailleX() <= positionsX[indexParked] + this.vehicules[indexParked].getTailleX()) {
            if (positionsY[indexParked] <= y && y <= positionsY[indexParked] + this.vehicules[indexParked].getTailleY()) {
                res = true;
            } else if (positionsY[indexParked] <= y + v.getTailleY() && y + v.getTailleY() <= positionsY[indexParked] + this.vehicules[indexParked].getTailleY()) {
                res = true;
            }
        }
        return res;
    }

    public int getNbVehicules() {
        return this.nbVehicules;
    }

    public Vehicule getVehicule(int index) {
        return this.vehicules[index];
    }

    public int getPosX(int index) {
        return this.positionsX[index];
    }

    public int getPosY(int index) {
        return this.positionsY[index];
    }

    public int getLongueur() {
        return this.longueur;
    }

    public int getLargeur() {
        return this.largeur;
    }

    public int getVehiculeIndexByPosition(int x, int y) {
        for (int i = 0; i < this.nbVehicules; i++) {
            Vehicule tempVehicule = new Vehicule(1,1,null);
            if (vehiculesSuperpose(tempVehicule, x, y, i)) {
                return i;
            }
        }
        return -1;
    }
}