package ds.array;

/**
 * Created by sarkarri on 2/22/17.
 */
public class LargestContiguousSubarrayLength {
    public static void main(String[] args) {
        //int arr[] = {10, 12, 11};
        //int arr[] = {14, 12, 11, 20};
        //int arr[] = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
        //int arr[] = {1, 2, 3, 4, 5, 6};
        int arr[] = {6, 5, 4, 3, 2, 1};
        System.out.println(maxLength(arr));
    }

    static int maxLength(int ar[]) {
        int maxLength = Integer.MIN_VALUE;
        int n = ar.length;
        int max_so_far = 1;
        for (int i = 1; i < n; i++) {
            if (ar[i] > ar[i - 1]) {
                max_so_far++;
            } else {
                if (max_so_far > maxLength) {
                    maxLength = max_so_far;
                }
                max_so_far = 1;
            }
        }
        return Math.max(max_so_far, maxLength);
    }
}
