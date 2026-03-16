package quizForEnum;




import java.util.*;

public class Main{


    public static void main(String[] args) {

    }


    @SuppressWarnings("DuplicatedCode")
    public static List<List<Integer>> bfs(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int queueSize = queue.size();
            List<Integer> curLevel = new ArrayList<>();

            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                curLevel.add(node.val);

                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            res.add(curLevel);
        }
        return res;
    }
}
