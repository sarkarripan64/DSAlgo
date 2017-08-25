package ds.dynamicprogramming;

/**
 * Created by sarkarri on 3/28/17.
 */
public class LargestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.println(findLargestSubseqNaive(s1, s2));
        System.out.println(findLargestSubseqDP(s1, s2));

    }

    static int findLargestSubseqNaive(String s1, String s2) {
        return findLargestSubseqNaiveUtil(s1.toCharArray(), s1.length() - 1, s2.toCharArray(), s2.length() - 1);
    }

    static int findLargestSubseqNaiveUtil(char ar1[], int n, char[] ar2, int m) {
        if (n >= 0 && m >= 0) {
            if (ar1[n] == ar2[m]) {
                return 1 + findLargestSubseqNaiveUtil(ar1, n - 1, ar2, m - 1);
            } else {
                return Math.max(findLargestSubseqNaiveUtil(ar1, n - 1, ar2, m), findLargestSubseqNaiveUtil(ar1, n, ar2, m - 1));
            }
        }
        return 0;
    }

    static int findLargestSubseqDP(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int LCS[][] = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;
                } else {
                    LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
                }
            }
        }

        //print longest subsequence
        int x = m;
        int y = n;
        int index = LCS[m][n];
        char longestCS[] = new char[index];

        while (x > 0 && y > 0) {
            if (s1.charAt(x - 1) == s2.charAt(y - 1)) {
                longestCS[index - 1] = s2.charAt(y - 1);
                index--;
                x--;
                y--;
            } else if (LCS[x][y] > LCS[x-1][y]) {
                y--;
            } else {
                x--;
            }
        }

        System.out.println(String.valueOf(longestCS));

        return LCS[m][n];
    }
}
