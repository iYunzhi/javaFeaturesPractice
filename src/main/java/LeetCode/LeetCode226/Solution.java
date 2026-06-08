package LeetCode.LeetCode226;

public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        System.out.println("翻转前: " + root);
        new Solution().invertTree(root);
        System.out.println("翻转后: " + root);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null) ){
            return root;
        }

        TreeNode left = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = left;
        return root;
    }
}
