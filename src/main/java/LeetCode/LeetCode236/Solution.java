package LeetCode.LeetCode236;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public static void main(String[] args) {
        // 构造根节点和主要分支
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);

        // 构造 p (值为 2 的节点)
        TreeNode p = root.left;

        // 构造 q (值为 8 的节点)
        TreeNode q = root.right;

        // 构造其他子节点
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        // ========================================

        // 4. 调用您的函数进行测试
        TreeNode lca = lowestCommonAncestor(root, p, q);

        // 5. 打印结果
        // 预期输出: 6
        System.out.println("最近公共祖先是: " + lca.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        //If p and q both located in left subtree of curr
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        //If p and q both located in right subtree of curr
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;

    }
}