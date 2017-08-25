package ds.array;

/**
 * Created by sarkarri on 2/9/17.
 */
public class Triplets {
    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        findTriplets(ar, 12);
    }

    static void findTriplets(int[] ar, int sum) {
        if (ar == null || ar.length < 3) {
            return;
        }

        for (int i = 0; i < ar.length - 2; i++) {
            int l = i + 1, r = ar.length - 1;
            while (l < r) {
                int tripletSum = ar[i] + ar[l] + ar[r];
                if (tripletSum == sum) {
                    System.out.println(ar[i] + " " + ar[l] + " " + ar[r]);
                    //return;
                    break;
                } else if (tripletSum < sum) {
                    l++;
                } else {
                    r--;
                }
            }
        }
    }
}
