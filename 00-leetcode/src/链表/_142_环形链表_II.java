package 链表;

/**
 * https://leetcode.cn/problems/linked-list-cycle-ii/
 * https://leetcode.cn/problems/linked-list-cycle-ii/solution/by-blossom-w5-3hdk/  推导公式略有问题，可以再去看下官解
 */
public class _142_环形链表_II {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode ans = head;
                while (ans != slow) {
                    ans = ans.next;
                    slow = slow.next;
                }
                return slow;
            }
        }

        return null;
    }

}
