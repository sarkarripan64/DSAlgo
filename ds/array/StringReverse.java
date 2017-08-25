package ds.array;

/**
 * Created by sarkarri on 1/6/17.
 */
public class StringReverse {
    public static void main(String[] args) {
        reverse("abcdefgh");
    }

    static void reverse(String s) {
        int begin = 0, end = s.length() - 1;
        char[] sar = s.toCharArray();
        while (begin < end) {
            char temp = sar[begin];
            sar[begin] = sar[end];
            sar[end] = temp;
            begin++;
            end--;
        }

        print(sar);
    }

    static void print(char[] ar) {
        for (char c : ar) {
            System.out.printf(c + "");
        }
    }
}
