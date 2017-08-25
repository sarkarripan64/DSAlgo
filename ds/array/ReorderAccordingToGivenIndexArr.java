package ds.array;

import util.ArrayUtil;

/**
 * Created by sarkarri on 3/8/17.
 */
public class ReorderAccordingToGivenIndexArr {
    public static void main(String[] args) {
        int arr[] = {50, 40, 70, 60, 90};
        int index[] = {3, 0, 4, 1, 2};

        reorder(arr, index);
        ArrayUtil.printArray(arr);
    }

    static void reorder(int ar[], int idx[]) {
        for (int i = 0; i < ar.length; i++) {
            while (idx[i] != i) {
                int tempData = ar[idx[i]];
                int tempIdx = idx[idx[i]];
                ar[idx[i]] = ar[i];
                idx[idx[i]] = idx[i];
                ar[i] = tempData;
                idx[i] = tempIdx;
            }
        }
    }
}
