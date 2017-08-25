package ds.String;

/**
 * Created by sarkarri on 3/17/17.
 */
public class CheckGivenStringIsInterleavngOfTwo {
    public static void main(String[] args) {
        String s1 = "AB";
        String s2 = "XY";
        String key = "XYAB";
        System.out.println("isInterleaving " + isInterleaving(s1, s2, key));
    }

    static boolean isInterleaving(String s1, String s2, String key) {
        if (key.length() != s1.length() + s2.length())
            return false;

        int i = 0, j = 0, k = 0;
        while (k < key.length()) {
            if (i < s1.length() && key.charAt(k) == s1.charAt(i)) {
                i++;
            } else if (j < s2.length() && key.charAt(k) == s2.charAt(j)) {
                j++;
            } else {
                return false;
            }
            k++;
        }

        return true;
    }
}
