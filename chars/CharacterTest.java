package chars;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sarkarri on 5/9/17.
 */
public class CharacterTest {
    public static void main(String[] args) {
        String s1 = "A";
        String s2 = "B";
//        boolean[] exist = new boolean[256];
//        System.out.println(exist[s1.charAt(1)]);

        Set<String> set = new HashSet<>();
        set.add(s1);
        set.add(s2);
        System.out.println(set.size());
        s1 = s2;
        System.out.println(set.size());

        String s = "docTestUser1@gmail.com_dc05e6d5-e740-4eab-be3f-fafbfc94e1b5";
        char ar[] = s.toCharArray();
        System.out.println(ar.length);
    }
}
