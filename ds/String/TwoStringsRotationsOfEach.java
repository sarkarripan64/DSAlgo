package ds.String;

/**
 * Created by sarkarri on 3/13/17.
 */
public class TwoStringsRotationsOfEach {
    public static void main(String[] args) {
        String s1 = "ABCD";
        String s2 = "CDAB";
        String s3 = "ABCD";
        String s4 = "ACBD";
        System.out.println(check(s1, s2));
        System.out.println(check(s3, s4));
    }

    static boolean check(String s1, String s2) {
        return (s1.length() == s2.length()) && ((s1 + s1).indexOf(s2) != -1);
    }
}
