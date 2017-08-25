package streaming;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * Created by sarkarri on 3/10/17.
 */
public class GetSum {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList();
        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println(stats.getSum());
    }
}
