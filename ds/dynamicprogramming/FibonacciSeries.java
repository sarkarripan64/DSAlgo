package ds.dynamicprogramming;

/**
 * Created by sarkarri on 2/14/17.
 */
public class FibonacciSeries {
    public static void main(String[] args) {
        nthFibNoBottomUp(7);
    }

    static void nthFibNoBottomUp(int n) {
        int arr[] = new int[n];
        arr[0] = 0;
        arr[1] = 1;
        int i = 2;
        while (i < n) {
            arr[i] = arr[i - 1] + arr[i - 2];
            i++;
        }
        System.out.println("nth term = " + arr[n - 1]);
    }
}
