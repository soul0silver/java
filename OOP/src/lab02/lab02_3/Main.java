package lab02.lab02_3;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle=new Rectangle();
        rectangle.setHeight(4);
        rectangle.setWidth(6);
        rectangle.display();
        System.out.println(rectangle.getPerimeter());
        System.out.println(rectangle.getArea());
    }
}
