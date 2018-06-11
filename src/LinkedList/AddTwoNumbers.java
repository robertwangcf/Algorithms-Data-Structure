package LinkedList;

import java.util.Stack;

/**
 * Created by Robert on 5/25/2018.
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l4.next = l5;
        l5.next = l6;
        //System.out.print(addTwoNumbers(l1, l4).val);
        String i = "a b c";
        System.out.print(new ListNode(1).key);
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> st1 = new Stack<>();
        Stack<ListNode> st2 = new Stack<>();
        while (l1 != null) {
            st1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            st2.push(l2);
            l2 = l2.next;
        }
        ListNode newTail = new ListNode(-1);
        ListNode cursor = newTail;
        int carryOver = 0;
        while (!st1.isEmpty() || !st2.isEmpty()) {
            int val1 = 0;
            int val2 = 0;
            if (!st1.isEmpty()) {
                val1 = st1.pop().val;
            }
            if (!st2.isEmpty()) {
                val2 = st2.pop().val;
            }
            int sum = val1 + val2;

            ListNode curNode = new ListNode((sum + carryOver) % 10);
            cursor.next = curNode;
            cursor = cursor.next;
            carryOver = (sum + carryOver) / 10;
        }
        if (carryOver != 0) {
            ListNode curNode = new ListNode(carryOver);
            cursor.next = curNode;
            cursor = cursor.next;
        }
        return reverseList(newTail.next);
    }

    private static ListNode reverseList(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
