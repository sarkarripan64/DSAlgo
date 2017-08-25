package ds.array;

/**
 * Created by sarkarri on 3/3/17.
 */
public class MinNoOfSwap {
    public static void main(String[] args) {
        int arr[] = {0, 3, 5, 6, 4, 1, 2};
        int pairs[] = {0, 3, 6, 1, 5, 4, 2};
        int m = args.length;

        int n = 3;  // Number of pairs n is half of total elements

        System.out.println(minSwap(arr, pairs, n));
    }

    static int minSwap(int ar[], int pair[], int n) {
        int index[] = new int[2 * n + 1];
        for (int i = 1; i <= 2 * n; i++) {
            index[ar[i]] = i;
        }

        return minSwapUtil(ar, pair, index, 1, 2 * n);
    }

    static int minSwapUtil(int ar[], int pair[], int index[], int i, int n) {
        if (i > n) {
            return 0;
        }

        if (ar[i + 1] == pair[ar[i]]) {
            return minSwapUtil(ar, pair, index, i + 2, n);
        }

        int one = ar[i + 1];
        int index_of_one = i + 1;
        int index_of_two = index[pair[ar[i]]];
        int two = ar[index_of_two];
        swap(ar, ar[i + 1], ar[index_of_two]);
        updateIndexes(index, two, index_of_one, one, index_of_two);
        int a = minSwapUtil(ar, pair, index, i + 2, n);

        //back track
        swap(ar, ar[i + 1], ar[index_of_two]);
        updateIndexes(index, two, index_of_two, one, index_of_one);

        one = ar[i];
        index_of_one = i;
        index_of_two = index[pair[ar[i + 1]]];
        two = ar[index_of_two];
        swap(ar, ar[i], ar[index_of_two]);
        updateIndexes(ar, two, index_of_one, one, index_of_two);
        int b = minSwapUtil(ar, pair, index, i + 2, n);

        //back track
        swap(ar, ar[i], ar[index_of_two]);
        updateIndexes(ar, two, index_of_two, one, index_of_one);

        return 1 + Math.min(a, b);
    }

    static void updateIndexes(int index[], int one, int one_i, int two, int two_i) {
        index[one] = one_i;
        index[two] = two_i;
    }

    static void swap(int ar[], int x, int y) {
        int temp = ar[x];
        ar[x] = ar[y];
        ar[y] = temp;
    }
}
