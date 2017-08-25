package exceptions;

/**
 * Created by sarkarri on 6/6/17.
 */
public class Test {


    public static void main(String[] args) {
//        String x1 = "XYZ";
//        String x2 = new String("XYZ");
//        System.out.println(x1 == x2);
//        System.out.println(x1.equals(x2));
//        x2.intern();
//        System.out.println(x1 == x2);
//        System.out.println(x1.equals(x2));
        //System.out.println(swich(4));
        Boolean b1 = new Boolean("TruE");
        Boolean b2 = new Boolean("true");
        System.out.println(b1.equals(b2));
    }

    public static void main(int[] args) {
        //System.out.println("intttt");

    }

    static int swich(int x) {
        int j = 1;
        switch (x) {
            case 1:
                j++;
            case 2:
                j++;
            case 3:
                j++;
            case 4:
                j++;
            case 5:
                j++;
            default:
                j++;
        }
        return (j+x);
    }


    int check() {
        try {
            System.out.println("try");
            return 1;
        } catch (Exception e) {
            System.out.println("ctahc ");
            return 1;
        } finally {
            System.out.println("finally");
            return 3;
        }
    }
}


