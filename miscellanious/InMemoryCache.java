package miscellanious;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by sarkarri on 5/5/17.
 */
public class InMemoryCache<K, T> {
    protected class InMemoryCacheObject<T> {
        private long lastAccessed = System.currentTimeMillis();
        T value;

        InMemoryCacheObject(T value) {
            this.value = value;
        }
    }

    private int timeToLive;
    private Map<K, InMemoryCacheObject> cacheMemory;

    public InMemoryCache(int timeToLive, int timeInterval) {
        this.timeToLive = timeToLive;
        cacheMemory = new ConcurrentHashMap<K, InMemoryCacheObject>();

        Thread t = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(timeInterval * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //cleanup
            }
        });
        t.setDaemon(true);
        t.start();
    }

    public void put(K key, T value) {
        InMemoryCacheObject cacheObj = new InMemoryCacheObject(value);
        cacheMemory.put(key, cacheObj);
    }

    public T get(K key) {
        InMemoryCacheObject cacheObject = cacheMemory.get(key);
        if (cacheObject == null) {
            return null;
        } else {
            cacheObject.lastAccessed = System.currentTimeMillis();
            return (T) cacheObject.value;
        }
    }

    public void remove(K key) {
        cacheMemory.remove(key);
    }

    public void cleanup() {
        Set<Map.Entry<K, InMemoryCacheObject>> cacheList = cacheMemory.entrySet();
        Iterator<Map.Entry<K, InMemoryCacheObject>> it = cacheList.iterator();
        long now = System.currentTimeMillis();
        while (it.hasNext()) {
            Map.Entry<K, InMemoryCacheObject> entry = it.next();
            K key = entry.getKey();
            InMemoryCacheObject o = entry.getValue();
            if (now > (timeToLive + o.lastAccessed)) {
                cacheMemory.remove(key);
            }
        }
    }
}
