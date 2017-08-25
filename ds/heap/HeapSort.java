package ds.heap;

/**
 * Created by sarkarri on 7/12/17.
 */
public class HeapSort {
    private static int N;

    public static void main(String[] args) {
        int ar[] = {8, 12, 14, 16, 1, 5, 6};
        sort(ar);
        for (int v : ar) {
            System.out.print(v + " ");
        }
    }

    private static void sort(int ar[]) {
        int n = ar.length - 1;
        N = ar.length;
        for (int i = n / 2; i >= 0; i--) {
            max_heapify(ar, i);
        }

        for (int j = N - 1; j >= 0; j--) {
            swap(ar, 0, j);
            N = N - 1;
            max_heapify(ar, 0);
        }
    }

    static void max_heapify(int[] ar, int i) {
        int l = leftChild(ar, i);
        int r = rightChild(ar, i);
        int largest = i;
        if (l < N && ar[l] > ar[i]) {
            largest = l;
        } else {
            largest = i;
        }

        if (r < N && ar[r] > ar[largest]) {
            largest = r;
        }

        if (largest != i) {
            swap(ar, largest, i);
            max_heapify(ar, largest);
        }
    }

    static void swap(int[] ar, int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    int parent(int[] ar, int i) {
        if (i >= ar.length)
            return -1;

        return (i - 1) / 2;
    }

    static int leftChild(int[] ar, int i) {
        return 2 * i;
    }

    static int rightChild(int[] ar, int i) {
        return 2 * i + 1;
    }


}
