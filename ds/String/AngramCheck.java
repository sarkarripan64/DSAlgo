package ds.String;

/**
 * Created by sarkarri on 3/18/17.
 */
public class AngramCheck {
    public static void main(String[] args) {
        String s1 = "geeksforgeeks";
        String s2 = "forgeeksgeeks";
        System.out.println(isAnagram(s1, s2));
    }

    static boolean isAnagram(String s1, String s2) {
        if (s1 == s2)
            return true;
        if (s1 == null || s2 == null || s1.length() != s2.length())
            return false;
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        int count[] = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 97]++;
            count[s2.charAt(i) - 97]--;
        }

        for (int j = 0; j < count.length; j++) {
            if (count[j] != 0)
                return false;
        }
        return true;
    }
}
