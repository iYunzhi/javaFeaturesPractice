package LeetCode.LeetCode572;

public class Subtree {
    public static void main(String[] args) {

    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null){return true;}
        if (root == null){return false;}
        if (isSameTree(root,subRoot)){
            return true;
        }
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }

    public boolean isSameTree(TreeNode root , TreeNode subRoot){
        if (root == null && subRoot == null){return true;}
        if (root == null || subRoot == null){return false;}
        if (root.val != subRoot.val){return false;}
        return isSameTree(root.right ,subRoot.right) && isSameTree(root.left,subRoot.left);
    }

}