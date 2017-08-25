package ds.String;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by sarkarri on 3/25/17.
 */
public class PrintAnagramTogether {
    public static void main(String[] args) {
        String[] arStr = {"cat", "dog", "tac", "god", "act", "human"};
        printAnagrams(arStr);
    }

    public static void printAnagrams(String[] arStr) {
        Arrays.sort(arStr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                char[] ar1 = o1.toCharArray();
                char[] ar2 = o2.toCharArray();
                Arrays.sort(ar1);
                Arrays.sort(ar2);
                o1 = String.valueOf(ar1);
                o2 = String.valueOf(ar2);
                return o1.compareTo(o2);
            }
        });

        for (int i = 0; i < arStr.length; i++) {
            System.out.print(arStr[i] + " ");
        }
    }


}
