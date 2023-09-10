package hinhhoc;

public class TamGiac extends HinhHoc{
    private double canh1;
    private double canh2;
    private double canh3;

    public TamGiac(String color, double canh1, double canh2, double canh3) {
        super(color);
        this.canh1 = canh1;
        this.canh2 = canh2;
        this.canh3 = canh3;
    }

    public TamGiac(String color) {
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

    @Override
    public double getPerimeter() {
        return canh1+canh2+canh3;
    }

    @Override
    public double getArea() {
        return (double) Math.sqrt(this.getPerimeter()/2
                *((double) this.getPerimeter()/2-canh1)
                *((double) this.getPerimeter()/2-canh2)
                *((double) this.getPerimeter()/2-canh3));
    }

    @Override
    public String toString() {
        return "TamGiac{" +
                "canh1=" + canh1 +
                ", canh2=" + canh2 +
                ", canh3=" + canh3 +
                '}';
    }
}
