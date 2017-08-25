package miscellanious;

import java.util.stream.IntStream;

/**
 * Created by sarkarri on 6/15/17.
 */
public class Mainn {
    public static void main(String[] args) {
        IntStream.range(2, 11).map(i -> i * i).forEach(System.out::println);
    }
}
