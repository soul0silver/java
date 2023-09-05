package lab02.lab02_2;

public class Battery {
    private int energy;

    public Battery() {
    }

    public Battery(int energy) {
        this.energy = energy;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
    public void decreaseEnergy() {
        energy--;
    }

}
