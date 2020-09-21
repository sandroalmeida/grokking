package dev.sandroalmeida.treeDFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreePathMaxSum {

    public static List<Integer> findMaxSum(TreeNode root){
        Map<Integer, List<Integer>> mapPath = new HashMap<>();
        List<Integer> currentPath = new ArrayList<>();
        int currentMax = 0;
        findMaxSumRecursive(mapPath, currentPath, root, currentMax);

        int max = 0;
        List<Integer> path = new ArrayList<>();
        for(Map.Entry<Integer, List<Integer>> entry : mapPath.entrySet()){
            if(entry.getKey() > max){
                max = entry.getKey();
                path = entry.getValue();
            }
        }

        return path;
    }

    private static void findMaxSumRecursive(Map<Integer, List<Integer>> mapPath, List<Integer> currentPath, TreeNode root, int currentSum){
        if(root == null) return;

        currentPath.add(root.val);
        currentSum += root.val;

        if(root.left == null && root.right == null){
            mapPath.put(currentSum, new ArrayList<>(currentPath));
        } else{
            findMaxSumRecursive(mapPath, currentPath, root.left, currentSum);
            findMaxSumRecursive(mapPath, currentPath, root.right, currentSum);
        }
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<Integer> result = TreePathMaxSum.findMaxSum(root);
        System.out.println("Max sum path:  " + result);

    }
}
