import java.util.*;

public class TreeSet <E extends Comparable<E>>{
    private TreeMap<E, Object> map;

    public TreeSet() {
        map = new TreeMap<>();
    }

    public void add(E element) {
        map.put(element, null);
    }

    public void remove(E element) {
        map.remove(element);
    }

    public boolean contains(E element) {
        return map.containsKey(element);
    }
}
