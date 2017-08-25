package ds.recursions;

/**
 * Created by sarkarri on 11/25/16.
 */
public class FibonacciSeries {

    public static void main(String[] args) {
        printSeriesIterative(6);
        System.out.println(printRecursive(6));
    }

    protected static void printSeriesIterative(int nth) {
        int previous = 1;
        int current = 1;
        int next = current + previous;

        for (int i = 0; i < nth; i++) {
            System.out.println("term is " + previous);
            previous = current;
            current = next;
            next = current + previous;
        }
    }

    private static int printRecursive(int nth) {
        if (nth <= 1) {
            return 1;
        }

        return printRecursive(nth - 1) + printRecursive(nth - 2);
    }
}
