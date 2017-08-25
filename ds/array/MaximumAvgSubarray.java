package ds.array;

/**
 * Created by sarkarri on 3/8/17.
 */
public class MaximumAvgSubarray {
    public static void main(String[] args) {
        int arr[] = {1, 12, -5, -6, 50, 3}, k = 4;

        System.out.println("index starts at " + findMaxAvg(arr, k));
        System.out.println("index starts at " + findMAxAvgEfficient(arr, k));
    }

    static int findMaxAvg(int ar[], int k) {
        int n = ar.length;
        int csum[] = new int[n];
        csum[0] = ar[0];
        for (int i = 1; i < n; i++) {
            csum[i] = csum[i - 1] + ar[i];
        }

        int maxSum = csum[k - 1];
        int maxEndIndex = k - 1;
        for (int j = k; j < n; j++) {
            int curSum = csum[j] - csum[j - k];
            if (curSum > maxSum) {
                maxSum = curSum;
                maxEndIndex = j;
            }
        }

        return maxEndIndex - k + 1;
    }

    static int findMAxAvgEfficient(int ar[], int k) {
        int n = ar.length;
        if (k > n)
            return -1;
        int cur_sum = 0;
        for (int i = k - 1; i >= 0; i--) {
            cur_sum = cur_sum + ar[i];
        }

        int maxSum = cur_sum;
        int max_ends_here = k - 1;
        for (int j = k; j < n; j++) {
            cur_sum = cur_sum + ar[j] - ar[j - k];
            if (cur_sum > maxSum) {
                maxSum = cur_sum;
                max_ends_here = j;
            }
        }

        return max_ends_here - k + 1;
    }
}
