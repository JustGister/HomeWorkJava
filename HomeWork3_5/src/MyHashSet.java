import java.util.ArrayList;
import java.util.List;

public class MyHashSet<T> {
    private List<T>[] buckets;
    private int size;

    @SuppressWarnings("unchecked")
    public MyHashSet(int size) {
        this.size = size;
        this.buckets = new ArrayList[size];
        for (int i = 0; i < size; i++) {
            buckets[i] = new ArrayList<>();
        }
    }

    private int getBucketIndex(T element) {
        int hashCode = element.hashCode();
        return Math.abs(hashCode % size);
    }

    public void add(T element) {
        int bucketIndex = getBucketIndex(element);
        List<T> bucket = buckets[bucketIndex];
        if (!bucket.contains(element)) {
            bucket.add(element);
        }
    }

    public void remove(T element) {
        int bucketIndex = getBucketIndex(element);
        List<T> bucket = buckets[bucketIndex];
        if (bucket.contains(element)) {
            bucket.remove(element);
        }
    }

    public boolean contains(T element) {
        int bucketIndex = getBucketIndex(element);
        List<T> bucket = buckets[bucketIndex];
        return bucket.contains(element);
    }
}
