import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetEX {
    public  static void init(){
        SortedSet<String> set=new TreeSet<>();
        set.add("Tu Liem");
        set.add("bac");
        set.add("dong");

        set.add("dong");set.add("dong");
        set.add("dong");
        System.out.println(set);

    }
}
