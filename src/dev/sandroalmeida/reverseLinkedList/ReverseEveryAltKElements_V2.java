package dev.sandroalmeida.reverseLinkedList;

public class ReverseEveryAltKElements_V2 {

    public static ListNode reverse(ListNode head, int k){

        if(k <= 1 || head == null) return head;
        ListNode current = head, previous = null;

        while(true){
            ListNode lastNodeOfPreviousPart = previous;

            // after reversing the LinkedList 'current' will become the last node of the sub-list
            ListNode lastNodeOfSubList = current;

            ListNode next = null;

            // reverse 'k' nodes
            for(int i = 0; current != null && i < k; i++){
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            if(lastNodeOfPreviousPart != null)
                lastNodeOfPreviousPart.next = previous; // 'previous' is now the first node of the sub-list
            else // this means we are changing the first node (head) of the LinkedList
                head = previous;

            // connect with the next part
            lastNodeOfSubList.next = current;

            // skip 'k' nodes
            for(int i = 0; i < k; i++){
                previous = current;
                current = current.next;
            }

            // break, if we've reached the end of the LinkedList
            if(current == null) break;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode result = ReverseEveryAltKElements_V2.reverse(head, 2);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
