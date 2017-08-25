package ds.String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * Created by sarkarri on 3/11/17.
 */
public class RemoveDuplicatesFromString {
    public static void main(String[] args) {
        String s = "test string";
        //removeDuplicates1(s);
        removeDuplicates2(s);
        removeDuplicates3(s);
    }

    static void removeDuplicates1(String s) {
        char[] arc = s.toCharArray();
        int n = arc.length;

        Arrays.sort(arc);
        System.out.println(String.copyValueOf(arc));

        for (int i = 1; i < n; i++) {
            if (arc[i] == arc[i - 1]) {
                arc[i - 1] = Character.MIN_VALUE;
            }
        }
        System.out.println(new String(arc));
    }

    static void removeDuplicates2(String s) {
        char[] arc = s.toCharArray();
        int[] charHolder = new int[255];
        char[] res = new char[arc.length];

        for (int i = 0; i < arc.length; i++) {
            if (charHolder[arc[i]] <= 0) {
                res[i] = arc[i];
                charHolder[arc[i]]++;
            }
        }

        System.out.println(new String(res));
    }

    static void removeDuplicates3(String s) {
        char[] arc = s.toCharArray();
        HashSet<Character> hashSet = new LinkedHashSet<>();
        for (int i = 0; i < arc.length; i++) {
            hashSet.add(arc[i]);
        }

        System.out.println(hashSet);
    }
}
