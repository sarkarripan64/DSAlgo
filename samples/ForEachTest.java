package samples;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by sarkarri on 11/17/16.
 */
public class ForEachTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("we are at "+integer);
            }
        });

    }
}
