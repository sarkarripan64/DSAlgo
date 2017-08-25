package ds.String;

/**
 * Created by sarkarri on 3/27/17.
 */
public class RemoveAdjucentDuplicates {
    public static void main(String[] args) {
        String s = "azxxzy";
        //s = "geeksforgeeg";
        System.out.println(remove(s));
    }

    static String remove(String s) {
        char res[] = new char[s.length()];
        int j = 0;
        res[j] = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != res[j]) {
                res[++j] = s.charAt(i);
            } else {
                res[j--] = '\u0000';
            }
        }

        String result = String.valueOf(res);
        return result.substring(0,j+1);
    }
}
