package ds.array;

import util.ArrayUtil;

/**
 * Created by sarkarri on 3/4/17.
 */
public class ConvertArrayZigzag {
    public static void main(String[] args) {
        int arr[] = {12, 44, 3, 14, 1, 2, 4, 7, 9, 5, 16, 18};
        //expected (a<b<c format)
        convertToZigzag(arr);
        ArrayUtil.printArray(arr);
    }


    static void convertToZigzag(int ar[]) {
        boolean flag = true;
        for (int i = 0; i < ar.length - 1; i++) {
            if (flag && ar[i + 1] > ar[i]) {
                swap(ar, i, i + 1);
            } else if (!flag && ar[i + 1] < ar[i]) {
                swap(ar, i, i + 1);
            }
            flag = !flag;
        }
    }

    static void swap(int ar[], int x, int y) {
        int temp = ar[x];
        ar[x] = ar[y];
        ar[y] = temp;
    }
}
