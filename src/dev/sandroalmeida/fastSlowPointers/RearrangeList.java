package dev.sandroalmeida.fastSlowPointers;

public class RearrangeList {

    public static void reorder(ListNode head){
        if(head == null || head.next == null)
            return;

        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode headSecondHalf = reverse(slow);
        ListNode headFistHalf = head;

        while(headFistHalf != null && headSecondHalf != null){
            ListNode temp = headFistHalf.next;
            headFistHalf.next = headSecondHalf;
            headFistHalf = temp;

            temp = headSecondHalf.next;
            headSecondHalf.next = headFistHalf;
            headSecondHalf = temp;
        }

        if(headFistHalf != null)
            headFistHalf.next = null;
    }

    private static ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        RearrangeList.reorder(head);
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}
