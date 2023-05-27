import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();

        treeSet.add("Hello");
        treeSet.add(",");
        treeSet.add("new");
        treeSet.add("World");


        System.out.println(treeSet.contains("Hello"));
        System.out.println(treeSet.contains("World"));

        treeSet.remove("World");

        System.out.println(treeSet.contains("World"));
    }
}