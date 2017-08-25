package ds.array;

/**
 * Created by sarkarri on 2/24/17.
 */
public class NumberOfSubStartsnEndsWith1 {
    public static void main(String[] args) {
        String s = "001001011";
        System.out.println(countNumber(s));
    }

    static int countNumber(String s) {
        char[] bin = s.toCharArray();
        int noOf1s = 0;
        for (char c : bin) {
            if (c == '1') {
                noOf1s++;
            }
        }
        //combination of all 1s taking 2
        return (noOf1s * (noOf1s - 1)) / 2;
    }
}
