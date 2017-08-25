package ds.array;

/**
 * Created by sarkarri on 1/6/17.
 */
public class LeadersInArray {
    public static void main(String[] args) {
        int arr[] = new int[]{16, 17, 4, 3, 5, 2};
        leaders(arr);
    }

    static void leaders(int ar[]) {
        int rightMax = ar[ar.length - 1];
        for (int i = ar.length - 2; i >= 0; i--) {
            if (ar[i] > rightMax) {
                System.out.println(ar[i]);
                rightMax = ar[i];
            }
        }
    }
}
