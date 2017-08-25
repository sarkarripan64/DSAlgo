package exceptions;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by sarkarri on 6/6/17.
 */
public class Example extends Thread {
    @Override
    public void run() {
        System.out.println("global");
    }

    public static void main(String[] args) {
        Example ex = new Example() {
            @Override
            public void run() {
                System.out.println("inner");
            }
        };
        ex.start();
    }
}
