package ds.array;

/**
 * Created by sarkarri on 2/13/17.
 */
public class MaxContiguousProductSubarray {
    public static void main(String[] args) {
        int arr[] = {6, -3, -10, 0, 2};
        //int arr[] = {-1, -3, -10, 0, 60};
        //int  arr[] = {-2, -3, 0, -2, -40};
        System.out.println(findMax(arr));
    }

    static int findMax(int[] ar) {
        int cur_max_product = ar[0];
        int prev_max_product = ar[0];
        int cur_min_prod = ar[0];
        int prev_min_prod = ar[0];
        int res = 0;

        for (int i = 1; i < ar.length; i++) {
            cur_max_product = Math.max(Math.max(prev_max_product * ar[i], prev_min_prod * ar[i]), ar[i]);
            cur_min_prod = Math.min(Math.min(prev_max_product * ar[i], prev_min_prod * ar[i]), ar[i]);
            res = Math.max(cur_max_product, res);
            prev_max_product = cur_max_product;
            prev_min_prod = cur_min_prod;
        }

        return res;
    }
}
