package ds.array;

/**
 * Created by sarkarri on 3/11/17.
 */
public class FindZerosToBeFlipped {
    public static void main(String[] args) {
        int arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
        int m = 2;
        //int arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
        //int arr[] = {0, 0, 0, 1};
        //m = 4;
        findZeros(arr, m);
    }

    static void findZeros(int ar[], int m) {
        int wL = 0, wR = 0;
        int bestWindow = -1;
        int bestL = 0;
        int zeroCount = 0;

        while (wR < ar.length) {
            if (zeroCount <= m) {
                if (ar[wR] == 0) {
                    zeroCount++;
                }
                wR++;
            } else if (zeroCount > m) {
                if (ar[wL] == 0) {
                    zeroCount--;
                }
                wL++;
            }

            if ((wR - wL) > bestWindow) {
                bestWindow = wR - wL;
                bestL = wL;
            }
        }

        System.out.printf("zeros to be removed at index ");
        for (int i = 0; i < bestWindow; i++) {
            if (ar[bestL + i] == 0)
                System.out.printf(" " + (bestL + i));
        }
    }
}
