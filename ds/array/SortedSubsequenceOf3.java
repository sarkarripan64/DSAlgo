package ds.array;

/**
 * Created by sarkarri on 2/10/17.
 */
public class SortedSubsequenceOf3 {
    public static void main(String[] args) {
        int arr[] = {12, 11, 10, 5, 6, 2, 30};
        //int arr[] = {1, 2, 3, 4};
        findSequence(arr);
    }

    static void findSequence(int ar[]) {
        int smaller[] = new int[ar.length];
        int greater[] = new int[ar.length];

        for (int i = 0; i < ar.length; i++) {
            smaller[i] = -1;
            greater[i] = -1;
        }

        int smallIdx = 0;
        int largest = ar[ar.length - 1];
        int largeIdx = ar.length - 1;

        for (int i = 1; i < ar.length; i++) {
            if (ar[i] > ar[smallIdx]) {
                smaller[i] = smallIdx;
            } else {
                smaller[i] = -1;
                smallIdx = i;
            }
        }

        for (int i = ar.length - 2; i >= 0; i--) {
            if (ar[i] < largest) {
                greater[i] = largeIdx;
            } else {
                largest = ar[i];
                largeIdx = i;
            }
        }

        for (int i = 1; i < ar.length - 1; i++) {
            if (smaller[i] >= 0 && greater[i] >= 0) {
                System.out.println(ar[smaller[i]] + " " + ar[i] + " " + ar[greater[i]]);
            }
        }
    }
}
