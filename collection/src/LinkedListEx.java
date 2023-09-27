import java.util.LinkedList;
import java.util.List;

public class LinkedListEx {
    public static void initLinkedList(){
        //co 2 cach khoi tao
        LinkedList<String> a=new LinkedList<>();
        List<String> b=new LinkedList<>();
        a.add("ford");
        a.add("Honda");
        a.add("BMW");
        a.size();
        a.get(0);
        a.remove(0);
        a.getFirst();
        a.pollFirst();
        a.clear();
        int[] c=new int[9];
    }

    public static void main(String[] args) {
        initLinkedList();
    }
}
