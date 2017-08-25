package ds.array;

import java.util.Arrays;

/**
 * Created by sarkarri on 3/11/17.
 */
public class TripletsSmallerThanGivenSum {
    public static void main(String[] args) {
        //int arr[] = {5, 1, 3, 4, 7};
        int sum = 12;

        int arr[] = {-2, 0, 1, 3};
        sum = 2;
        System.out.println(countTriplets(arr, sum));
    }

    static int countTriplets(int ar[], int sum) {
        Arrays.sort(ar);
        int res = 0;
        for (int i = 0; i < ar.length; i++) {
            int j = i + 1;
            int k = ar.length - 1;

            while (j < k) {
                while ((ar[i] + ar[j] + ar[k]) >= sum && j < k) {
                    k--;
                }

                if (j < k) {
                    res += k - j;
                }
                j++;
            }
        }

        return res;
    }
}
