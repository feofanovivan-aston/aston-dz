import java.util.*;

class MyHashSet<T> {
    private static final int DEFAULT_CAPACITY = 16;
    
    @SuppressWarnings("unchecked")
    private LinkedList<T>[] buckets = new LinkedList[DEFAULT_CAPACITY];
    private int size;

    public MyHashSet() {
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public void insert(T item) {
        int index = getBucketIndex(item);
        LinkedList<T> bucket = buckets[index];
        
        if (!bucket.contains(item)) {
            bucket.add(item);
            size++;
        }
    }

    public void remove(T item) {
        int index = getBucketIndex(item);
        LinkedList<T> bucket = buckets[index];
        
        if (bucket.remove(item)) {
            size--;
        }
    }

    private int getBucketIndex(T item) {
        return Math.abs(item.hashCode()) % buckets.length;
    }

    @Override
    public String toString() {
        List<T> allItems = new ArrayList<>();
        for (LinkedList<T> bucket : buckets) {
            allItems.addAll(bucket);
        }
        return allItems.toString();
    }
}