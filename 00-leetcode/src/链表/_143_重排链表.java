package 链表;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/reorder-list/description/
 */
public class _143_重排链表 {
    public void reorderList(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        cur = head;
        ListNode tail = stack.pop();
        while (cur != tail && cur.next != tail) {
            ListNode next = cur.next;
            cur.next = tail;
            tail.next = next;
            cur = next;
            tail = stack.pop();
        }
        tail.next = null;
    }

    public void reorderList2(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode cur = slow.next;
        slow.next = null;
        ListNode l2 = null;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = l2;
            l2 = cur;
            cur = next;
        }
        ListNode l1 = head;

        while (l1 != null && l2 != null) {
            ListNode next1 = l1.next;
            ListNode next2 = l2.next;
            l1.next = l2;
            l2.next = next1;
            l2 = next2;
            l1 = next1;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        new _143_重排链表().reorderList(n1);
    }
}
