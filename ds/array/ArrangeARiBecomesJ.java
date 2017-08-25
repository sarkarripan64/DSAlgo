package ds.array;

import util.ArrayUtil;

/**
 * Created by sarkarri on 2/24/17.
 */
public class ArrangeARiBecomesJ {
    public static void main(String[] args) {
        //int arr[] = {2, 4, 1, 0, 3};
        //int arr[] = {1, 3, 0, 2};
        int arr[] =  {2, 0, 1, 4, 5, 3};
        rearrange(arr);
        ArrayUtil.printArray(arr);
    }

    static void rearrange(int ar[]) {
        int n = ar.length;
        for (int i = 0; i < n; i++) {
            //retrieving old value
            int j = ar[i] % n;
            //multiplying i with n so that new value can be retrieve with dividing by n
            ar[j] += n * i;
        }


        for (int j = 0; j < n; j++) {
            ar[j] = ar[j] / n;
        }
    }
}
