package samples;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * Created by sarkarri on 11/17/16.
 */
public class LambdaExpressions {
    public static void main(String[] args) {
        System.out.println("isPrime " + isPrime(37));

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        System.out.println("sum of all " + sumWithCondition(list, n -> true));
        System.out.println("sum of all even " + sumWithCondition(list, i -> i % 2 == 0));
        System.out.println("numbers greater than 5 " + sumWithCondition(list, i -> i > 5));
    }

    private static boolean isPrime(int number) {
        return number > 1 && IntStream.range(2, number / 2).noneMatch(index -> number % index == 0);
    }

    private static int sumWithCondition(List<Integer> list, Predicate<Integer> predicate) {
        return list.parallelStream().filter(predicate).mapToInt(i -> i).sum();
    }

}
