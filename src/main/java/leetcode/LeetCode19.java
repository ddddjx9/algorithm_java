package cn.edu.ustb.leetcode;

public class LeetCode19 {
    public static void main(String[] args) {
        ListNode n5 = new ListNode(5, null);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        System.out.println(new LeetCode19().removeNthFromEnd(n1, 2));
        System.out.println(new LeetCode19().getIndex(n3));
    }

    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     * <p>
     * 最暴力的接发应该是两趟，并不知道这个链表的长度，第一趟的时候记录链表的长度，然后第二趟扫描倒数节点，删除
     * </p>
     * <p>
     * 另一个容易想到的方法应该就是递归，用递归记录来时的节点
     * </p>
     *
     * @param head 给出的链表的头节点
     * @param n    要删除的倒数第n个节点
     * @return 返回已经删除后的链表的头节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return recursion(head, n);
    }

    public ListNode recursion(ListNode p, int n) {
        if (p == null) {
            return null;
        }

        ListNode next = recursion(p.next, n);
        if (getIndex(p) == n) {
            // 如果当前节点就是要删除的节点，则直接返回下一个节点
            return next;
        } else {
            // 否则，更新当前节点的下一个节点，并返回当前节点
            p.next = next;
            return p;
        }
    }

    public int getIndex(ListNode p) {
        if (p.next == null) {
            return 1;
        }

        return getIndex(p.next) + 1;
    }
}
