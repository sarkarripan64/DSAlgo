package lamdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sarkarri on 5/31/17.
 */
public class SampleLambda {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("abc", "aef", "geh", "aaa");
        System.out.println(list);
        Collections.sort(list, (a, b) -> {
            return a.compareTo(b);
        });
        System.out.println(list);
        Converter<Integer, String> converter = (from) -> Integer.valueOf(from);
        Integer i = converter.convert("123");
        System.out.println(i);

        Converter<String, Integer> converter1 = from -> String.valueOf(from);
        System.out.println(converter1.convert(123));
        converter.defMethod();
        //////////////////////////
        MyClass mc = new MyClass();
        mc.defMethod();

        List<String> res = list.stream().filter(s->s.startsWith("a")).collect(Collectors.toList());
        System.out.println(res);
        System.out.println(list);
    }
}


class MyClass implements Converter {

    @Override
    public Object convert(Object from) {
        return null;
    }

//    @Override
//    public void defMethod() {
//        System.out.println("its my default");
//    }
}