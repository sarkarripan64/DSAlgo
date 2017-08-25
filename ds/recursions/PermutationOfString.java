package ds.recursions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sarkarri on 12/2/16.
 */
public class PermutationOfString {
    static int count = 0;
    static Set<String> stringSet = new HashSet<>();

    public static void main(String[] args) {
        String word = "4321";
//        char ar[] = word.toCharArray();
//        Arrays.sort(ar);
//        word = String.valueOf(ar);
//        System.out.println(word.substring(0, 1));
//        System.out.println(word.charAt(1));
//        System.out.println(word.substring(2, 3));
        permutationRecursive("", word);
//        System.out.println("count " + count);
//        System.out.println(":uniques " + stringSet.size());

        //permutationIterative(word);

    }

    private static void permutationRecursive(String perm, String word) {

        if (word.length() == 0) {
            count++;
            stringSet.add(perm);
            System.out.println(perm + " ");
        } else {
            for (int i = 0; i < word.length(); i++) {
                permutationRecursive(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length()));
            }
        }
    }

    private static void permutationIterative(String word) {
        int n = word.length();
        System.out.println("total no of combination " + fact(n));
        char[] ar = word.toCharArray();
        for (int j = 0; j < n; j++) {
            for (int i = 1; i < n - 1; i++) {
                printPerm(ar);
                swap(ar, i);
            }
        }
    }

    private static int fact(int n) {
        if (n == 1) {
            return 1;
        }

        return n * fact(n - 1);
    }

    private static char[] swap(char[] ar, int m) {
        char c1 = ar[m];
        char c2 = ar[m + 1];
        ar[m] = c2;
        ar[m + 1] = c1;
        return ar;
    }

    static void printPerm(char[] ar) {
        String perm = "";
        for (int i = 0; i < ar.length; i++) {
            perm = perm + ar[i];
        }
        System.out.println(perm);
    }
}
