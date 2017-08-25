package ds.String;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sarkarri on 3/13/17.
 */
public class RemoveCharFromFstPresentInSecnd {
    public static void main(String[] args) {
        String s1 = "test string";
        String s2 = "trg";
        System.out.println(remove1(s1, s2));
        System.out.println(remove2(s1, s2));
    }

    static String remove1(String s1, String s2) {
        char[] ca1 = s1.toCharArray();
        char[] ca2 = s2.toCharArray();

        Set<Character> hashSet = new HashSet<>();

        for (int i = 0; i < ca2.length; i++) {
            hashSet.add(ca2[i]);
        }

        for (int j = 0; j < ca1.length; j++) {
            if (hashSet.contains(ca1[j])) {
                ca1[j] = ' ';
            }
        }

        return new String(ca1);
    }

    static String remove2(String s1, String s2) {
        char[] ca1 = s1.toCharArray();
        char[] ca2 = s2.toCharArray();

        int[] charHolder = new int[255];

        for (int i = 0; i < ca2.length; i++) {
            charHolder[ca2[i]]++;
        }

        for (int j = 0; j < ca1.length; j++) {
            if (charHolder[ca1[j]] != 0) {
                ca1[j] = ' ';
            }
        }

        return new String(ca1);
    }
}
