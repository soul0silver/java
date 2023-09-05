package lab03;

public class Main {
    public static void main(String[] args) {
        Cylinder cylinder=new Cylinder(3,"red",2);
        System.out.println(cylinder.getVolume());
        System.out.println(cylinder.getArea());
        System.out.println(cylinder.getColor());
        System.out.println(cylinder.toString());
    }
}
