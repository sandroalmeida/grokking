package dev.sandroalmeida.treeBFS;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectAllSiblings {

    public static void connect(TreeNodeN root){

        Queue<TreeNodeN> queue = new LinkedList<>();
        queue.offer(root);
        TreeNodeN currentNode = null, previousNode = null;

        while(!queue.isEmpty()){
            currentNode = queue.poll();

            if(previousNode != null) previousNode.next = currentNode;
            previousNode = currentNode;

            if(currentNode.left != null) queue.offer(currentNode.left);
            if(currentNode.right != null) queue.offer(currentNode.right);
        }
    }

    public static void main(String[] args) {
        TreeNodeN root = new TreeNodeN(12);
        root.left = new TreeNodeN(7);
        root.right = new TreeNodeN(1);
        root.left.left = new TreeNodeN(9);
        root.right.left = new TreeNodeN(10);
        root.right.right = new TreeNodeN(5);
        ConnectAllSiblings.connect(root);

        // level order traversal using 'next' pointer
        TreeNodeN current = root;
        System.out.println("Traversal using 'next' pointer: ");
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
