package ds.array;

import java.util.Arrays;

/**
 * Created by sarkarri on 2/14/17.
 */
public class NumberOfPossibleTriangles {
    public static void main(String[] args) {
        int[] ar = {4, 6, 3, 7};
        System.out.println(noOfTriangles(ar));
    }

    static int noOfTriangles(int[] arr) {
        int n = arr.length;

        // Sort the array elements in non-decreasing order
        Arrays.sort(arr);

        // Initialize count of triangles
        int count = 0;

        // Fix the first element.  We need to run till n-3 as
        // the other two elements are selected from arr[i+1...n-1]
        for (int i = 0; i < n - 2; ++i) {
            // Initialize index of the rightmost third element
            int k = i + 2;

            // Fix the second element
            for (int j = i + 1; j < n; ++j) {
                while (k < n && arr[i] + arr[j] > arr[k])
                    ++k;
                count += k - j - 1;
            }
        }
        return count;
    }
}
