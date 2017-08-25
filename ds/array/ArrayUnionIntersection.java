package ds.array;

/**
 * Created by sarkarri on 1/9/17.
 */
public class ArrayUnionIntersection {
    public static void main(String[] args) {
        int arr1[] = {1, 3, 4, 5, 7};
        int arr2[] = {2, 3, 5, 6};
        union(arr1, arr2);
        System.out.println("");
        intersection(arr1, arr2);
    }

    static void union(int[] ar1, int[] ar2) {
        int i = 0, j = 0;

        while (i < ar1.length && j < ar2.length) {
            if (ar1[i] == ar2[j]) {
                System.out.print(ar1[i] + " ");
                i++;
                j++;
            } else if (ar1[i] < ar2[j]) {
                System.out.print(ar1[i] + " ");
                i++;
            } else {
                System.out.printf(ar2[j] + " ");
                j++;
            }

        }

        while (i < ar1.length) {
            System.out.printf(ar1[i] + " ");
            i++;
        }

        while (j < ar2.length) {
            System.out.printf(ar2[j] + " ");
        }
    }

    static void intersection(int ar1[], int ar2[]) {
        int i = 0, j = 0;
        while (i < ar1.length && j < ar2.length) {
            if (ar1[i] == ar2[j]) {
                System.out.print(ar1[i] + " ");
                i++;
                j++;
            } else if (ar1[i] < ar2[j]) {
                //System.out.printArray(ar1[i] + " ");
                i++;
            } else {
                //System.out.printf(ar2[j] + " ");
                j++;
            }

        }
    }
}
