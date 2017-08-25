package reflection;

import ds.tree.Node;
import ds.tree.VerticalSum;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by sarkarri on 2/4/17.
 */
public class ObjectResource {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        /*Class c = Class.forName("java.lang.Object");
        String name = c.getName();
        System.out.println(name);
        Object obj = c.newInstance();
        System.out.println(obj.hashCode());*/

        Map<Integer, Integer> map = new HashMap<>();
        VerticalSum vs = new VerticalSum();
        Node root = Node.nodeBuilder();
        Integer i = null;
        //int dd = i + root.data;
        System.out.println((i+1));
    }
}
