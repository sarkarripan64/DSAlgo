package ds.String;

/**
 * Created by sarkarri on 3/13/17.
 */
public class StringReverseUsingRecursion {
    public static void main(String[] args) {
        String s = "Ripan";
        System.out.println(reverse1("", s, s.length() - 1));
    }

    static String reverse1(String s, String str, int index) {
        if (index < 0) {
            return s;
        }

        return s + str.charAt(index) + reverse1(s, str, index - 1);
    }

//    static void reverse2(String s, int l, int r) {
//        if (l < r) {
//            char temp = s.charAt(l);
//            s = s.replace(temp, s.charAt(r));
//            s = s.replace(s.charAt(r), temp);
//            reverse2(s, l + 1, r - 1);
//        }
//    }
}
