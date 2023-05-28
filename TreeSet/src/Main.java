public class Main {
    public static void main(String[] args) {
        TreeSet<Integer, String> treeSet = new TreeSet<>();

        treeSet.add(1, "Петя");
        treeSet.add(20, "Вася");
        treeSet.add(4, "Катя");
        treeSet.add(5, "Миша");
        treeSet.add(10, "Коля");

        System.out.println(treeSet.contains(10));

        treeSet.remove(10);

        System.out.println(treeSet.contains(10));
    }
}
