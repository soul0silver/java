import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetEx {
    public static void initHashSet(){
        HashSet<String> set=new HashSet<>();
        System.out.println(set.isEmpty());
        set.add("dat");
        set.add("HN");
        set.add("hcm");
        System.out.println(set);
        set.add("HN");
        set.add("HN");
        System.out.println(set);
        //loop
        //Integer
        Iterator<String> iterable=  set.iterator();
        while (iterable.hasNext()){

        }
        //foreach
    }

    public static void main(String[] args) {
        initHashSet();
    }
}
