package ds.String;

/**
 * Created by sarkarri on 3/31/17.
 */
public class PrintAllSubstrings {
    public static void main(String[] args) {
        String s = "ABC";
        //System.out.println(s.substring(0,3));
        print(s);
    }

    static void print(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                System.out.println(s.substring(j, i+1));
            }
        }
    }
}
