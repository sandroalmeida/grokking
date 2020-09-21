package dev.sandroalmeida.treeDFS;

import java.util.ArrayList;
import java.util.List;

public class AllRootToLeafPaths {

    public static List<List<Integer>> findAllPaths(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findAllPathsRecursive(root, result, currentPath);

        return result;
    }

    private static void findAllPathsRecursive(TreeNode root, List<List<Integer>> result, List<Integer> currentPath){
        if(root == null) return;
        currentPath.add(root.val);

        if(root.left == null && root.right == null)
            result.add(new ArrayList<>(currentPath));
        else {
            findAllPathsRecursive(root.left, result, currentPath);
            findAllPathsRecursive(root.right, result, currentPath);
        }
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = AllRootToLeafPaths.findAllPaths(root);
        System.out.println("All paths:  " + result);
    }
}
