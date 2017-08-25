package ds.array;

import java.util.Arrays;

/**
 * Created by sarkarri on 1/3/17.
 */
public class PairAsSum {
    public static void main(String[] args) {
        int arr[] = {1, 4, 45, 6, 10, -8};
        //int arr[] = {1, 5, 9, 11, 15, 18, 24, 27};
        Arrays.sort(arr);
        int x = 37;
        findPairRecursive(arr, x, 0, arr.length - 1);

        findPairIterative(arr, x);

        int arr1[] = {1, 4, 45, 6, 10, -8};

        printO_of_n(arr1, x);

    }

    static void findPairRecursive(int[] ar, int x, int start, int end) {
        if (ar[start] + ar[end] == x) {
            System.out.println("pair is " + ar[start] + " and " + ar[end]);
            return;
        }
        if (ar[start] + ar[end] > x) {
            findPairRecursive(ar, x, start, end - 1);
        } else {
            findPairRecursive(ar, x, start + 1, end);
        }
    }

    static void findPairIterative(int[] ar, int x) {
        int r = ar.length - 1;
        int l = 0;
        while (l < r) {
            if (ar[l] + ar[r] == x) {
                System.out.println("pair is " + ar[l] + " and " + ar[r]);
                break;
            }

            if (ar[l] + ar[r] > x) {
                r--;
            } else {
                l++;
            }
        }
    }

    static void printO_of_n(int[] inpAr, int sum) {
        boolean[] binMap = new boolean[Integer.MAX_VALUE/8];
        for (int x : inpAr) {
            int temp = sum - x;
            if (temp >= 0 && binMap[temp]) {
                System.out.println("nos are " + x + " and " + temp);
                return;
            }

            binMap[Math.abs(x)] = true;
        }
    }
}
