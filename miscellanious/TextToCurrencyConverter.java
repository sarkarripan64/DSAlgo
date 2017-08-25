package miscellanious;

import java.util.Random;

/**
 * Created by sarkarri on 6/18/17.
 */
public class TextToCurrencyConverter {
    public static final String[] units = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"
            , "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    public static final String[] TENS = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    private static final StringBuilder sb = new StringBuilder();
    private static final String MINUS = "minus";
    private static final String HUNDRED = " hundred";
    private static final String THOUSAND = " thousand";
    private static final String MILLION = " million";
    private static final String BILLION = " billion";

    public static void main(String[] args) {
        final Random generator = new Random();

        int n;
        for (int i = 0; i < 20; i++) {
            n = generator.nextInt(Integer.MAX_VALUE);

            System.out.printf("%10d = '%s'%n", n, translate(n));
        }

        n = 1000;
        System.out.printf("%10d = '%s'%n", n, translate(n));

        n = 2000;
        System.out.printf("%10d = '%s'%n", n, translate(n));

        n = 10000;
        System.out.printf("%10d = '%s'%n", n, translate(n));

        n = 11000;
        System.out.printf("%10d = '%s'%n", n, translate(n));

        n = 999999999;
        System.out.printf("%10d = '%s'%n", n, translate(n));

        n = Integer.MAX_VALUE;
        System.out.printf("%10d = '%s'%n", n, translate(n));
    }

    public static String translate(int amount) {
        if (amount < 0) {
            return MINUS + translate(-amount);
        }
        if (amount < 20) {
            return units[amount];
        }
        if (amount < 100) {
            return TENS[amount / 10] + ((amount % 10) != 0 ? " " : "") + translate(amount % 10);
        }

        if (amount < 1000) {
            return units[amount / 100] + HUNDRED + ((amount % 100) != 0 ? " " : "") + translate(amount % 100);
        }

        if (amount < 1000000) {
            return translate(amount / 1000) + THOUSAND + ((amount % 1000) != 0 ? " " : "") + translate(amount % 1000);
        }
        if (amount < 1000000000) {
            return translate(amount / 1000000) + MILLION + ((amount % 1000000) != 0 ? " " : "") + translate(amount % 1000000);
        }

        return translate(amount / 1000000000) + BILLION + ((amount % 1000000000) != 0 ? " " : "") + translate(amount % 1000000000);
    }
}
