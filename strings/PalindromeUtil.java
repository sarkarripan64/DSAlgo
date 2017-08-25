package strings;

/**
 * Created by sarkarri on 5/24/17.
 */
public class PalindromeUtil {
    public static void main(String[] args) {
        String s = "Madam, I'm Adam.";
        s = "";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String str) {
        // implement code here ...
        if (str == null) {
            return false;
        }
        str = str.replaceAll("[^a-zA-Z0-9]+", "");
        if (str.isEmpty()) {
            return false;
        }
        int n = str.length();
        int start = 0;
        int end = n - 1;
        str = str.toLowerCase();
        while (start < end) {
            if (str.charAt(start) != str.charAt(end))
                return false;

            start++;
            end--;
        }

        return true;
    }
}
