package Adventure.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test {

    public static void main(String[] args) {
        // 构建示例二叉树:
        //        1
        //       / \
        //      2   3
        //     / \   \
        //    4   5   6

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);



        dfsPostorder(root);
        System.out.println(dfsAns);

    }

    // BFS 层序遍历 — 自己实现
    public static void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null){
            return;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            int levelSize = queue.size();

            List<Integer> curLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                curLevel.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            ans.add(curLevel);
        }
        System.out.println(ans);
    }
    static List<Integer> dfsAns = new ArrayList<>();
    // DFS 前序遍历 (根-左-右) — 自己实现
    public static void dfsPreorder(TreeNode node) {
        if (node == null){
            return;
        }

        dfsAns.add(node.val);
        dfsPreorder(node.left);
        dfsPreorder(node.right);
    }

    // DFS 中序遍历 (左-根-右) — 自己实现
    public static void dfsInorder(TreeNode node) {
        if (node == null){
            return;
        }

        dfsInorder(node.left);
        dfsAns.add(node.val);
        dfsInorder(node.right);
    }

    // DFS 后序遍历 (左-右-根) — 自己实现
    public static void dfsPostorder(TreeNode node) {
        if (node == null){
            return;
        }

        dfsPostorder(node.left);
        dfsPostorder(node.right);
        dfsAns.add(node.val);
    }
}
