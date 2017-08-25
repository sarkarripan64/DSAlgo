package ds.array;

/**
 * Created by sarkarri on 2/9/17.
 */
public class SmallestPositiveNumber {
    public static void main(String[] args) {
        int arr[] = {2, 3, 7, 6, 8, -1, -10, 15};
        System.out.println(findSmallestPositive(arr));
    }

    static int findSmallestPositive(int[] ar) {
        int minPo = Integer.MAX_VALUE;

        for (int i = 0; i < ar.length; i++) {
            if (ar[i] < minPo && ar[i] > 0) {
                minPo = ar[i];
            }
        }
        return minPo;
    }
}
