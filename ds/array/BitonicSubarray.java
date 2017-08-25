package ds.array;

/**
 * Created by sarkarri on 2/2/17.
 */
public class BitonicSubarray {
    public static void main(String[] args) {
        //int arr[] = {12, 4, 78, 90, 45, 23};
        int arr[] = {8, 1, 7, 3, 4, 5, 0};
        System.out.println(maxBitonicLength(arr));
    }

    static int maxBitonicLength(int[] ar) {
        int[] incOrder = new int[ar.length];
        int[] decOrder = new int[ar.length];
        incOrder[0] = 1;
        for (int i = 1; i < ar.length; i++) {
            if (ar[i] > ar[i - 1]) {
                incOrder[i] = incOrder[i - 1] + 1;
            } else {
                incOrder[i] = 1;
            }
        }

        decOrder[ar.length - 1] = 1;
        for (int i = ar.length - 2; i >= 0; i--) {
            if (ar[i] > ar[i + 1]) {
                decOrder[i] = decOrder[i + 1] + 1;
            } else {
                decOrder[i] = 1;
            }
        }

        int maxLength = Integer.MIN_VALUE;

        for (int i = 0; i < ar.length; i++) {
            if ((incOrder[i] + decOrder[i] - 1) > maxLength) {
                maxLength = incOrder[i] + decOrder[i] - 1;
            }
        }

        return maxLength;

    }
}
