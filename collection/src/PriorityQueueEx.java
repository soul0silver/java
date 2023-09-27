import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueEx {
    public static void init(){
        PriorityQueue<Integer> priorityQueue= new PriorityQueue<>();
        priorityQueue.add(100);
        priorityQueue.add(200);
        priorityQueue.add(80);
        System.out.println(priorityQueue);
        //top element
        System.out.println(priorityQueue.peek());
        //get top element and remove
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue);
        //loop
        Iterator<Integer> integer=priorityQueue.iterator();
        while (integer.hasNext()){
            System.out.println(integer.next()+" ");
        }
    }

    public static void main(String[] args) {
        init();
    }
}
