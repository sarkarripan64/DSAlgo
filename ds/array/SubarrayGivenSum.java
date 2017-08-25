package ds.array;

/**
 * Created by sarkarri on 2/2/17.
 */
public class SubarrayGivenSum {
    public static void main(String[] args) {
        int arr[] = {1, 2, 10, 3, 10, 5};
        //findIndexes(arr, 15);
        findIndexesEfficient(arr, 15);
    }

    static void findIndexes(int ar[], int givenSum) {
        for (int i = 0; i < ar.length - 1; i++) {
            int sum = ar[i];
            for (int j = i + 1; j < ar.length; j++) {
                if (sum == givenSum) {
                    System.out.println(i + " to " + (j - 1));
                    //break;
                } else if (sum > givenSum) {
                    //break;
                }

            }
        }
    }

    static int findIndexesEfficient(int arr[], int sum) {
        int curr_sum = arr[0], start = 0, i;

        // Pick a starting point
        for (i = 1; i <= arr.length; i++)
        {
            // If curr_sum exceeds the sum, then remove the starting elements
            while (curr_sum > sum && start < i-1)
            {
                curr_sum = curr_sum - arr[start];
                start++;
            }

            // If curr_sum becomes equal to sum, then return true
            if (curr_sum == sum)
            {
                int p = i-1;
                System.out.println("Sum found between indexes " + start
                        + " and " + p);
                //return 1;
            }

            // Add this element to curr_sum
            if (i < arr.length)
                curr_sum = curr_sum + arr[i];

        }

        //System.out.println("No subarray found");
        return 0;
    }
}
