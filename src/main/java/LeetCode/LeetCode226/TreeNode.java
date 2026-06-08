package LeetCode.LeetCode226;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(this);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("null");
            } else {
                sb.append(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
            if (!queue.isEmpty()) {
                sb.append(",");
            }
        }
        // 去除末尾的 null
        while (sb.length() > 1 && sb.substring(sb.length() - 5).equals(",null")) {
            sb.setLength(sb.length() - 5);
        }
        sb.append("]");
        return sb.toString();
    }
}
