package ds.array;

import util.ArrayUtil;

/**
 * Created by sarkarri on 2/20/17.
 */
public class RearrangeArItoAriOfArI {
    public static void main(String[] args) {
        int arr[] = {3, 2, 0, 1};
        rearrange(arr);
        ArrayUtil.printArray(arr);
    }

    static void rearrange(int[] ar) {
        int n = ar.length;
        for (int i = 0; i < ar.length; i++) {
            ar[i] =  ar[i] + (ar[ar[i]] % n) * n;
        }

        for (int j = 0; j < n; j++) {
            ar[j] = ar[j] / n;
        }
    }
}
