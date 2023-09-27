import java.util.LinkedHashSet;

public class LinkHashSetEx {
    public static void initLinkHashSet(){
        LinkedHashSet<String> links=new LinkedHashSet<>();
        links.add("dog");
        links.add("lion");
        System.out.println(links);
        links.remove("dog");
        links.add("TIGER");
        System.out.println(links);
    }

    public static void main(String[] args) {
        initLinkHashSet();
    }
}
