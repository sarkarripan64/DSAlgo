package threads;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by sarkarri on 6/2/17.
 */
public class AtomicInt {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(123);
        getIn(atomicInteger);
        System.out.println(atomicInteger.get());
    }

    static void getIn(AtomicInteger atomicInteger) {
        try {
            atomicInteger.getAndAdd(22);
            throw new Exception("asadws");
        } catch (Exception e) {

        }

    }
}
