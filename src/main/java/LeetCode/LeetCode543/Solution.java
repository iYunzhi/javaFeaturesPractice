package LeetCode.LeetCode543;

public class Solution {


    public static void main(String[] args) {
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3));

        Solution solution = new Solution();
        System.out.println(solution.diameterOfBinaryTree(root)); // 期望输出: 3
    }

    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans;
    }

    public int depth(TreeNode root){
        if (root == null){
            return 0;
        }

        int l = depth(root.left);
        int r = depth(root.right);
        ans = Math.max(ans,l+r);
        return Math.max(l,r) + 1;
    }
}
