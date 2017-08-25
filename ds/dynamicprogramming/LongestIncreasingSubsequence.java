package ds.dynamicprogramming;

/**
 * Created by sarkarri on 2/15/17.
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        //int arr[] = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        //int arr[] = {50, 3, 10, 7, 40, 80};
        int arr[] = {1, 12, 7, 0, 23, 11, 52, 31, 61, 69, 70, 2};
        System.out.println(findLongestSubsequence(arr));
        System.out.println(findLongestSubsequenceDP(arr));
    }

    static int findLongestSubsequence(int[] ar) {
        int maxLength = 1;
        int n = ar.length;
        for (int i = 0; i < n - 1; i++) {
            int prevMax = ar[i];
            int locLength = 1;
            for (int j = i + 1; j < n; j++) {
                if (ar[j] > prevMax) {
                    locLength += 1;
                    prevMax = ar[j];
                }
            }
            if (maxLength < locLength) {
                maxLength = locLength;
            }

        }
        return maxLength;
    }

    static int findLongestSubsequenceDP(int[] ar) {
        int n = ar.length;
        int lis[] = new int[n];
        for (int i = 0; i < n; i++)
            lis[i] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (ar[i] > ar[j] && lis[i] < (lis[j] + 1)) {
                    lis[i] = lis[j] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++)
            if (max < lis[i])
                max = lis[i];

        return max;
    }
}
