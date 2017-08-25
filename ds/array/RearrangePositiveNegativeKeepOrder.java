package ds.array;

import util.ArrayUtil;

/**
 * Created by sarkarri on 2/21/17.
 */
public class RearrangePositiveNegativeKeepOrder {
    public static void main(String[] args) {
        //int arr[n] = {-5, 3, 4, 5, -6, -2, 8, 9, -1, -4};
        //int arr[] = {-5, -3, -4, -5, -6, 2 , 8, 9, 1 , 4};
        //int arr[] = {5, 3, 4, 2, 1, -2 , -8, -9, -1 , -4};
        //int arr[] = {-5, 3, -4, -7, -1, -2 , -8, -9, 1 , -4};
        int arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
        rearrange(arr);
        //rotateRight(arr,0,5);
        ArrayUtil.printArray(arr);
    }

    static void rearrange(int ar[]) {
        int nc = 0;
        int n = ar.length;
        int out_of_place = -1;
        for (int i = 0; i < n; i++) {
            if (out_of_place >= 0) {
                if ((ar[i] > 0 && ar[out_of_place] < 0) || (ar[i] < 0 && ar[out_of_place] > 0)) {
                    rotateRight(ar, out_of_place, i);
                    if (i - out_of_place > 2)
                        out_of_place = out_of_place + 2;
                    else
                        out_of_place = -1;
                }
            }
            if (out_of_place == -1) {
                if ((ar[i] > 0 && i % 2 == 0) || (ar[i] < 0 && i % 2 != 0)) {
                    out_of_place = i;
                }
            }
        }
    }

    static void rotateRight(int ar[], int start, int end) {
        int temp = ar[end];
        for (int i = end; i > start; i--)
            ar[i] = ar[i-1];

        ar[start] = temp;
    }
}
