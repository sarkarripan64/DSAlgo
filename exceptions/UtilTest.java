package exceptions;

import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sarkarri on 5/18/17.
 */
public class UtilTest {
    public static void main(String[] args) {
        List<String> results;
        Date date = new Date();
        System.out.println(date);
        Date dt = new Date(date.getTime());
        System.out.println(dt.equals(date));

    }

    Lock l = new ReentrantLock();
}
