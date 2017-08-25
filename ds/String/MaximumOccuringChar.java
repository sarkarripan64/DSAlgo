package ds.String;

/**
 * Created by sarkarri on 3/11/17.
 */
public class MaximumOccuringChar {
    public static void main(String[] args) {
        String s = "dabcabcabcdddd";
        System.out.println(findMaxOccurringChar(s));
    }

    static char findMaxOccurringChar(String s) {
        char[] arC = s.toCharArray();
        int[] charHolder = new int[256];
        for (int i = 0; i < arC.length; i++) {
            charHolder[arC[i]]++;
        }

        int maxOccurrence = -1;
        char c = ' ';
        for (int j = 0; j < arC.length; j++) {
            if (charHolder[arC[j]] > maxOccurrence) {
                maxOccurrence = charHolder[arC[j]];
                c = arC[j];
            }
        }

        return c;
    }
}
