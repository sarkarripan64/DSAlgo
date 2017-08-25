package ds.array;

/**
 * Created by sarkarri on 2/28/17.
 */
public class CountFrequenciesOfAllElements {
    public static void main(String[] args) {
        int arr[] = {2, 3, 3, 2, 5};
        int arr2[] = {1, 3, 5, 7, 9, 1, 3, 5, 7, 9, 1};
        int arr4[] = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        int arr5[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int arr6[] = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        //countFrequency(arr2);
        countFrequency2(arr);
    }

    static void countFrequency(int ar[]) {
        int n = ar.length;

        for (int i = 0; i < n; i++) {
            ar[i] -= 1;
        }

        for (int i = 0; i < n; i++) {
            int j = ar[i] % n;
            ar[j] += n;
        }

        for (int j = 0; j < n; j++) {
            //System.out.printf(ar[j] + " ");
            System.out.println((j + 1) + "-->" + ar[j] / n + " times");
        }
    }

    static void countFrequency2(int ar[]) {
        int i = 0;
        int n = ar.length;
        while (i < n) {
            if (ar[i] <= 0) {
                i++;
                continue;
            }

            int countIndex = ar[i] - 1;
            if (ar[countIndex] > 0) {
                ar[i] = ar[countIndex];
                ar[countIndex] = -1;
            } else {
                ar[countIndex]--;
                ar[i] = 0;
                i++;
            }
        }

        for (int j = 0; j < n; j++) {
            //System.out.printf(ar[j] + " ");
            System.out.println((j + 1) + "-->" + Math.abs(ar[j]) + " times");
        }
    }

}
