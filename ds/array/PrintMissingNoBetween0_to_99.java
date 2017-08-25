package ds.array;

/**
 * Created by sarkarri on 2/28/17.
 */
public class PrintMissingNoBetween0_to_99 {
    public static void main(String[] args) {
        int arr[] = {88, 105, 3, 2, 200, 0, 10};
        findMissing(arr);
    }

    static void findMissing(int ar[]) {
        boolean[] mark = new boolean[100];
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] < 100) {
                mark[ar[i]] = true;
            }
        }

        int i = 0;
        while (i < mark.length) {
            if (!mark[i]) {
                int j = i + 1;
                while (j < mark.length && !mark[j])
                    j++;

                int p = i + 1;
                System.out.println((p == j) ? i : i + "-" + (j - 1));
                i = j;
            } else {
                i++;
            }
        }
    }
}
