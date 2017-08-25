package ds.array;

import util.ArrayUtil;

/**
 * Created by sarkarri on 2/24/17.
 */
public class NutsNBolts {
    public static void main(String[] args) {
        //int nuts[] = {8, 3, 4, 9, 1};
        //int bolts[] = {4, 9, 8, 3, 1};

        int nuts[] = {8, 3, 1, 9, 4};
        int bolts[] = {8, 9, 4, 3, 1};

        //partition(nuts,0,4,8);
        matchPairs(nuts, bolts, 0, nuts.length - 1);
        ArrayUtil.printArray(nuts);
        System.out.println();
        ArrayUtil.printArray(bolts);
    }

    static void matchPairs(int nuts[], int bolts[], int l, int h) {
        if (l < h) {
            int pivotIndex = partition(nuts, l, h, bolts[h]);
            partition(bolts, l, h, nuts[pivotIndex]);
            matchPairs(nuts, bolts, l, pivotIndex - 1);
            matchPairs(nuts, bolts, pivotIndex + 1, h);
        }
    }


    static int partition(int ar[], int l, int h, int pivot) {
        int i = l;
        for (int j = l; j < h; j++) {
            if (ar[j] < pivot) {
                swap(ar, i, j);
                i++;
            } else if (ar[j] == pivot) {
                swap(ar, j, h);
                j--;
            }
        }

        swap(ar, i, h);

        return i;
    }

    static void swap(int ar[], int x, int y) {
        int temp = ar[x];
        ar[x] = ar[y];
        ar[y] = temp;
    }
}
