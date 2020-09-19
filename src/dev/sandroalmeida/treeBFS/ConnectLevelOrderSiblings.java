package dev.sandroalmeida.treeBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNodeN {
    int val;
    TreeNodeN left;
    TreeNodeN right;
    TreeNodeN next;

    TreeNodeN(int x) {
        val = x;
        left = right = next = null;
    }

    // level order traversal using 'next' pointer
    void printLevelOrder() {
        TreeNodeN nextLevelRoot = this;
        while (nextLevelRoot != null) {
            TreeNodeN current = nextLevelRoot;
            nextLevelRoot = null;
            while (current != null) {
                System.out.print(current.val + " ");
                if (nextLevelRoot == null) {
                    if (current.left != null)
                        nextLevelRoot = current.left;
                    else if (current.right != null)
                        nextLevelRoot = current.right;
                }
                current = current.next;
            }
            System.out.println();
        }
    }
}

public class ConnectLevelOrderSiblings {

    public static void connect(TreeNodeN root){

        Queue<TreeNodeN> queue = new LinkedList<>();
        int levelSize = 0;
        queue.offer(root);

        while(!queue.isEmpty()){
            levelSize = queue.size();
            TreeNodeN previousNode = null;
            for(int i = 0; i < levelSize; i++){
                TreeNodeN currentNode = queue.poll();

                if(previousNode != null) previousNode.next = currentNode;
                previousNode = currentNode;

                if(currentNode.left != null) queue.offer(currentNode.left);
                if(currentNode.right != null) queue.offer(currentNode.right);
            }
        }

    }

    public static void main(String[] args) {
        TreeNodeN root = new TreeNodeN(12);
        root.left = new TreeNodeN(7);
        root.right = new TreeNodeN(1);
        root.left.left = new TreeNodeN(9);
        root.right.left = new TreeNodeN(10);
        root.right.right = new TreeNodeN(5);
        ConnectLevelOrderSiblings.connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        root.printLevelOrder();
    }

}


