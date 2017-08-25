package ds.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by sarkarri on 12/16/16.
 */
public class VerticalSum {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        VerticalSum vs = new VerticalSum();
        vs.generateVerticalSum(Node.nodeBuilder(), map, 0);

        System.out.println(map.entrySet());
    }

    void generateVerticalSum(Node root, Map<Integer, List<Integer>> map, int verticalLevel) {
        if (root == null)
            return;

        generateVerticalSum(root.left, map, verticalLevel - 1);
        List<Integer> list = map.get(verticalLevel) == null ? new ArrayList<Integer>() : map.get(verticalLevel);
        list.add(root.data);
        map.put(verticalLevel, list);
        generateVerticalSum(root.right, map, verticalLevel + 1);
    }
}
