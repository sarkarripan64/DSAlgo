package samples;

/**
 * Created by sarkarri on 11/17/16.
 */
public class DefaultMethodInterface extends SuperBhai implements LoggingOne, LoggingTwo {
    public static void main(String[] args) {
        DefaultMethodInterface dmi = new DefaultMethodInterface();
        dmi.log();
    }


    @Override
    public void log() {
        System.out.println("conflict resolved");
        LoggingOne.display("static test");
    }

    @Override
    public void methodOne() {
        System.out.println("method 11111 ");
    }


    @Override
    public void methosTwo() {
        System.out.println("method 2222 ");
    }
}

@FunctionalInterface
interface LoggingOne {
    default void log() {
        display("inside one");
        System.out.println("logging One");
    }

    void methodOne();

    static void display(String msg) {
        System.out.println("display " + msg);
    }
}

@FunctionalInterface
interface LoggingTwo {
    default void log() {
        System.out.printf("logging two");
    }

    void methosTwo();
}

class SuperBhai {
    void log() {
        System.out.println("inside SuperBhai");
    }
}

