/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    private int lengthCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                ListNode temp = slow;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                } while (temp != slow);
                return length;
            }
        }
        return 0;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        // Step 1: Detect if there's a cycle and get its length
        int length = 0;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                length = lengthCycle(slow);
                break;
            }
        }

        // If no cycle, return null
        if (length == 0) {
            return null;
        }

        // Step 2: Find the start of the cycle
        ListNode first = head;
        ListNode second = head;

        // Move second pointer ahead by length of cycle
        while (length > 0) {
            second = second.next;
            length--;
        }

        // Move both pointers until they meet at the cycle start
        while (first != second) {
            first = first.next;
            second = second.next;
        }

        return first;
    }
}