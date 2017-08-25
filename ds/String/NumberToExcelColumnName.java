package ds.String;

/**
 * Created by sarkarri on 4/4/17.
 */
public class NumberToExcelColumnName {
    public static void main(String[] args) {
        int n = 51;
        System.out.println(mapNumberToColumn(n));
    }

    static String mapNumberToColumn(int colNum) {
       /* String res = "";
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        while (n > 0) {
            int rem = n % 26;
            res = (rem == 0 ? 'Z' : s.charAt(rem > 0 ? rem - 1 : 0)) + res;
            n = (n / 26) - 1;
        }*/

        int Base = 26;
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String colName = "";

        while (colNum > 0) {
            int position = colNum % Base;
            colName = (position == 0 ? 'Z' : chars.charAt(position > 0 ? position - 1 : 0)) + colName;
            colNum = (colNum - 1) / Base;
        }
        return colName;

    }
}
