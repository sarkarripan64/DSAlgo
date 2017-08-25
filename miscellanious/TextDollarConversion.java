package miscellanious;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Scanner;

/**
 * Created by sarkarri on 6/15/17.
 */
public class TextDollarConversion {
    private static Reader input;
    private static PrintWriter output;
    private static Scanner sc;
    private static String result = "";
    private static final String[] numbers = {"One", "Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine"};
    private static final String[] weird = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
            "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] betweens = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
            "Eighty", "Ninety"};
    private static final String hundred = "Hundred";
    private static final String thousand = "Thousand";
    private static final String million = "Million";
    private static String hund = "";
    private static String thous = "";
    private static String mill = "";

    /** main method for class. */
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length >= 2) {
            System.out.println("Invalid length.");
            System.exit(0);
        }
        try {
            if (args.length > 0)
                input = new FileReader(new File(args[0]));
            else
                input = new FileReader("/home/sarkarri/Desktop/textdollarip");
            output = new PrintWriter(System.out);
            sc = new Scanner(input);
            wordify();
            output.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Invalid input file(s).");
            System.exit(0);
            return;
        }
    }

    /** method that changes numeric value representations into word representations. */
    public static void wordify() {
        while (sc.hasNextLine()) {
            String str = sc.nextLine().replaceAll("\\s+","");
            int len = str.length();
            if (len > 6) {
                hund = str.substring(len - 3);
                thous = str.substring(len - 6, len - 3);
                mill = str.substring(0, len - 6);
                millionify(mill);
                thousandify(thous);
                hundredify(hund);
            } else if (len > 3) {
                hund = str.substring(len - 3);
                thous = str.substring(0, len - 3);
                thousandify(thous);
                hundredify(hund);
            } else {
                hund = str;
                hundredify(hund);
            }
            result += "Dollars\n";
        }
        output.print(result);
    }

    /** method that changes array into hundred word form and adds to result. */
    public static void hundredify(String nums) {
        boolean b = true;
        if (nums.length() == 3) {
            int val = Integer.parseInt(String.valueOf(nums.charAt(0)));
            if (val != 0) {
                result = result + numbers[val - 1] + hundred;
            }
            nums = nums.substring(1);
        }
        if (nums.length() == 2) {
            int val = Integer.parseInt(String.valueOf(nums.charAt(0)));
            if (val == 1) {
                b = false;
                int ones = Integer.parseInt(String.valueOf(nums.charAt(1)));
                result += weird[ones];
            } else if (val > 1) {
                result += betweens[val - 2];
            }
            nums = nums.substring(1);
        }
        if (b) {
            int val = Integer.parseInt(String.valueOf(nums.charAt(0)));
            if (val != 0) {
                result += numbers[val - 1];
            }
        }
    }

    public static void thousandify(String nums) {
        hundredify(nums);
        result += thousand;
    }

    public static void millionify(String nums) {
        hundredify(nums);
        result += million;
    }
}
