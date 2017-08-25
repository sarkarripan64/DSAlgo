package ds.recursions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarkarri on 11/24/16.
 */
public class Factorial {
    public static void main(String[] args) {
        System.out.println("factorial recursive " + factRecursive(24));
        System.out.println("factorial iterative " + factIterative(24));

    }

    static int factRecursive(int n) {
        if (n == 1)
            return 1;
        return n * factRecursive(n - 1);
    }

    static int factIterative(int n) {
        int result = 1;
        for (int i = n; i > 1; i--) {
            result = result * i;
        }
        return result;
    }


    static int multiplicationOfBigNumbers(int a, int b) {
        String op1 = String.valueOf(a);
        String op2 = String.valueOf(b);

        int index1 = op1.length();
        int index2 = op2.length();
        String result = "";
        int carry = 0;
        List<String> partialList = new ArrayList<>();

        /*
        2234
          78
     ===============
        9872
       8638-
     ==========
       96252

        * */

        for (int i = index1 - 1; i >= 1; i--) {
            String internalRes = "";
            for (int j = index2 - 1; j >= 1; j--) {
                int multiOp = (Integer.parseInt(String.valueOf(op2.charAt(i))) * Integer.parseInt(String.valueOf(op1.charAt(j)))); //32
                multiOp = multiOp + carry; //32//27//18//9
                carry = multiOp / 10;//3//2//1//0
                internalRes = internalRes + multiOp % 10;//2//7//8//9
            }
            if (carry > 0) {
                internalRes = internalRes + carry;
            }
            carry = 0;
            result = new StringBuffer(internalRes).reverse().toString();
            partialList.add(result);
        }

        for (int i = 1; i < partialList.size(); i++) {
            String cont = partialList.get(i);
            switch (i){
                case 1:
                    cont = cont + "0";
                case 2:
                    cont = cont + "00";
            }

        }
        //partialList.stream().filter(e-> e.)

        return 0;
    }
}
