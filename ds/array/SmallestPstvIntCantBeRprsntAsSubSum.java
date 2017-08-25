package ds.array;

/**
 * Created by sarkarri on 2/22/17.
 */
public class SmallestPstvIntCantBeRprsntAsSubSum {
    public static void main(String[] args) {
        int arr[] = {1, 3, 6, 10, 11, 15};
//        int arr[] = {1, 1, 1, 1};
//        int arr[] = {1, 1, 3, 4};
//        int arr[] = {1, 2, 5, 10, 20, 40};;
//        int arr[] = {1, 2, 3, 4, 5, 6};

        System.out.println(findSmallest(arr));
    }

    static int findSmallest(int ar[]) {
        int res = 1;
        for (int i = 0; i < ar.length && ar[i] <= res; i++) {
            res += ar[i];
        }

        return res;
    }
}
