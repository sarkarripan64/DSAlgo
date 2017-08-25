package ds.array;

/**
 * Created by sarkarri on 1/12/17.
 */
public class MaxHourGlass {
    public static void main(String[] args) {
        int ar[][] = {{1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}};

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < ar.length - 2; i++) {
            for (int j = 0; j < ar.length - 2; j++) {
                int sum = ar[i][j] + ar[i][j + 1] + ar[i][j + 2] + ar[i + 1][j + 1]
                        + ar[i + 2][j] + ar[i + 2][j + 1] + ar[i + 2][j + 2];
                if (sum > max) {
                    max = sum;
                }
            }
        }

        System.out.println("max = " + max);

        //maxHourGlass(ar);
    }

    static void maxHourGlass(int ar[][]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < ar.length - 2; i++) {
            for (int j = 0; j < ar.length - 2; j++) {
                int sum = ar[i][j] + ar[i][j + 1] + ar[i][j + 2] + ar[i + 1][j + 1]
                        + ar[i + 2][j] + ar[i + 2][j + 1] + ar[i + 2][j + 2];
                if (sum > max) {
                    max = sum;
                }
            }
        }

        System.out.println("max = " + max);
    }
}
