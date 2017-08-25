package xor;

/**
 * Created by sarkarri on 5/26/17.
 */
public class SwapWithoutTemp {
    public static void main(String[] args) {
        swap(4, 5);
    }

    static void swap(int x, int y) {
        System.out.println("x and y before swap " + x + " " + y);
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println("x and y after swap " + x + " " + y);
    }
}
