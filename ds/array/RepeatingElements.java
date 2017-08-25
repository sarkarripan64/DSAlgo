package ds.array;

/**
 * Created by sarkarri on 1/9/17.
 */
public class RepeatingElements {
    public static void main(String[] args) {
        int ar[] = {4, 2, 4, 5, 2, 3, 1};
        //findRepeatingElementXor(ar);
        //findDupCountArray(ar);
        findDupNegation(ar);
    }

    static void findRepeatingElementXor(int[] ar) {
        int result = ar[0];
        for (int i = 1; i < ar.length; i++) {
            result = result ^ ar[i];
        }

        System.out.printf(result + " ");
    }

    static void findDupCountArray(int[] ar) {
        int[] count = new int[ar.length];

        for (int i = 0; i < ar.length; i++) {
            if (count[ar[i]] == 1) {
                System.out.printf(ar[i] + " ");
            }
            count[ar[i]]++;
        }
    }

    static void findDupNegation(int[] ar) {
        for (int i = 0; i < ar.length - 1; i++) {
            if (ar[Math.abs(ar[i])] > 0) {
                ar[Math.abs(ar[i])] = -ar[Math.abs(ar[i])];
            }else {
                System.out.println(Math.abs(ar[i])+ " is duplicate");
            }
        }
    }
}
