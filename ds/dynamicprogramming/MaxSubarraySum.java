package ds.dynamicprogramming;

/**
 * Created by sarkarri on 5/10/17.
 */
public class MaxSubarraySum {
    public static void main(String[] args) {
        int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        findMaxSubArraySum(a);
    }

    static void findMaxSubArraySum(int[] ar) {
        int max_so_far = 0;
        int max_ends_here = 0;
        int start = 0, end = 0, s = 0;
        for (int i = 0; i < ar.length; i++) {
            max_ends_here = max_ends_here + ar[i];
            if (max_ends_here < 0) {
                max_ends_here = 0;
                s = i + 1;
            } else {
                if (max_ends_here > max_so_far) {
                    max_so_far = max_ends_here;
                    end = i;
                    start = s;
                }
            }
        }

        System.out.println("maximum sum =" + max_so_far);
        for (int j = start; j <= end; j++) {
            System.out.print(ar[j] + " ");
        }
    }
}
