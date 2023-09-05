package lab02.lab02_4;

public class SwitchButton {
    private boolean status;
    private ElectricLamp lamp;

    public SwitchButton() {
        status=false;
    }
    public void connectToLamp(ElectricLamp electricLamp){
        if (status==false&&lamp==null) {
            status=true;
            lamp=electricLamp;
        }
    }
    public void switchOn(){
        lamp.turnOn();

    }
    public void switchOff(){
        lamp.turnOff();

    }
}
