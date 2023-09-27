package map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class App {
    public static void main(String[] args) {
        Student student1=new Student(1,"Hia","123@gg.com","011111111");
        Student student2=new Student(3,"p","123@gg.com","011111111");
        Student student3=new Student(2,"a","123@gg.com","011111111");

        Map<Integer,Student> map=new HashMap<>();
        map.put(student1.getId(),student1);
        map.put(student2.getId(),student2);
        map.put(student3.getId(),student3);

        for (Integer k:map.keySet()){
            Student v=map.get(k);
            System.out.println(k+"="+v);
        }

        //TreeMap
        TreeMap<String,Integer>  subjects=new TreeMap<>();
        subjects.put("java",120);
        subjects.put("c#",120);
        subjects.put("python",120);
        System.out.println(subjects);

        //LinkedHashMap
        Map<String,Double> map1= new  LinkedHashMap<>();
        map1.put("fpt",96.5);
        map1.put("vn-milk",96.5);
        map1.put("vng",96.5);
        map1.put("apple",96.5);
        System.out.println("map1: "+map1);
    }
}
