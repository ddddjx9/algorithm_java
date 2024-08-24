package leetcode;

/**
 * <p>
 * 给你两个 非空 的链表，表示两个非负的整数。
 * </p>
 * <p>
 * 它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * </p>
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * </p>
 */
public class LeetCode2 {
    public static void main(String[] args) {
        ListNode l13 = new ListNode(4, null);
        ListNode l12 = new ListNode(6, l13);
        ListNode l11 = new ListNode(2, l12);

        ListNode l22 = new ListNode(9, null);
        ListNode l21 = new ListNode(1, l22);
        System.out.println(new LeetCode2().addTwoNumbers(l11, l21));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h1 = l1;
        ListNode h2 = l2;
        ListNode head = null;
        ListNode tail = null;
        int res = 0;

        while (h1 != null || h2 != null) {
            int v1 = h1 != null ? h1.val : 0;
            int v2 = h2 != null ? h2.val : 0;
            int sum = v1 + v2 + res;
            res = sum / 10;

            if (head == null) {
                head = new ListNode(sum % 10, null);
                tail = head;
            } else {
                tail.next = new ListNode(sum % 10, null);
                tail = tail.next;
            }

            if (h1 != null) {
                h1 = h1.next;
            }

            if (h2 != null) {
                h2 = h2.next;
            }

            if (res > 0) {
                tail.next = new ListNode(res, null);
            }
        }

        return head;
    }
}
