package ds.String;

/**
 * Created by sarkarri on 3/25/17.
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        //String s = "forgeeksskeegfor";
        String s = "geeksskeeg";
        findLongestPalindrome(s);
    }

    static void findLongestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        int start = 0;
        int maxLength = 1;
        for (int i = 1; i < n; i++) {
            //even length palindromes
            int l = i - 1;
            int h = i;
            while (l >= 0 && h < n && chars[h] == chars[l]) {
                if ((h - l + 1) > maxLength) {
                    maxLength = h - l + 1;
                    start = l;
                }
                l--;
                h++;
            }
            //odd length palindromes
            l = i - 1;
            h = i + 1;
            while (l >= 0 && h < n && chars[h] == chars[l]) {
                if ((h - l + 1) > maxLength) {
                    maxLength = h - l + 1;
                    start = l;
                }
                l--;
                h++;
            }
        }
        String subStr = s.substring(start, start + maxLength);
        System.out.println("max length palindrome " + subStr+" length "+subStr.length());
    }
}
