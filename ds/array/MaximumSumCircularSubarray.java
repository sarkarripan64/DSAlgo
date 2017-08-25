package ds.array;

/**
 * Created by sarkarri on 2/14/17.
 */
public class MaximumSumCircularSubarray {
    public static void main(String[] args) {
        int ar[] = {2, 1, -5, 4, -3, 1, -3, 4, -1};
        int res = findMaxCircular(ar);
        System.out.println("res= " + res);
    }

    static int findMaxCircular(int[] ar) {
        int max_non_circular_sequence_sum = kadanesMaxSubarray(ar);
        System.out.println("max_non_circular_sequence= " + max_non_circular_sequence_sum);
        int max_circular_sum = 0;
        for (int i = 0; i < ar.length; i++) {
            max_circular_sum = max_circular_sum + ar[i];
            ar[i] = -ar[i];
        }
        System.out.println("total sum= "+max_circular_sum);
        int maxSumAfterNegate = kadanesMaxSubarray(ar);
        System.out.println("kadanesMaxSubarray after negate = " + maxSumAfterNegate);
        max_circular_sum = max_circular_sum + maxSumAfterNegate;
        System.out.println("max_circular_sum= " + max_circular_sum);

        return (max_circular_sum > max_non_circular_sequence_sum ? max_circular_sum : max_non_circular_sequence_sum);
    }

    static int kadanesMaxSubarray(int[] ar) {
        int maxSoFar = Integer.MIN_VALUE;
        int max_ends_here = 0;
        for (int i = 0; i < ar.length; i++) {
            max_ends_here = max_ends_here + ar[i];
            if (max_ends_here < 0) {
                max_ends_here = 0;
            }

            if (maxSoFar < max_ends_here) {
                maxSoFar = max_ends_here;
            }
        }

        return maxSoFar;
    }
}
