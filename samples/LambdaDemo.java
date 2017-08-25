package samples;

/**
 * Created by sarkarri on 11/18/16.
 */
public class LambdaDemo {

    public static void main(String[] args) {
        System.out.println("celsius to fahrenheit == " + convert(input -> (input - 32) * 5 / 9, 98.6));
        System.out.println("km to miles == " + convert(input -> input / 1.609344, 6));
    }

    static double convert(Converter converter, double input) {
        return converter.convert(input);
    }
}

@FunctionalInterface
interface Converter {
    double convert(double input);
}
