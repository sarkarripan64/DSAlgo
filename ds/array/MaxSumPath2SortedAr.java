package ds.array;

/**
 * Created by sarkarri on 2/21/17.
 */
public class MaxSumPath2SortedAr {
    public static void main(String[] args) {
//        int ar1[] = {2, 3, 7, 10, 12, 15, 30, 34};
//        int ar2[] = {1, 5, 7, 8, 10, 15, 16, 19};

        int ar1[] = {2, 3, 7, 10, 12};
        int ar2[] = {1, 5, 7, 8};
        System.out.println(maxSum(ar1, ar2));
    }

    static int maxSum(int ar1[], int ar2[]) {
        int m = ar1.length;
        int n = ar2.length;
        int i = 0, j = 0;
        int sum1 = 0;
        int sum2 = 0;
        int res = 0;
        while (i < m && j < n) {
            if (ar1[i] < ar2[j]) {
                sum1 += ar1[i++];
            } else if (ar1[i] > ar2[j]) {
                sum2 += ar2[j++];
            } else {
                res += Math.max(sum1, sum2);
                sum1 = 0;
                sum2 = 0;
                while (i < m && j < n && ar1[i] == ar2[j]) {
                    res += ar1[i++];
                    j++;
                }
            }
        }

        while (i < m) {
            sum1 += ar1[i++];
        }

        while (j < n) {
            sum2 += ar2[j++];
        }

        res += Math.max(sum1, sum2);

        return res;
    }
}
