package ds.String;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by sarkarri on 3/14/17.
 */
public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        try {
            System.out.println(findNonRepeatingChar(s));
            System.out.println(findNonRepeatingChar1(s));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static char findNonRepeatingChar(String s) throws Exception {
        char arc[] = s.toCharArray();
        int[] charHolder = new int[256];
        for (int i = 0; i < arc.length; i++) {
            charHolder[arc[i]]++;
        }

        for (int j = 0; j < charHolder.length; j++) {
            //System.out.print(charHolder[j]+" ");
            if (charHolder[j] == 1) {
                return (char) j;
            }
        }
        throw new Exception("no non repeating char");
    }

    static char findNonRepeatingChar1(String s) throws Exception {
        Map<Character, AtomicInteger> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            AtomicInteger j = map.get(c);
            if (j == null) {
                j = new AtomicInteger();
                map.put(c, j);
            }
            j.incrementAndGet();
        }

        for (Map.Entry<Character, AtomicInteger> entry : map.entrySet()) {
            if (entry.getValue().get() == 1) {
                return entry.getKey();
            }
        }
        throw new Exception("no non repeating char");
    }
}
