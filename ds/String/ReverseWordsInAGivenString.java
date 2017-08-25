package ds.String;

/**
 * Created by sarkarri on 3/15/17.
 */
public class ReverseWordsInAGivenString {
    public static void main(String[] args) {
        String s = "i like this program very much";
        System.out.println(reverseWords(s));
    }

    static String reverseWords(String s) {
        String[] ar = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = ar.length - 1; i >= 0; i--) {
            sb.append(ar[i]).append(" ");
        }

        return sb.toString();
    }
}
