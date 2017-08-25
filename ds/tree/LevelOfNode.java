package ds.tree;

/**
 * Created by sarkarri on 12/16/16.
 */
public class LevelOfNode {
    public static void main(String[] args) {
        System.out.printf("level of " + new LevelOfNode().getLevelOfNode(Node.nodeBuilder(), 1, 13));
    }

    int getLevelOfNode(Node root, int level, int data) {
        if (root == null)
            return 0;
        if (root.data == data)
            return level;

        int result = 0;
        result = getLevelOfNode(root.left, level + 1, data);

        if (result == 0)
            result = getLevelOfNode(root.right, level + 1, data);

        return result;
    }

}
