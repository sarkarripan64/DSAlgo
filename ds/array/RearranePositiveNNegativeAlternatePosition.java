package ds.array;

/**
 * Created by sarkarri on 2/17/17.
 */
public class RearranePositiveNNegativeAlternatePosition {
    public static void main(String[] args) {
        //int[] arr = {1, -2, -3, -4, 5, -6, 7, -8, 9, -10, -11, -12, 20};
        //int arr[]={-1, -3, 2, 4, 5, 6, -7, 8, 9};
        int arr[] = {-2, 3, 5, 0, -3, 7 - 1};
        rearrange(arr);
    }

    static void rearrange(int[] ar) {
        int l = 0;
        int r = ar.length - 1;
        while (l < r) {
            if (ar[l] > 0 && ar[r] < 0) {
                swap(ar, l, r);
            } else if (ar[l] < 0) {
                l++;
            } else if (ar[r] >= 0) {
                r--;
            }
        }

        /*while (i < j)
        {
            while (arr[++i] > 0);
            while (arr[--j] < 0);
            if (i < j)
                swap(arr[i], arr[j]);
        }*/

        System.out.println("l== " + l);
        System.out.println("r== " + r);

        for (int i : ar) {
            System.out.print(i + " ");
        }

        int pos = l;
        int neg = 0;

        while (ar[neg] < 0 && neg < pos && pos < ar.length) {
            swap(ar, neg, pos);
            neg = neg + 2;
            pos++;
        }

        System.out.println();

        for (int i : ar) {
            System.out.print(i + " ");
        }

    }

    static void swap(int ar[], int x, int y) {
        int temp = ar[x];
        ar[x] = ar[y];
        ar[y] = temp;
    }
}

