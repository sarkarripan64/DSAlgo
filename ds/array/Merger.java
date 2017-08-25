package ds.array;

/**
 * Created by sarkarri on 1/5/17.
 */
public class Merger {
    public static void main(String[] args) {
        int mPlusN[] = {2, 8, -1, 13, -1, -1, -1, 15, 20};
        int N[] = {5, 7, 9, 25};
        move(mPlusN);
        print(mPlusN);
    }

    static void merge(int armn[], int arn[]) {
        int i = 0, j = arn.length, k = 0;
        while (i < arn.length) {

        }
    }

    static void move(int[] ar) {
        int i, j = ar.length - 1;
        for (i = j; i >= 0; i--) {
            if (ar[i] != -1) {
                ar[j] = ar[i];
                j--;
            }
        }
    }

    static void print(int[] ar) {
        for (int x : ar) {
            System.out.printf(x + " ");
        }
    }
}
