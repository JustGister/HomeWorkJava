public class Main {
    public static void main(String[] args) {
        MyHashSet<String> myHashSet = new MyHashSet<>(30);

        myHashSet.add("Hello");
        myHashSet.add(",");
        myHashSet.add("new");
        myHashSet.add("World");

        System.out.println(myHashSet.contains("Hello"));
        System.out.println(myHashSet.contains(","));

        myHashSet.remove("Hello");
        myHashSet.remove(",");

        System.out.println(myHashSet.contains("Hello"));
        System.out.println(myHashSet.contains(","));
    }
}