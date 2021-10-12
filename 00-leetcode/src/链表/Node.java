package 链表;

class Node {
    int val;
    Node next;
    Node prev;
    Node random;
    Node child;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
