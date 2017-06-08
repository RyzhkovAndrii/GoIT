package offline7.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class CacheLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

    private int maxSize;

    public CacheLinkedHashMap(int maxSize, boolean accessOrder) {
        super(16, 0.75f, accessOrder);
        this.maxSize = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size() > maxSize;
    }
}
