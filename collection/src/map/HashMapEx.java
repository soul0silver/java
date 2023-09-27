package map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class HashMapEx {
    public static void init()
    {
        Map<Integer,String> students=new HashMap<>();
        HashMap<Integer,String> persons=new HashMap<>();

        // insert element
        students.put(1,"Hai");
        students.put(2,"Hai");
        System.out.println(students);
        students.put(3,"phong");
        students.remove(1);
        //show keySet()
        for (Map.Entry<Integer,String> entry:students.entrySet()){
            Integer k=entry.getKey();
            String v=entry.getValue();
            System.out.println(k+": "+v);
        }
    }

    public static void main(String[] args) {
        init();
    }
}
