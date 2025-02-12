import java.util.LinkedHashMap;

class LRUCache {
    private int max; 
    private LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.max = capacity;
        map = new LinkedHashMap<>(capacity,0.75f, true); 
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        return map.get(key);
    }

    public void put(int key, int value) {
     
        map.put(key, value);

        
        if (map.size() > max) {
            // Remove the first key (least recently used)
            Integer lruKey = map.keySet().iterator().next();
            map.remove(lruKey);
        }
    }
}
