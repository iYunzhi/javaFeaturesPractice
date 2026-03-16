package LeetCode102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int levelSize = queue.size();

            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                currentLevel.add(node.val);

                if(node.left != null){
                    queue.offer(node.left);
                }

                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            res.add(currentLevel);
        }
        return res;
    }
}
