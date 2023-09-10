package hinhhoc;

public class HinhTron extends HinhHoc{
    private double radius;

    public HinhTron(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    public HinhTron(String color) {
        super(color);
    }

    @Override
    public double getPerimeter() {
        return 2*Math.PI*radius;
    }

    @Override
    public double getArea() {
        return Math.PI*radius*radius;
    }

    @Override
    public String toString() {
        return "HinhTron{" +
                "radius=" + radius +
                '}';
    }
}
