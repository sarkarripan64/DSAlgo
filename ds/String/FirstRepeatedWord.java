package ds.String;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sarkarri on 4/4/17.
 */
public class FirstRepeatedWord {
    public static void main(String[] args) {
        String s = "House Dog House Dog Dog Dog Dog";
        //System.out.println(findFirstRepeatedWord(s.split(",")));
        //",|\\.|\\:|;|-|"
        String[] tokens = s.split("\\s|,|\\.|\\:|;|-");
//        for(String st:tokens){
//            System.out.println(st);
//        }
        System.out.println(findFirstRepeatedWord(tokens));
    }

    static String findFirstRepeatedWord(String ar[]) {
        Map<String, Integer> occurrences = new HashMap<String, Integer>();

        for (String word : ar) {
            //System.out.println(word);
            if (!occurrences.containsKey(word)) {
                occurrences.put(word, 1);
            } else {

                return word;
            }

        }

        return null;
    }
}
