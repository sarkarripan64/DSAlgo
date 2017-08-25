package ds.stack;

/**
 * Created by sarkarri on 4/12/17.
 */
public class CountMaxDepth {
    public static void main(String[] args) {
        //String s = "( a(b) (c) (d(e(f)g)h) I (j(k)l)m)";
        String s = "( p((q)) ((s)t) )";
        s = "";
        System.out.println(countMaxDepth(s));
    }

    static int countMaxDepth(String s) {
        int count = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
                if (count > max) {
                    max = count;
                }
            } else if (s.charAt(i) == ')') {
                if (count > 0) {
                    count--;
                } else
                    return -1;
            }
        }
        if (count != 0)
            return -1;

        return max;
    }
}
