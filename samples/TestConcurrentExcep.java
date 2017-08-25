package samples;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sarkarri on 3/10/17.
 */
public class TestConcurrentExcep {
    private static final Map<String, Object> map = new HashMap<>();

    public static void main(String[] args) {
        int i = 0;
        Runnable r1 = () -> {
            System.out.println("putting ");
            while (i < 1000) {
                map.put("1", 1);
                map.put("2", 2);
                moddify();
            }
        };
        Runnable r2 = () -> {
            moddify();
        };

        new Thread(r1).start();
        new Thread(r2).start();
    }

    static void moddify() {
        map.put("1", 1);
        map.put("2", 2);
        Object o2 = map.remove("2");
        System.out.println(o2);
    }
}
