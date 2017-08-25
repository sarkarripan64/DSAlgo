package miscellanious;

/**
 * Created by sarkarri on 6/6/17.
 */
public class Parent {
    static {
        System.out.println("static parent");
    }

    public static void main(String[] args) {
        Parent p;
    }
}

class Child extends Parent {
    static {
        System.out.println("static child");
    }
}
