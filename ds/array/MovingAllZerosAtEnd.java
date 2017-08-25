package ds.array;

/**
 * Created by sarkarri on 2/20/17.
 */
public class MovingAllZerosAtEnd {
    public static void main(String[] args) {
        int[] ar = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0};
        //order changed
//        moveZeros(ar);
//        for (int i : ar) {
//            System.out.printf(i + " ");
//        }
        //order maintained
        moveZerosKeepingOrder(ar);
        System.out.println();
        for (int i : ar) {
            System.out.printf(i + " ");
        }
    }

    static void moveZeros(int[] ar) {
        int l = 0;
        int n = ar.length;
        int r = n - 1;

        while (l < r) {
            while (l < n && ar[l] > 0) {
                l++;
            }

            while (r >= 0 && ar[r] <= 0) {
                r--;
            }

            if (r > l) {
                int temp = ar[l];
                ar[l] = ar[r];
                ar[r] = temp;
                l++;
                r--;
            }
        }
    }

    static void moveZerosKeepingOrder(int ar[]) {
        int count = 0;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] > 0) {
                ar[count++] = ar[i];
            }
        }
        while (count < ar.length) {
            ar[count++] = 0;
        }
    }
}
