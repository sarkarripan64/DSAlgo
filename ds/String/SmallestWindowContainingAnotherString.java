package ds.String;

/**
 * Created by sarkarri on 3/16/17.
 */
public class SmallestWindowContainingAnotherString {
    public static void main(String[] args) {
        String str = "this is a test string";
        String pattern = "tist";

        findAnotherWindow(str, pattern);
    }

    static void findAnotherWindow(String str, String key) {
        //char [] patHolder = key.toCharArray();
        int[] patHolder = new int[256];
        int[] strHolder = new int[256];
        for (int i = 0; i < key.length(); i++) {
            patHolder[key.charAt(i)]++;
        }

        int start = 0, min_length = Integer.MAX_VALUE, start_index = -1;
        int kLength = key.length();
        int length = 0;
        for (int j = 0; j < str.length(); j++) {
            strHolder[str.charAt(j)]++;

            if (patHolder[str.charAt(j)] > 0 && strHolder[str.charAt(j)] <= patHolder[str.charAt(j)]) {
                length++;
            }

            if (kLength == length) {
                while ((strHolder[str.charAt(start)] > patHolder[str.charAt(start)]) || (patHolder[str.charAt(start)] == 0)) {
                    if (strHolder[str.charAt(start)] > patHolder[str.charAt(start)]) {
                        strHolder[str.charAt(start)]--;
                    }
                    start++;
                }

                int window = j - start + 1;
                if (window < min_length) {
                    min_length = window;
                    start_index = start;
                }
            }
        }

        if (start_index == -1) {
            System.out.println("no window found");
        } else {
            System.out.println("min window is : " + str.substring(start_index,min_length));
        }
    }
}
