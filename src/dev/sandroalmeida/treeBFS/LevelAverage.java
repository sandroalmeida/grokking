package dev.sandroalmeida.treeBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelAverage {

    public static List<Double> findLevelAverages(TreeNode root){
        List<Double> result = new ArrayList<>();

        Queue<TreeNode> currentLevel = new LinkedList<>();
        currentLevel.offer(root);

        while(!currentLevel.isEmpty()){
            double sum = 0.0d;
            int levelSize = currentLevel.size();

            for(int i = 0; i < levelSize; i++){
                TreeNode currentNode = currentLevel.poll();
                sum += currentNode.val;
                if(currentNode.left != null) currentLevel.offer(currentNode.left);
                if(currentNode.right != null) currentLevel.offer(currentNode.right);
            }
            result.add(sum/levelSize);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<Double> result = LevelAverage.findLevelAverages(root);
        System.out.print("Level averages are: " + result);
    }
}
