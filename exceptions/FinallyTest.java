package exceptions;

/**
 * Created by sarkarri on 4/12/17.
 */
public class FinallyTest {
    public static void main(String[] args) throws Exception {
        try {
            System.out.print(1);
            q();
        } catch (Exception i) {
            throw new MyExc2();
        } finally {
            System.out.print(2);
            throw new MyExc1();
        }
    }

    static void q() throws Exception {
        try {
            throw new MyExc1();
        } catch (Exception y) {
            //System.out.print(4);
            throw new Exception();
        } finally {
            System.out.print(3);
            throw new Exception();
        }
    }

}


class MyExc1 extends Exception {
}

class MyExc2 extends Exception {
}

class MyExc3 extends MyExc2 {
}
