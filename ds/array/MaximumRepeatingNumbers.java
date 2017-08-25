package ds.array;

/**
 * Created by sarkarri on 2/15/17.
 */
public class MaximumRepeatingNumbers {
    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 2, 0, 2, 0, 2, 3, 8, 0, 9, 2, 3};
        //int arr[] = {2, 3, 3, 5, 3, 4, 1, 7};
        System.out.println(findMaxRepeatingNumber1(arr));
        int k = 8;
        System.out.println("efficient= " + findMaxRepeatingNumberefficient(arr, k));
    }

    static int findMaxRepeatingNumber1(int ar[]) {
        int count[] = new int[ar.length];
        for (int i = 0; i < ar.length; i++) {
            count[ar[i]]++;
        }

        int max = count[0];
        int maxRepatedNumber = ar[0];
        for (int j = 0; j < count.length; j++) {
            if (count[j] > max) {
                max = count[j];
                maxRepatedNumber = j;
            }
        }

        System.out.println("max repeated number= " + maxRepatedNumber + " no of times= " + max);

        return maxRepatedNumber;
    }

    static int findMaxRepeatingNumberefficient(int ar[], int k) {
        int max = Integer.MIN_VALUE;
        int maxRepatedNumber = -1;
        for (int i = 0; i < ar.length; i++) {
            ar[ar[i] % k] += k;
            if (ar[ar[i] % k] > max) {
                max = ar[ar[i] % k];
                maxRepatedNumber = ar[i];
            }
        }

        return maxRepatedNumber;
    }
}
