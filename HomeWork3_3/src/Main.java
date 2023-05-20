public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.add(12);
        tree.add(10);
        tree.add(8);
        tree.add(18);
        tree.add(20);
        tree.add(100);

        System.out.println(tree.thereAre(100));

        System.out.println(tree.thereAre(1000));

        System.out.println(tree.thereAre(12));

        System.out.println(tree.thereAre(1));

        System.out.println();

        System.out.println(tree.thereAre(18));

        tree.remove(18);

        System.out.println(tree.thereAre(18));
    }
}
