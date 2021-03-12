package 链表;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class _234_回文链表 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        if (head.next.next == null) return head.val == head.next.val;

        // 找到中间节点
        ListNode mid = middleNode(head);
        // 翻转右半部分(中间节点的下一个节点)
        ListNode rHead = reverseList(mid.next);
        ListNode lHead = head;

        // 从lHead和rHead出发，判断是否为回文链表
        while (rHead != null) {
            if (rHead.val != lHead.val) {
                return false;
            }
            rHead = rHead.next;
            lHead = lHead.next;
        }
        return true;
    }

    // 找到中间节点(右半部分链表头节点的前一个节点)
    private ListNode middleNode(ListNode head) {
        return null;
    }

    // 翻转链表
    private ListNode reverseList(ListNode head) {
        return null;
    }
}
