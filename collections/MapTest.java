package collections;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sarkarri on 3/17/17.
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put(null, null);
        if (map.get("adasd") != null) {
            boolean b = (boolean) map.get("adasd");
            System.out.println(b);
        } else {
            System.out.println("its null");
        }
        Map ht = new HashMap();
        ht.put(null, null);
        ht.get(null);
    }
}
