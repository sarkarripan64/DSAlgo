package ds.array;

import util.ArrayUtil;

/**
 * Created by sarkarri on 1/9/17.
 */
public class SegregateEvenOdd {
    public static void main(String[] args) {
        int ar[] = {12, 34, 45, 9, 8, 90, 3};
        segregate(ar);
    }

    static void segregate(int[] ar) {
        int l = 0, r = ar.length - 1;
        while (l < r) {
            if (ar[l] % 2 != 0 && ar[r] % 2 == 0) {
                int temp = ar[l];
                ar[l] = ar[r];
                ar[r] = temp;
            } else if (ar[l] % 2 == 0) {
                l++;
            } else if (ar[r] % 2 != 0) {
                r--;
            }
        }

        ArrayUtil.printArray(ar);
    }
}
