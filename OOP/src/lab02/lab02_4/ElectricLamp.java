package lab02.lab02_4;

public class ElectricLamp {
    private boolean status;

    public ElectricLamp() {
        status=false;
    }
    public void turnOn(){
        if (status==false) {
            status=true;
            System.out.println("Lamp is lighting");}
        else System.out.println("Lamp is already be turn on");
    }
    public void turnOff(){
        if (status==true) {
            status = false;
            System.out.println("Lamp is off");
        } else System.out.println("Lamp is already off");
    }
}
