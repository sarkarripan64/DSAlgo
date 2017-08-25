package ds.String;

/**
 * Created by sarkarri on 3/15/17.
 */
public class PrintListContainingAGivenWord {
    public static void main(String[] args) {
        String key = "sun";
        String list[] = {"geeksforgeeks", "unsorted", "sunday", "just", "sss"};
        printList(list, key);
    }

    static void printList(String[] ar, String key) {
        int[] charHolder = new int[256];
        char keyCharArr[] = key.toCharArray();
        for (int i = 0; i < keyCharArr.length; i++) {
            charHolder[keyCharArr[i]]++;
        }

        int keyLength = key.length();

        for (String s : ar) {
            int length = 0;
            for (int j = 0; j < s.length(); j++) {
                if (charHolder[s.charAt(j)] > 0) {
                    length++;
                    charHolder[s.charAt(j)]--;
                    if (length == keyLength) {
                        System.out.println(s);
                        length = 0;
                        break;
                    }
                }
            }

            for (int i = 0; i < keyCharArr.length; i++) {
                charHolder[keyCharArr[i]]++;
            }
        }
    }
}
