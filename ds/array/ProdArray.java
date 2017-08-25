package ds.array;

/**
 * Created by sarkarri on 1/31/17.
 */
public class ProdArray {
    public static void main(String[] args) {
        int arr[] = {10, 3, 5, 6, 2};
        prepareProdAr(arr);
    }

    static void prepareProdAr(int ar[]) {
        int prod[] = new int[ar.length];

        int temp = 1;
        for (int i = 0; i < ar.length; i++) {
            prod[i] = temp;
            temp = temp * ar[i];
        }

        temp = 1;

        for (int i = ar.length - 1; i >= 0; i--) {
            prod[i] = temp * prod[i];
            temp = ar[i] * temp;
        }

        for (int i = 0; i < prod.length; i++) {
            System.out.print(prod[i] + " ");
        }
    }
}
