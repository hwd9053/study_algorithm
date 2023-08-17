package 链表;

/**
 * https://leetcode-cn.com/problems/sort-list/
 */
public class _148_排序链表 {
    // 归并(递归。也可以不用递归，但是懒得去理解了)
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(fast);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }

        if (left != null) {
            cur.next = left;
        } else {
            cur.next = right;
        }

        return dummy.next;
    }


}
