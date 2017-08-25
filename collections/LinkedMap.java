package collections;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by sarkarri on 6/22/17.
 */
public class LinkedMap {
    public static void main(String[] args) {
        LinkedHashMap map = new LinkedHashMap();
        HashSet s = new HashSet();
        Set sss = new LinkedHashSet();
        TreeSet ts = new TreeSet();
        map.put("123", "123");
        System.out.println("overr " + map.put("123", "456"));
        System.out.println("get " + map.get("123"));
    }
}
