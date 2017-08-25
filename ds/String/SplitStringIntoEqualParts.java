package ds.String;

/**
 * Created by sarkarri on 3/13/17.
 */
public class SplitStringIntoEqualParts {
    public static void main(String[] args) {
        String s = "ABCDEFGHIJKLMNO";
        split(s, 3);
    }

    static void split(String str, int n) {
        int partSize = str.length() / n;
        while (str.length() - partSize > 0) {
            String s = str.substring(0, partSize-1);
            System.out.print(s + " ");
            str = str.substring(partSize-1);
        }
        if (str.length() > 0) {
            System.out.print(str);
        }
    }
}
