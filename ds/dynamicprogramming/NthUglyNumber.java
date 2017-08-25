package ds.dynamicprogramming;

/**
 * Created by sarkarri on 5/9/17.
 */
public class NthUglyNumber {
    public static void main(String[] args) {
        System.out.println(getNthUglyNo(10));
    }

    static int getNthUglyNo(int n) {
        int count = 1;
        int i = 1;
        while (n > count) {
            i++;
            if (isUgly(i) == 1)
                count++;
        }
        return i;
    }

    static int isUgly(int no) {
        no = maxDivisiblePower(no, 2);
        no = maxDivisiblePower(no, 3);
        no = maxDivisiblePower(no, 5);
        return no == 1 ? 1 : 0;
    }

    static int maxDivisiblePower(int a, int b) {
        while (a % b == 0) {
            a = a / b;
        }
        return a;
    }
}
