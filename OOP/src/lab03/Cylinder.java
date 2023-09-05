package lab03;

public class Cylinder extends Circle{
    private double height;

    public Cylinder(double height) {
        super();
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getVolume(){
        return height*Math.PI*super.getRadius()*super.getRadius();
    }

    @Override
    public double getArea() {
        return 2*Math.PI*getRadius()*(height+getRadius());
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height +
                '}';
    }
}
