package ds.dynamicprogramming;

/**
 * Created by sarkarri on 3/31/17.
 */
public class EditDistance {
    public static void main(String[] args) {
        String str1 = "sunday";
        String str2 = "saturday";
        System.out.println(minEditDistance(str1, str2));
    }

    static int minEditDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int table[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    table[i][j] = j;
                } else if (j == 0) {
                    table[i][j] = i;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    table[i][j] = table[i - 1][j - 1];
                } else {
                    table[i][j] = 1 + Math.min(Math.min(table[i - 1][j - 1], table[i - 1][j]), table[i][j - 1]);
                }
            }
        }
        return table[m][n];
    }
}
