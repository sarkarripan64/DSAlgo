package ds.array;

/**
 * Created by sarkarri on 2/10/17.
 */
public class MaxContiguousSubarraySum {
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(findMaxSubarrayLength(arr));
    }

    static int findMaxSubarrayLength(int[] ar) {
        int max_so_far = 0;
        int max_sum = Integer.MIN_VALUE;
        for (int i = 0; i < ar.length; i++) {
            max_so_far = max_so_far + ar[i];
            if (max_so_far < 0) {
                max_so_far = 0;
            } else if (max_sum < max_so_far) {
                max_sum = max_so_far;
            }
        }
        return max_sum;
    }
}
