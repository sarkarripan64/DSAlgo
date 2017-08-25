package ds.array;

/**
 * Created by sarkarri on 3/4/17.
 */
public class TapingRainWater {
    public static void main(String[] args) {
        //int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int arr []   = {3, 0, 0, 2, 0, 4};
        System.out.println("total unit of water "+tapWaterUnit(arr));
    }

    static int tapWaterUnit(int ar[]) {
        int n = ar.length;
        int l[] = new int[n];
        int r[] = new int[n];

        l[0] = ar[0];
        for (int i = 1; i < n; i++) {
            l[i] = Math.max(l[i - 1], ar[i]);
        }
        r[n - 1] = ar[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            r[j] = Math.max(r[j + 1], ar[j]);
        }

        int totalWaterUnit = 0;
        for (int k = 1; k < n - 1; k++) {
            totalWaterUnit += (Math.min(l[k], r[k]) - ar[k]);
        }

        return totalWaterUnit;
    }
}
