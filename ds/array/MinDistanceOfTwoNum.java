package ds.array;

/**
 * Created by sarkarri on 2/1/17.
 */
public class MinDistanceOfTwoNum {
    public static void main(String[] args) {
        int arr[] = {3, 5,6, 4, 4, 4, 5,3};
        int x = 3, y = 4;
        System.out.println("min dist = " + findMinDistance(arr, x, y));
    }

    static int findMinDistance(int[] ar, int x, int y) {
        int prevIdx = -1;
        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == x || ar[i] == y) {
                if (prevIdx != -1 && ar[prevIdx] != ar[i]) {
                    if (minDist > (i - prevIdx)) {
                        minDist = i - prevIdx;
                    }
                }
                prevIdx = i;
            }
        }
        return minDist;
    }
}
