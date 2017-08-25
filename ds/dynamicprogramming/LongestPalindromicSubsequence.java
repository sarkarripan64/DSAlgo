package ds.dynamicprogramming;

/**
 * Created by sarkarri on 3/23/17.
 */
public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        //String s = "ABCA";//"AABCDEBAZ";
        //String s = "“BBABCBCAB";
        String s = "GEEKSFORGEEKS";
        int[][] lpArray = findPalindromes(s);
        for (int i = 0; i < lpArray.length; i++) {
            for (int j = 0; j < lpArray.length; j++) {
                System.out.print(lpArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] findPalindromes(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        int LP[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            LP[i][i] = 1;
        }

        for (int sublen = 2; sublen <= n; sublen++) {
            for (int i = 0; i <= n - sublen; i++) {
                int j = i + sublen - 1;
                if (chars[i] == chars[j] && sublen == 2) {
                    LP[i][j] = 2;
                } else if (chars[i] == chars[j]) {
                    LP[i][j] = LP[i + 1][j - 1] + 2;
                } else {
                    LP[i][j] = Math.max(LP[i + 1][j], LP[i][j - 1]);
                }
            }
        }

        return LP;
    }
}
