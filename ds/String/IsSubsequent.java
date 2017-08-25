package ds.String;

/**
 * Created by sarkarri on 3/30/17.
 */
public class IsSubsequent {
    public static void main(String[] args) {
        System.out.println(isS1SubsequentOf2("AXY", "ADXCPY"));
        System.out.println(isS1SubsequentOf2("AXY", "YBDXCP"));
        System.out.println(isS1SubsequentOf2("gksrek", "geeksforgeeks"));

        System.out.println("==========");
        //recursive
        System.out.println(isS1SubsequentOf2Recursive("AXY", "ADXCPY", 3, 6));
        System.out.println(isS1SubsequentOf2Recursive("AXY", "YBDXCP", 3, 6));
        System.out.println(isS1SubsequentOf2Recursive("gksrek", "geeksforgeeks", 3, 6));
    }

    static boolean isS1SubsequentOf2(String s1, String s2) {

        int j = 0;
        for (int i = 0; i < s2.length() && j < s1.length(); i++) {
            if (s1.charAt(j) == s2.charAt(i))
                j++;
        }

        return j == s1.length();
    }

    static boolean isS1SubsequentOf2Recursive(String s1, String s2, int m, int n) {

        if (m == 0)
            return true;

        if (n == 0)
            return false;

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return isS1SubsequentOf2Recursive(s1, s2, m - 1, n - 1);
        }

        return isS1SubsequentOf2Recursive(s1, s2, m, n - 1);
    }
}
