package LinkedList;

/**
 * Created by Robert on 5/27/2018.
 */
class ListNode {
    ListNode pre;
    ListNode next;
    int val;
    int key;
    public ListNode(int val, int key) {
        this.val = val;
        this.key = key;
        pre = null;
        next = null;
    }
    public ListNode(int val) {
        this.val = val;
    }
}
