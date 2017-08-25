package ds.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sarkarri on 6/18/17.
 */
public class substr {
    public static void main(String[] args) throws IOException {
        String s1 = "cornfield";
        String s2 = "outdield";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            String[] arr = s.split(",");
            System.out.println(sbb(arr[0], arr[1]));
        }

        StringBuffer ss = new StringBuffer();
    }

    static String sbb(String s1, String s2) {


        int n = s1.length();
        int m = s2.length();

        int min = m > n ? n : m;
        int i = n - 1;
        int j = m - 1;
        while (i >= 0 && j >= 0) {
            if (s1.charAt(i) != s2.charAt(j))
                break;

            i--;
            j--;
        }

        if (i == n - 1 || j == m - 1) {
            return null;
        }
        return s2.substring(j + 1);
    }
}
