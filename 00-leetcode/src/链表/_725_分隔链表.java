package 链表;

/**
 * https://leetcode-cn.com/problems/split-linked-list-in-parts/
 */
public class _725_分隔链表 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        while (dummyNode.next != null) {
            dummyNode = dummyNode.next;
            len++;
        }

        int perLen = len / k;
        int remainder = len % k;

        ListNode[] ans = new ListNode[k];
        dummyNode = new ListNode();
        dummyNode.next = head;

        int oneLen = perLen + 1;
        ListNode cur = null;

        for (int idx = 0; idx < k; idx++) {
            cur = dummyNode;
            for (int j = perLen; j > 0; j--) {
                cur = cur.next;
            }
            if (remainder > 0) {
                cur = cur.next;
                remainder--;
            }
            ListNode next = cur.next;
            cur.next = null;
            ans[idx] = dummyNode.next;
            dummyNode.next = next;
        }

        return ans;
    }
}
