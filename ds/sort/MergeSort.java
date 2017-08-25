package ds.sort;

/**
 * Created by sarkarri on 12/28/16.
 */
public class MergeSort {
    public static void main(String[] args) {
//        int arr1[] = {1, 5, 6};
//        int arr2[] = {2, 4, 7};
//
//        int res[] = merge(arr1, arr2);
//
//        for (int i : res) {
//            System.out.printf(i + " ");
//        }

        int arr[] = {24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12};
        sort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.printf(i + " ");
        }
    }

    static void sort(int ar[], int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            sort(ar, l, mid - 1);
            sort(ar, mid + 1, r);

            merge(ar, l, r, mid);
        }
    }

    static int[] merge(int arr1[], int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int k = 0;
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                result[k] = arr1[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < arr1.length) {
            result[k] = arr1[i];
            i++;
            k++;
        }

        while (j < arr2.length) {
            result[k] = arr2[j];
            k++;
            j++;
        }

        return result;
    }

    static void merge(int ar[], int l, int r, int m) {
        int k = l;
        int n1 = m - l + 1;
        int n2 = r - m;
        int temp1[] = new int[n1];
        for (int i = 0; i < n1; i++) {
            temp1[i] = ar[l + i];
        }

        int temp2[] = new int[n2];
        for (int i = 0; i < n2; i++) {
            temp2[i] = ar[m + i + 1];
        }

        int i = 0, j = 0;

        while (i < n1 && j < n2) {
            if (temp1[i] < temp2[j]) {
                ar[k] = temp1[i];
                i++;
            } else {
                ar[k] = temp2[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            ar[k] = temp1[i];
            i++;
            k++;
        }

        while (j < n2) {
            ar[k] = temp2[j];
            j++;
            k++;
        }
    }
}
