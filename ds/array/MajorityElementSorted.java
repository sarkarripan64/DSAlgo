package ds.array;

/**
 * Created by sarkarri on 1/9/17.
 */
public class MajorityElementSorted {
    public static void main(String[] args) {
        int ar[] = {1, 2, 3, 3, 3, 3, 10};
        //checkMajority(ar);
        int x = 3;
        int indexOfX = binarySearch(ar, x, 0, ar.length - 1);
        if (indexOfX <= ar.length / 2 && ar[indexOfX + ar.length / 2] == x) {
            System.out.println("majority " + ar[indexOfX]);
        }
    }

    static void checkMajority(int[] ar) {
        for (int i = 0; i < ar.length / 2; i++) {
            if (ar[i] == ar[ar.length / 2 + i]) {
                System.out.printf("majority is " + ar[i]);
                return;
            }
        }

        System.out.println("no majority ");
    }

    static int binarySearch(int[] ar, int x, int l, int r) {
        int mid = l + (r - l) / 2;
        if (l <= r) {
            if ((mid == 0 || x > ar[mid - 1]) && ar[mid] == x) {
                return mid;
            } else if (x > ar[mid]) {
                return binarySearch(ar, x, mid + 1, r);
            } else {
                return binarySearch(ar, x, l, mid - 1);
            }
        }
        return -1;
    }
}
