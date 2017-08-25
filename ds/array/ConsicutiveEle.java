package ds.array;

/**
 * Created by sarkarri on 1/10/17.
 */
public class ConsicutiveEle {
    public static void main(String[] args) {
        int ar[] = {2, 1, 0, -3, -1, -2};
        //consecutive(ar);
        System.out.println(consecutive1(ar));
    }

    static void consecutive(int[] ar) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] < min) {
                min = ar[i];
            }

            if (ar[i] > max) {
                max = ar[i];
            }
        }

        System.out.println("max " + max);

        if (ar.length == (max - min + 1) && isVisited(ar, min)) {
            System.out.println("Consec");
        } else {
            System.out.println("not Consec");
        }
    }

    static boolean isVisited(int ar[], int min) {
        boolean[] vis = new boolean[ar.length];
        for (int i = 0; i < ar.length; i++) {
            if (vis[ar[i] - min]) {
                return false;
            } else {
                vis[ar[i] - min] = true;
            }
        }

        return true;
    }

    static boolean consecutive1(int ar[]) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] < min) {
                min = ar[i];
            }

            if (ar[i] > max) {
                max = ar[i];
            }
        }

        System.out.println("max " + max);
        int j = 0;
        if (ar.length == (max - min + 1)) {
            for (int i = 0; i < ar.length; i++) {
                if (ar[i] < 0) {
                    j = -ar[i] - min;
                } else {
                    j = ar[i] - min;
                }

                if (ar[j] > 0) {
                    ar[j] = -ar[j];
                } else {
                    return false;
                }
            }

            return true;
        }

        return false;
    }
}
