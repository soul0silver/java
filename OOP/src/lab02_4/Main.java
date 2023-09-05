package lab02_4;

public class Main {
    public static void main(String[] args) {
        ElectricLamp electricLamp=new ElectricLamp();
        SwitchButton switchButton=new SwitchButton();
        switchButton.connectToLamp(electricLamp);
        switchButton.switchOn();
        switchButton.switchOff();
    }
}
