package ds.String;

/**
 * Created by sarkarri on 3/17/17.
 */
public class PrintAllInterleavingStringsOfTwoString {
    public static void main(String[] args) {
        String s1 = "AB";
        String s2 = "XY";
        printAllInterleavingStrings(s1, s2, "");
    }

    static void printAllInterleavingStrings(String str1, String str2, String interleavingStr) {
        if (str1 == null) {
            System.out.println(str2);
            return;
        }

        if (str2 == null) {
            System.out.println(str1);
            return;
        }

        if (str1.length() == 0 && str2.length() == 0) {
            System.out.println(interleavingStr);
            return;
        }

        if (str1.length() != 0) {
            printAllInterleavingStrings(str1.substring(1), str2, interleavingStr + str1.charAt(0));
        }

        if (str2.length() != 0) {
            printAllInterleavingStrings(str1, str2.substring(1), interleavingStr + str2.charAt(0));
        }

    }
}
