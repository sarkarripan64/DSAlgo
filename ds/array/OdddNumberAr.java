package ds.array;

/**
 * Created by sarkarri on 1/5/17.
 */
public class OdddNumberAr {
    public static void main(String[] args) {
        System.out.printf("odd " + findOdd(new int[]{1, 2, 3, 2, 3, 1, 3}));
    }

    static int findOdd(int[] ar) {
        int res = 0;
        for (int x : ar) {
            res = res ^ x;
        }

        return res;
    }
}
