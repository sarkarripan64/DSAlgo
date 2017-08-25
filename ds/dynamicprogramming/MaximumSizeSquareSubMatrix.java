package ds.dynamicprogramming;

/**
 * Created by sarkarri on 3/30/17.
 */
public class MaximumSizeSquareSubMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};

        System.out.println(findMaxSizeSubMatrix(arr));
    }

    static int findMaxSizeSubMatrix(int ar[][]) {
        int r = ar.length;
        int c = ar[0].length;

        int table[][] = new int[r][c];

        //row
        for (int i = 0; i < c; i++) {
            table[0][i] = ar[0][i];
        }

        //column
        for (int j = 0; j < r; j++) {
            table[j][0] = ar[j][0];
        }

        int maxSoFar = 1;
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (ar[i][j] == 1) {
                    table[i][j] = Math.min(table[i - 1][j], Math.min(table[i - 1][j - 1], table[i][j - 1])) + 1;
                    maxSoFar = Math.max(maxSoFar, table[i][j]);
                } else {
                    table[i][j] = 0;
                }
            }
        }
        return maxSoFar;
    }
}
