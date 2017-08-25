package ds.array;

/**
 * Created by sarkarri on 1/9/17.
 */
public class MaxDiff {
    public static void main(String[] args) {
        int ar[] = {2, 3, 10, 6, 4, 8, 1};
        maxDiffPair(ar);
        maxDiff1(ar);
    }

    static void maxDiffPair(int[] ar) {
        int maxDiff = 0;
        int min_ele = ar[0];

        for (int i = 1; i < ar.length; i++) {
            if (ar[i] - min_ele > maxDiff) {
                maxDiff = ar[i] - min_ele;
            }
            if (ar[i] < min_ele)
                min_ele = ar[i];
        }
        System.out.println("max diff " + maxDiff);
    }

    static void maxDiff1(int ar[]) {
        int maxDiff = -1;
        int maxR = ar[ar.length - 1];
        for (int i = ar.length - 2; i >= 0; i--) {
            if (ar[i] > maxR) {
                maxR = ar[i];
            } else {
                if (maxR - ar[i] > maxDiff) {
                    maxDiff = maxR - ar[i];
                }
            }
        }

        System.out.println("max diff " + maxDiff);
    }
}
