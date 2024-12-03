package myLinkedList;

import myLinkedList.dataStructure.ListNode;

public class OrderedLinkedListDeduplication83 {
    public static void main(String[] args) {
        //测试用例
        ListNode n5 = new ListNode(3, null);
        ListNode n4 = new ListNode(3, n5);
        ListNode n3 = new ListNode(2, n4);
        ListNode n2 = new ListNode(1, n3);
        ListNode n1 = new ListNode(1, n2);

        System.out.println(n1);
        System.out.println(new OrderedLinkedListDeduplication83().deduplication1(n1));
    }

    public ListNode deduplication1(ListNode head) {
        /*
        LeetCode6 83:
        有序链表去重，相同元素在原始链表中无论有多少个，仅仅
        保留一个即可
         */
        /*
        思路：使用双指针，一前一后，判断相邻元素是否相同，如果相同，
        删除其中一个即可
        p1   p2
        1 -> 1 -> 2 -> 3 -> 3 -> null
        p1.val==p2.val那么删除p2, 此时p1保持不变
             p1   p2
        1 -> 2 -> 3 -> 3 -> null
        p1.val!=p2.val,p1 p2均向后移动
                  p1   p2
        1 -> 2 -> 3 -> 3 -> null
        直到p2==null为止，判断结束
        当链表中没有节点或者只有一个节点时，保留原始链表即可
         */

        //特殊情况：当链表中没有节点或者只有一个节点时，保留原始链表即可
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p1 = head;
        ListNode p2;
        while ((p2 = p1.next) != null) {
            if (p1.val == p2.val) {
                //删除p2
                p1.next = p2.next;
            } else {
                //不相等的话，向右平移
                p1 = p1.next;
                //p2在下次进入循环时进行赋值即可，随着p1的平移而平移
            }
        }
        return head;
    }

    public static ListNode deduplication2(ListNode p) {
        //如果发现当前节点和下一个节点的值重复了，那么保留下一个节点的递归结果
        //如果当前节点的值和下一个节点的值没有重复，返回当前节点，但是下一个节点应该更新
        //如果链表仅有一个节点或者链表为空，返回p
        if (p == null || p.next == null) {
            return p;
        }
        if (p.val == p.next.val) {
            return deduplication2(p.next);
        } else {
            p.next = deduplication2(p.next);
            return p;
        }
    }
}
