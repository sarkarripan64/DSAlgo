package ds.array;

/**
 * Created by sarkarri on 1/6/17.
 */
public class RotatingArray {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        //rotate1(arr, 3);
//        printArray(arr);
        //rotate2(arr, 2);
        rotate3(arr, 3);
    }

    static void rotate1(int[] ar, int d) {
        int[] temp = new int[d];
        for (int i = 0; i < d; i++) {
            temp[i] = ar[i];
        }

        int k = 0;
        for (int j = d; j < ar.length; j++) {
            ar[k] = ar[j];
            k++;
        }

        for (int l = 0; l < temp.length; l++) {
            ar[k] = temp[l];
            k++;
        }

        print(ar);

    }

    static void rotate2(int[] ar, int d) {
        for (int i = 0; i < d; i++) {
            int temp = ar[0];
            int k = 0;
            for (int j = 0; j < ar.length - 1; j++) {
                ar[j] = ar[j + 1];
                k = j;
            }
            ar[k + 1] = temp;
        }

        print(ar);
    }

    static void rotate3(int[] ar, int d) {
        print(ar);
        reverse(ar, 0, d - 1);
        reverse(ar, d, ar.length - 1);
        reverse(ar, 0, ar.length - 1);
        print(ar);
    }

    static void reverse(int[] ar, int start, int end) {
       /* for (int i = start; i <= end; i++) {
            int temp = ar[start];
            ar[start] = ar[end];
            ar[end] = temp;
            start++;
            end--;
        }*/

        while (start < end) {
            int temp = ar[start];
            ar[start] = ar[end];
            ar[end] = temp;
            start++;
            end--;
        }
        //print(ar);
        System.out.println();
    }

    static void blockSwapRecursive(int[] ar, int d, int n) {
        if (n == 0 || d == 0 || n == d)
            return;
        if (n - d == d) {
            swap(ar, 0, d, d);
            return;
        }

        if (n - d > d) {
            swap(ar, 0, n - d, d);
            blockSwapRecursive(ar, d, n - d);
        } else {
            swap(ar, 0, d, n - d);
            blockSwapRecursive(ar, n - d, d);
        }

    }

    static void blockSwapIterative(int[] ar) {

    }

    static void swap(int[] ar, int fi, int si, int d) {
        int temp = 0;
        for (int i = 0; i < d; i++) {
            temp = ar[fi + i];
            ar[fi + i] = ar[si + i];
            ar[si + i] = temp;
        }
    }

    static void print(int[] ar) {
        for (int x : ar)
            System.out.printf(x + " ");
    }
}
