package ds.array;

import util.ArrayUtil;

/**
 * Created by sarkarri on 1/9/17.
 */
public class SegregrateZerosNOnes {
    public static void main(String[] args) {
        int arr[] = {1, 1, 0, 1, 1, 0, 1};
        //byCountMethod(arr);
        System.out.println();
        //bySwapMethod(arr, 0, arr.length - 1);

        System.out.println("======");

        byCountAnotherWay(arr);
    }

    static void byCountMethod(int[] ar) {
        int c = 0;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == 0)
                c++;
        }
        int j = 0;
        while (j < c) {
            ar[j] = 0;
            j++;
        }
        while (j < ar.length) {
            ar[j] = 1;
            j++;
        }
        ArrayUtil.printArray(ar);
    }

    static void bySwapMethod(int ar[], int l, int r) {
        while (l < r) {
            if (ar[l] == 1 && ar[r] == 0) {
                ar[l] = 0;
                ar[r] = 1;
                l++;
                r--;
            } else if (ar[l] == 0) {
                l++;
            } else if (ar[r] == 1) {
                r--;
            }
        }
        ArrayUtil.printArray(ar);
    }

    static void byCountAnotherWay(int[] ar) {
        int count = 0;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == 0) {
                ar[count++] = 0;
            }
        }

        while (count < ar.length) {
            ar[count++] = 1;
        }

        ArrayUtil.printArray(ar);
    }
}
