package ds.String;

/**
 * Created by sarkarri on 3/27/17.
 */
public class Remove_b_And_ac {
    public static void main(String[] args) {
        String s = "ababaac";
        //s = "ad";
        //s = "acbac";
        //s = "aaac";
        //s = "react";
        //s = "aa";
        //s = "ababaac";
        s = "abc";

        System.out.println(remove_b_and_acFromString(s));
    }

    static String remove_b_and_acFromString(String s) {
        int state = 0;
        char[] res = new char[s.length()];
        int k = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                if (state == 2) {
                    res[k++] = s.charAt(i);
                } else {
                    state = 2;
                }
            } else if (s.charAt(i) == 'c' && state == 2) {
                state = 1;
            } else if (s.charAt(i) != 'b') {
                res[k++] = s.charAt(i);
            }
        }
        if (state == 2) {
            res[k++] = 'a';
        }
        return String.valueOf(res);
    }
}
