package ds.dynamicprogramming;

/**
 * Created by sarkarri on 3/31/17.
 */
public class MinCostPath {
    public static void main(String[] args) {
        int[][] A = {
                {1, 7, 9, 2},
                {8, 6, 3, 2},
                {1, 6, 7, 8},
                {2, 9, 8, 2}};

        int res[][] = findMinCost(A);

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("=======");
        int r = 2;//res.length;
        int c = 3;//res[0].length;
        System.out.println("min cost tp reach index i j " + res[2][3]);
    }

    static int[][] findMinCost(int[][] arr) {
        int r = arr.length;
        int c = arr[0].length;

        int MC[][] = new int[r][c];

        MC[0][0] = arr[0][0];

        for (int i = 1; i < r; i++) {
            MC[i][0] = arr[i][0] + MC[i - 1][0];
        }

        for (int j = 1; j < c; j++) {
            MC[0][j] = arr[0][j] + MC[0][j - 1];
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                MC[i][j] = arr[i][j] + Math.min(Math.min(MC[i - 1][j - 1], MC[i - 1][j]), MC[i][j - 1]);
            }
        }

        return MC;
    }
}
