package dev.sandroalmeida.treeBFS;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumBinaryTreeDepth {

    public static int findDepth(TreeNode root){

        Queue<TreeNode> currentLevel = new LinkedList<>();
        currentLevel.offer(root);
        int levelCount = 0;

        while(!currentLevel.isEmpty()){
            int levelSize = currentLevel.size();
            levelCount++;

            for(int i = 0; i < levelSize; i++){
                TreeNode currentNode = currentLevel.poll();
                if(currentNode.left != null) currentLevel.offer(currentNode.left);
                if(currentNode.right != null) currentLevel.offer(currentNode.right);
                if(currentNode.right == null && currentNode.left == null) return levelCount;
            }
        }
        return levelCount;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
    }
}
