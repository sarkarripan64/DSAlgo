package ds.array;

/**
 * Created by sarkarri on 1/10/17.
 */
public class EquilibriumIndex {
    public static void main(String[] args) {
        int arr[] = {-7, 1, 5, 2, -4, 3, 0};
        findEquilibriumIndex(arr);
        findEquilibriumIndex2(arr);
    }

    static void findEquilibriumIndex(int ar[]) {
        int sum = ar[0];
        for (int i = 1; i < ar.length; i++) {
            sum = sum + ar[i];
        }
        int temp = 0;
        for (int j = 0; j < ar.length; j++) {
            temp = temp + ar[j];
            if ((temp - ar[j]) == (sum - temp)) {
                System.out.println(j + " is equi");
            }
        }
    }

    static void findEquilibriumIndex2(int ar[]) {
        int sum = ar[0];
        for (int i = 1; i < ar.length; i++) {
            sum = sum + ar[i];
        }

        int leftSum = 0;
        for (int j = 0; j < ar.length; j++) {
            sum = sum - ar[j];
            if (leftSum == sum) {
                System.out.println(j + " is equi");
            }

            leftSum = leftSum + ar[j];
        }
    }
}
