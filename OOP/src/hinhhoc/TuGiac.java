package hinhhoc;

public class TuGiac extends HinhHoc {
    private double canh1;
    private double canh2;
    private double canh3;
    private double canh4;

    public TuGiac(String color, double canh1, double canh2, double canh3, double canh4) {
        super(color);
        this.canh1 = canh1;
        this.canh2 = canh2;
        this.canh3 = canh3;
        this.canh4 = canh4;
    }

    public TuGiac(String color) {
        super(color);
    }

    public double getCanh1() {
        return canh1;
    }

    public void setCanh1(double canh1) {
        this.canh1 = canh1;
    }

    public double getCanh2() {
        return canh2;
    }

    public void setCanh2(double canh2) {
        this.canh2 = canh2;
    }

    public double getCanh3() {
        return canh3;
    }

    public void setCanh3(double canh3) {
        this.canh3 = canh3;
    }

    public double getCanh4() {
        return canh4;
    }

    public void setCanh4(double canh4) {
        this.canh4 = canh4;
    }


}
