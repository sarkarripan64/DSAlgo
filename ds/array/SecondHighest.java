package ds.array;

/**
 * Created by sarkarri on 6/7/17.
 */
public class SecondHighest {
    public static void main(String[] args) {
        int numbers[] = {6, 3, 37, 12, 46, 5, 64, 21};
        System.out.println(findSecondHighestNumber(numbers));
    }

    static int findSecondHighestNumber(int[] numbers) {
        int high1 = Integer.MIN_VALUE;
        int high2 = Integer.MIN_VALUE;
        for (int num : numbers) {
            if (num > high1) {
                high2 = high1;
                high1 = num;
            } else if (num > high2) {
                high2 = num;
            }
        }
        return high2;
    }
}
