package autoboxing;

import java.io.ByteArrayInputStream;

/**
 * Created by sarkarri on 6/13/17.
 */
public class Boxing {
    private static final int TAG_TOPLEVEL = 0xFFFF;

    public static void main(String[] args) {

//        int i = 1234567811;
//        short s = (short) i;
//        System.out.println(s);
//        Integer ii = 0;
//        new Boxing().hello("abc", ii);
//        System.out.println(TAG_TOPLEVEL);
//        final int CONSTRUCTED_BIT = 0x20;
//        System.out.println(CONSTRUCTED_BIT);
//        System.out.println(Integer.parseInt("0003"));
        String ss = "_bcd";
        byte[] ar = ss.getBytes();
//        System.out.println(ar.length);
//        int temp = ar[0] & 0xff;
//        System.out.println(ss.toUpperCase());
//        System.out.println("temp "+temp);
//        System.out.println(0xff);
//        System.out.println(0x80);
//        System.out.println('a' & 255);
        System.out.println(0xff);
        System.out.println(0x80);
        System.out.println(0x81);
        System.out.println(0x7f);
        System.out.println(0xFF);
        ByteArrayInputStream stream = new ByteArrayInputStream(ar);
        System.out.println(stream.available());
    }

    private void hello(String s, Integer i) {
        System.out.println("string " + (++i));
    }

    //private void hello(Object o) {
//        System.out.println("object");
//    }
}
