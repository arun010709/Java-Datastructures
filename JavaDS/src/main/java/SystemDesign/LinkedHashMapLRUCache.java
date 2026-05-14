package SystemDesign;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapLRUCache<K,V> extends LinkedHashMap<K,V> {

    private final int capacity;

    public LinkedHashMapLRUCache(int capacity) {
        // 'true' indicates access-order (LRU), 'false' indicates insertion-order
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity; // Automatically evicts the tail
    }
}
