package lab02.lab02_2;

public class Client {
    public static void main(String[] args) {
        FlashLamp flashLamp=new FlashLamp();
        Battery battery=new Battery(100);
        flashLamp.setBattery(battery);
        flashLamp.turnOn();
        flashLamp.light();
        flashLamp.turnOff();
        System.out.println(flashLamp.getBatteryInfo());
    }
}
