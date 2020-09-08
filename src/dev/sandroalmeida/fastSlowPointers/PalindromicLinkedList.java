package dev.sandroalmeida.fastSlowPointers;

public class PalindromicLinkedList {

    public static boolean isPalindrome(ListNode head){

        ListNode slow = head, fast = head;
        int result = slow.value;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            result += slow.value;
        }

        while(slow != null){
            result -= slow.value;
            slow = slow.next;
        }

        return result == 0;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

        head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
    }
}
