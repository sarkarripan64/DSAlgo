package ds.sort;

/**
 * Created by sarkarri on 1/19/17.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] input = {24, 2, 45, 20, 56};//, 75, 2, 56, 99, 53, 12};
        quickSort2(input, 0, input.length - 1);
        for (int i : input) {
            System.out.print(i + " ");
        }
    }

    static void quickSort1(int[] ar, int low, int high) {
        int mid = low + (high - low) / 2;
        int pivot = ar[mid];
        int i = low;
        int j = high;
        while (i <= j) {
            while (ar[i] < pivot) {
                i++;
            }

            while (ar[j] > pivot) {
                j--;
            }

            if (i <= j) {
                swap(ar, i, j);
                i++;
                j--;
            }
        }

        if (low < j)
            quickSort1(ar, low, j);

        if (i < high)
            quickSort1(ar, i, high);
    }


    static void swap(int ar[], int x, int y) {
        int temp = ar[x];
        ar[x] = ar[y];
        ar[y] = temp;
    }

    static void quickSort2(int[] ar, int l, int r) {
        int index = partition(ar, l, r);

        if (l < index - 1) {
            quickSort2(ar, l, index - 1);
        }

        if (index + 1 < r) {
            quickSort2(ar, index, r);
        }
    }


    // l=4 r=2
    //{24, 2, 45, 20, 56}
    //20 2 45 24 56
    static int partition(int[] ar, int l, int r) {
        int pivot = ar[l];

        while (l <= r) {
            while (ar[l] < pivot)
                l++;

            while (ar[r] > pivot)
                r--;

            if (l <= r) {
                swap(ar, l, r);
                l++;
                r--;
            }
        }

        return l;
    }
}
