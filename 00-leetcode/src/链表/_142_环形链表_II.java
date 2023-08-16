package 链表;

/**
 * https://leetcode.cn/problems/linked-list-cycle-ii/description/
 */
public class _142_环形链表_II {
    // 快慢指针 + 数学推导
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }

        if (fast == null || fast.next == null) return null;

        fast = head;
        while (true) {
            if (slow == fast) return slow;
            slow = slow.next;
            fast = fast.next;
        }
    }
}
