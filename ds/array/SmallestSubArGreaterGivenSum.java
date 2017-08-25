package ds.array;

/**
 * Created by sarkarri on 2/21/17.
 */
public class SmallestSubArGreaterGivenSum {
    public static void main(String[] args) {
//        int arr[] = {1, 4, 45, 6, 0, 19};
//        int x = 51;
//        int arr[] = {1, 10, 5, 2, 7};
//        int x = 9;
        int arr[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
        int x = 280;
        System.out.println(findMinSubAr(arr, x));
    }

    static int findMinSubAr(int ar[], int sum) {
        int cur_sum = 0;
        int n = ar.length;
        int start = 0;
        int end = 0;
        int min_length = Integer.MAX_VALUE;
//        for (int i = 0; i < n; i++) {
//            cur_sum += ar[i];
//            while (cur_sum > sum) {
//                if ((i - start) < min_length) {
//                    min_length = i - start;
//                }
//                cur_sum -= ar[start++];
//            }
//        }

        while (end < n) {
            while (cur_sum <= sum && end < n) {
                cur_sum += ar[end++];
            }

            while (cur_sum > sum && start < n) {
                if ((end - start) < min_length) {
                    min_length = end - start;
                }
                cur_sum -= ar[start++];
            }
        }

        return min_length;
    }
}
