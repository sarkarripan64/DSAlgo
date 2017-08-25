package clone;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by sarkarri on 2/7/17.
 */
public class ImmutableClass<K, V> {
    private final int id;
    private final String name;
    private final HashMap<K, V> map;

    public ImmutableClass(int id, String name, HashMap<K, V> map) {
        this.id = id;
        this.name = name;

        HashMap tempMap = new HashMap();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            K key = (K) it.next();
            tempMap.put(key, map.get(key));
        }
        this.map = tempMap;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public HashMap<K, V> getMap() {
        return (HashMap<K, V>) map.clone();
    }
}
