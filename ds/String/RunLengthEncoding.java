package ds.String;

/**
 * Created by sarkarri on 3/15/17.
 */
public class RunLengthEncoding {
    public static void main(String[] args) {
        String s = "wwwwaaadexxxxxx";
        System.out.println(encodeWithLength(s));
    }

    static String encodeWithLength(String s) {
        char[] ar = s.toCharArray();
        char c = ar[0];
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < ar.length; i++) {
            if (c == ar[i]) {
                count++;
            } else {
                sb.append(c).append(count);
                c = ar[i];
                count = 1;
            }
            if (i == ar.length - 1) {
                sb.append(c).append(count);
            }
        }

        return sb.toString();
    }
}
