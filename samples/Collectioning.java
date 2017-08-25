package samples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sarkarri on 2/6/17.
 */
public class Collectioning {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(1);
        l.add(1);
        l.add(1);

//        Iterator<Integer> it = l.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//            it.remove();
//        }
//
//        HashMap<String, String> loans = new HashMap<String, String>();
//        loans.put("home loan", "citibank");
//        loans.put("personal loan", "Wells Fargo");
//
//        Set<Map.Entry<String, String>> entrySet = loans.entrySet();
//        Iterator<Map.Entry<String, String>> it1 = entrySet.iterator();
//
//        while (it1.hasNext()) {
//            Map.Entry<String, String> entry = it1.next();
//            System.out.println(entry.getKey() + "-" + entry.getValue());
//        }
//
//        for (String val :loans.values()) {
//            System.out.println(val);
//        }
//
//        Set s = new HashSet();

        //System.out.println(l.toString());

        Map<String, Object> map = new HashMap<>();
        //map.put("pageCount", 1234);
        List count = (ArrayList) map.get("fileNames");
        System.out.println(count);
        //map.remove("1234");

//        Integer i = null;
//        System.out.println(i>0);
    }
}
