package ds.array;

/**
 * Created by sarkarri on 2/14/17.
 */
public class ReplaceEveryEleWithGretestRight {
    public static void main(String[] args) {
        int arr[] = {16, 17, 4, 3, 5, 2};
        replaceWithGreatestRight(arr);
    }

    static void replaceWithGreatestRight(int[] ar) {
        int maxRight = ar[ar.length - 1];
        ar[ar.length - 1] = -1;
        for (int j = ar.length - 2; j >= 0; j--) {
            int temp = ar[j];
            ar[j] = maxRight;
            if (temp > maxRight) {
                maxRight = temp;
            }
        }

        for (int k : ar) {
            System.out.printf(k + " ");
        }
    }
}
