package LeetCode.LeetCode199;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    if (i == queueSize - 1){
                        res.add(node.val);
                    }

                    if(node.left != null){
                        queue.offer(node.left);
                    }

                    if (node.right != null){
                        queue.offer(node.right);
                    }
                }
            }
        }

        return res;
    }
}
