// Abstract class
abstract class Animal2 {
    // Abstract method (does not have a body)
    public abstract void animalSound();
    // Regular method
    public void sleep() {
        System.out.println("Zzz");
    }
}

// Subclass (inherit from Animal)
class Pig2 extends Animal2 {
    public void animalSound() {
        // The body of animalSound() is provided here
        System.out.println("The pig says: wee wee");
    }
}

public class Abstract {
    public static void main(String[] args) {
        Pig2 myPig = new Pig2(); // Create a Pig object
        myPig.animalSound();
        myPig.sleep();
    }
}
