package LeetCode.LeetCode98;

import java.time.chrono.IsoChronology;

public class Solution {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(-1);
        treeNode.left = treeNode1;

        Solution solution = new Solution();

        System.out.println(solution.isValidBST(treeNode));

    }

    long prev = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }

        boolean leftValid = isValidBST(root.left);
        if (!leftValid){
            return false;
        }

        if (root.val <= prev){
            return false;
        }

        prev = root.val;

        return isValidBST(root.right);
    }
}
