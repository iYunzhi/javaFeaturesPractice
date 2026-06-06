package LeetCode.LeetCode104;

public class Solution {

    public static void main(String[] args) {
        //       3
        //      / \
        //     9  20
        //       /  \
        //      15   7
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        Solution solution = new Solution();
        System.out.println("最大深度: " + solution.maxDepth(root));
    }


    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        if (root.left == null && root.right == null){
            return 1;
        }

        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return Math.max(l,r) + 1;
    }
}
