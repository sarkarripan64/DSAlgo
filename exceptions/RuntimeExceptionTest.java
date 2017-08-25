package exceptions;

/**
 * Created by sarkarri on 3/16/17.
 */
public class RuntimeExceptionTest {
    public static void main(String[] args) {
//        try {
//            new RuntimeExceptionTest().willThrow();
//        } catch (RuntimeException e) {
//            System.out.println("catching run time exception");
//        } catch (Exception ex) {
//            System.out.println("generic exception");
//        }

        try {
            throw new NullPointerException();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println();
            e.printStackTrace();
        }
    }

    public void willThrow() {
        throw new RuntimeException("its a runt ime exception");
    }
}
