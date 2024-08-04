import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MinDepth {


    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right != null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null && root.left != null) {
            return minDepth(root.left) + 1;
        }

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }


    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return level;
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);

            }
            level++;
        }
        return level;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(level);
        }
        return result;

    }
}


