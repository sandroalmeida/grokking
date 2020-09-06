package dev.sandroalmeida.fastSlowPointers;

public class LinkedListCycleLength {

    public static int findCycleLength(ListNode head){

        int count = 0, times = 0, firstCount = 0;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            count++;
            fast = fast.next.next;

            if(fast == slow){
                times++;
                if(times == 1) firstCount = count;
                if(times == 2) return count - firstCount;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle length: " + LinkedListCycleLength.findCycleLength(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle length: " + LinkedListCycleLength.findCycleLength(head));
    }
}
