package ds.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by sarkarri on 2/15/17.
 */
public class ArrangeToBiggestNumber {
    public static void main(String[] args) {
        int ar[] = {54, 546, 548, 60};
        int arr[] = {1, 34, 3, 98, 9, 76, 45, 4};
        List<String> list = new ArrayList<>();
//        list.add("54");
//        list.add("546");
//        list.add("548");
//        list.add("60");

        list.add("1");
        list.add("34");
        list.add("3");
        list.add("98");
        list.add("9");
        list.add("76");
        list.add("45");
        list.add("4");

        arrange(list);

    }

    static void arrange(List<String> list) {
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                String xy = x + y;
                String yx = y + x;
                return yx.compareTo(xy);
            }
        });

        StringBuffer sb = new StringBuffer();
        for (String s : list) {
            sb.append(s);
        }

        System.out.println(sb.toString());
    }


}
