package ds.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sarkarri on 6/7/17.
 */
public class Panagram {
    public static void main(String[] args) {
       
    }

    static String isPangram(String[] strings) {
        String str;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            str = strings[i];
            str = str.toLowerCase().replaceAll(" ", "");

            char[] chars = str.toCharArray();
            final Set set = new HashSet();

            for (char c : chars) {
                set.add(c);
            }

            System.out.println(set.size());
            if (set.size() == 26)
                sb.append("1");
            else
                sb.append("0");
        }
        return sb.toString();
    }

}

