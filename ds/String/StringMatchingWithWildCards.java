package ds.String;

/**
 * Created by sarkarri on 3/27/17.
 */
public class StringMatchingWithWildCards {
    public static void main(String[] args) {
        String pattern = "abc*bcd";
        String s = "abcdhghgbcd";

        System.out.println(match(pattern, s));
    }

    static boolean match(String pattern, String str) {
        int n = pattern.length();
        int m = str.length();

        int i = 0, j = 0;
        int x = 0, y = -1;

        while (i < m) {
            if ((str.charAt(i) == pattern.charAt(j)) || pattern.charAt(j) == '?') {
                i++;
                j++;
            } else if (pattern.charAt(j) == '*') {
                x = i;
                y = j;
                j++;
            } else if (y > 0) {
                i = x + 1;
                x++;
                j = y;
            } else {
                return false;
            }
        }

        if (i != m)
            return false;

        while (j != n && pattern.charAt(j) == '*') {
            j++;
        }

        return n == j;
    }
}
