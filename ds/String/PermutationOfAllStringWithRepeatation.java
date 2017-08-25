package ds.String;

/**
 * Created by sarkarri on 3/17/17.
 */
public class PermutationOfAllStringWithRepeatation {
    static int count = 0;

    public static void main(String[] args) {
        String s = "ABC";
        permutations("", s);
    }

    static void permutations(String perm, String str) {
        if (perm.length() == str.length()) {
            count++;
            System.out.println(perm + " -count->" + count);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            permutations(perm + str.charAt(i), str);
        }
    }
}
