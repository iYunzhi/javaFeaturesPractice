package LeetCode.LeetCode101;


public class Solution {

    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(3);
        node2.right = node4;
        node3.right = node5;
        TreeNode node1 = new TreeNode(3, node2, node3);

        System.out.println(node1);

        System.out.println(checkSymmetricTree(node1));

    }


    public static boolean checkSymmetricTree(TreeNode root) {
        if (root == null){return true;}
        return isMirror(root.left,root.right);
    }

    public static boolean isMirror(TreeNode left ,TreeNode right){
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null){
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isMirror(left.left ,right.right) && isMirror(left.right ,right.left);
    }
}




