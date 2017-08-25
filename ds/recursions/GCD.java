package ds.recursions;

/**
 * Created by sarkarri on 11/28/16.
 */
public class GCD {
    public static void main(String[] args) {
        System.out.println("findGCDOFRecursive " + findGCDOFRecursive(54, 24));
        System.out.println("findGCDOFIterative " + findGCDOFIterative(24, 54));
        System.out.println("bitWiseRecursiveGCD " + bitWiseRecursiveGCD(54, 24));
    }

    private static int findGCDOFRecursive(int x, int y) {
        if (y == 0) {
            return x;
        }
        return findGCDOFRecursive(y, x % y);
    }

    private static int findGCDOFIterative(int x, int y) {
        if (y == 0)
            return x;
        while (y != 0) {
            int r = x % y;
            x = y;
            y = r;
        }

        return x;
    }

    private static int bitWiseRecursiveGCD(int x, int y) {
        if (x == y)
            return x;

        if (x == 0)
            return y;
        if (y == 0)
            return x;

        if ((~x & 1) == 1) {
            if ((y & 1) == 1) {
                return bitWiseRecursiveGCD((x >> 1), y);
            } else {
                return bitWiseRecursiveGCD(x >> 1, y >> 1) << 1;
            }
        }

        if ((~y & 1) == 1) {
            return bitWiseRecursiveGCD(x, (y >> 1));
        }
        if (x > y) {
            return bitWiseRecursiveGCD((x - y) >> 1, y);
        } else {
            return bitWiseRecursiveGCD((y - x) >> 1, y);
        }
    }
}
