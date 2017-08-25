package exceptions;

/**
 * Created by sarkarri on 6/6/17.
 */
public class Foo {
    Foo() {
        System.out.println("foo");
    }

    public static void main(String[] args) {
        new Foo().makeBar();
    }

    void makeBar() {
        (new Bar() {
        }).go();
    }

    class Bar {
        Bar() {
            System.out.println("bar");
        }

        public void go() {
            System.out.println("go");
        }
    }
}
