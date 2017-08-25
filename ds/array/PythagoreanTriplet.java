package ds.array;

import java.util.Arrays;

/**
 * Created by sarkarri on 2/28/17.
 */
public class PythagoreanTriplet {
    public static void main(String[] args) {
        int arr[] = {3, 1, 4, 6, 5};
        //int arr[] = {10, 4, 6, 12, 5};
        findPythagoreanTriplets(arr);
    }

    static void findPythagoreanTriplets(int ar[]) {
        Arrays.sort(ar);
        for (int i = 0; i < ar.length; i++) {
            ar[i] *= ar[i];
        }

        for (int j = ar.length - 1; j > 1; j--) {
            int l = 0;
            int r = j - 1;
            while (l < r) {
                int sum = ar[l] + ar[r];
                if (ar[j] == sum) {
                    System.out.println("elements are  " + (int)Math.sqrt(ar[j]) + "-" + (int)Math.sqrt(ar[l]) + "-" + (int)Math.sqrt(ar[r]));
                    break;
                } else if (sum > ar[j]) {
                    r--;
                } else {
                    l++;
                }
            }
        }
    }
}
