package ds.dynamicprogramming;

/**
 * Created by sarkarri on 5/10/17.
 */
public class LongestSubstringWithoutRepeatingChar {
    public static void main(String[] args) {
        String s = "abcdcddhijklm";
        System.out.println(getLongestSubstrLength(s));
    }

    static int getLongestSubstrLength(String s) {
        boolean exist[] = new boolean[256];
        int i = 0, j = 0;
        int maxLength = Integer.MIN_VALUE;
        for (j = 0; j < s.length(); j++) {
            while (exist[s.charAt(j)]) {
                exist[s.charAt(i)] = false;
                i++;
            }
            exist[s.charAt(j)] = true;
            if (maxLength < (j - i + 1)) {
                maxLength = (j - i + 1);
            }
        }

        return maxLength;
    }
}
