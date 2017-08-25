package ds.array;

/**
 * Created by sarkarri on 2/16/17.
 */
public class MaxDiffOf2Element {
    public static void main(String[] args) {
        //int arr[] = {2, 3, 10, 6, 4, 8, 1};
        int arr[]={ 7, 9, 5, 6, 3, 2};
        System.out.println(findMaxDiffOf2Ele1(arr));
        System.out.println(findMaxDiffOf2Ele2(arr));
    }

    static int findMaxDiffOf2Ele1(int[] ar) {
        int max_diff = Integer.MIN_VALUE;
        int min_ele = ar[0];
        for (int i = 1; i < ar.length; i++) {
            if ((ar[i] - min_ele) > max_diff) {
                max_diff = ar[i] - min_ele;
            } else if (ar[i] < min_ele) {
                min_ele = ar[i];
            }
        }

        return max_diff;
    }

    static int findMaxDiffOf2Ele2(int[] ar) {
        int max_diff = -1;
        int max_ele_from_right = ar[ar.length - 1];

        for (int i = ar.length - 2; i >= 0; i--) {
            if (ar[i] > max_ele_from_right) {
                max_ele_from_right = ar[i];
            } else if (max_ele_from_right - ar[i] > max_diff) {
                max_diff = max_ele_from_right - ar[i];
            }
        }

        return max_diff;
    }
}
