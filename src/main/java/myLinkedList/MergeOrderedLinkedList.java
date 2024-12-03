package myLinkedList;

import myLinkedList.dataStructure.ListNode;

public class MergeOrderedLinkedList {
    public static void main(String[] args) {
        //测试用例....
        //LeetCode6 21
        ListNode n45 = new ListNode(7, null);
        ListNode n44 = new ListNode(3, n45);
        ListNode n43 = new ListNode(2, n44);
        ListNode n42 = new ListNode(1, n43);
        ListNode n41 = new ListNode(0, n42);

        ListNode n35 = new ListNode(9, null);
        ListNode n34 = new ListNode(5, n35);
        ListNode n33 = new ListNode(4, n34);
        ListNode n32 = new ListNode(2, n33);
        ListNode n31 = new ListNode(0, n32);

        ListNode n24 = new ListNode(7, null);
        ListNode n23 = new ListNode(6, n24);
        ListNode n22 = new ListNode(5, n23);
        ListNode n21 = new ListNode(3, n22);

        ListNode n14 = new ListNode(8, null);
        ListNode n13 = new ListNode(6, n14);
        ListNode n12 = new ListNode(4, n13);
        ListNode n11 = new ListNode(1, n12);
        ListNode[] lists = {n11, n21, n31, n41};
        System.out.println(new MergeOrderedLinkedList().mergeKLists(lists));

    }

    //非递归实现
    public ListNode mergeTwoLists1(ListNode p1, ListNode p2) {
        /*
        思路：谁的节点的值小，将谁链接给p，p和小的那个链表的节点都向后平移一位
        当p1和p2其中有一个为null时，退出循环，将不为null的值链接给p
        p1
        1  3  8  9  null
        p2
        2  4  null
        p
        s
           p1
        1  3  8  9  null
        p2
        2  4  null
           p
        s  1
         */
        ListNode s = new ListNode(-1, null);
        ListNode p = s;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return s.next;
    }

    //递归实现
    public ListNode mergeTwoLists2(ListNode p1, ListNode p2) {
        //递归函数应该返回更小的节点，并把它剩余节点和另一个链表再次递归
        //返回之前，更新此节点的next，从此节点后向后匹配
        //同时每次返回更小的节点值，也能够保证该链表按照升序进行排列
        if (p2 == null) {
            return p1;
        }
        if (p1 == null) {
            return p2;
        }
        if (p1.val < p2.val) {
            p1.next = mergeTwoLists2(p1.next, p2);
            return p1;
        } else {
            p2.next = mergeTwoLists2(p1, p2.next);
            return p2;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        //LeetCode23
        if (lists.length == 0) {
            return null;
        }
        return split(lists, 0, lists.length - 1);
    }

    /**
     * 该方法返回合并后的链表
     *
     * @param lists 给出的链表数组
     * @param i     左边界
     * @param j     右边界
     * @return 返回合并后的数组
     */
    private ListNode split(ListNode[] lists, int i, int j) {
        /*
        合并k个升序的链表，最终的链表也是升序的
        如果不会合并多个链表，可以将两个链表先合成一个链表
        然后将新的链表与下一个链表继续合成，直到合成到最后一个即可
        2个2个进行合成即可
         */
        //多路递归
        if (i == j) {
            //表示数组内只有一个链表
            return lists[i];
        }
        int m = (i + j) >>> 1;
        ListNode left = split(lists, i, m);
        ListNode right = split(lists, m + 1, j);
        return mergeTwoLists2(left, right);
    }
}
