package ds.array;

/**
 * Created by sarkarri on 2/21/17.
 */
public class PossibleGroupOf2N3 {
    public static void main(String[] args) {
        int arr[] = {3, 6, 7, 2, 9};
        System.out.println(countGrps(arr));
    }

    static int countGrps(int[] ar) {
        int[] count = {0,0,0};
        for (int i = 0; i < ar.length; i++) {
            count[ar[i] % 3]++;
        }

        int res = 0;
        //groups of 2
        res += (count[0] * (count[0] - 1)) / 2;
        res += count[1] * count[2];

        //groups of 3
        res += (count[0] * (count[0] - 1) * count[0] - 2) / 6;
        res += (count[1] * (count[1] - 1) * count[1] - 2) / 6;
        res += (count[2] * (count[2] - 1) * count[2] - 2) / 6;
        res += count[0] * count[1] * count[2];

        return res;
    }
}
