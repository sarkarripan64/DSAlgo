package ds.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sarkarri on 6/18/17.
 */
public class StringModdi {
    public static void main(String[] args) throws IOException {
        //System.out.println(modd("12463596789"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            System.out.println(modd(s));
        }
    }

    static String modd(String s) {
        int n = s.length();

        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        for (int i = 1; i < n; i++) {
            int a = s.charAt(i);
            System.out.println("aa"+a);
            int b = s.charAt(i - 1);

            if (even(a) && even(b)) {
                sb.append("*");
            } else if (odd(a) && odd(b)) {
                sb.append("-");
            }
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }

    static boolean odd(int n) {
        return n % 2 != 0;
    }

    static boolean even(int n) {
        return n % 2 == 0;
    }
}
