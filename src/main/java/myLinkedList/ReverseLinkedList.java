package myLinkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode o5 = new ListNode(5, null);
        ListNode o4 = new ListNode(4, o5);
        ListNode o3 = new ListNode(3, o4);
        ListNode o2 = new ListNode(2, o3);
        ListNode o1 = new ListNode(1, o2);
        System.out.println(o1);
        ListNode n1 = new ReverseLinkedList().reverseList(o1);
        System.out.println(n1);
    }

    public ListNode reverseList(ListNode head) {
        // 简单粗暴，反转链表
        ListNode n1 = null;
        ListNode p = head;
        while (p != null) {
            n1 = new ListNode(p.val, n1);
            //System.out.println(n1);
            head = n1;
            p = p.next;
        }
        return n1;
    }

    public ListNode reverseList1(ListNode head) {
        // 将旧链表的头部移走，依次添加到新链表的头部
        ListNode.List list1 = new ListNode.List(head);
        ListNode.List list2 = new ListNode.List(null);
        while (true) {
            ListNode removeFirst = list1.removeFirst();
            if (removeFirst == null) {
                break;
            }
            list2.addFirst(removeFirst);
        }
        return list2.head;
    }

    public ListNode reverseList2(ListNode p) {
        // 递归，利用递归反序实现
        // 考虑链表为空的情况
        if (p.next == null || p == null) {
            return p;
        }

        // 递归之前，正序
        ListNode last = reverseList2(p.next);
        p.next.next = p;
        p.next = null; // 切断之前链表的连接，让下一个节点为null，这样就不会是环形链表了
        // 递归之后，反序
        return last;
    }

    /**
     * 这是一个反转链表的算法
     *
     * @param o1 传入的链表的头结点
     * @return 返回的是链表的某一个节点
     */
    public ListNode reverseList3(ListNode o1) {
        // 将第一个节点的下一个节点和其他节点断开，然后将这个游离的节点添加到原链表的头结点即可
        if (o1 == null || o1.next == null) {
            // 如果链表为空或者链表中只有一个元素
            return o1;
        }
        ListNode o2 = o1.next;
        ListNode n1 = o1; // 记录新链表的头结点
        while (o2 != null) {
            o1.next = o2.next;
            o2.next = n1;
            n1 = o2;
            o2 = o1.next;
        }
        return n1; // 返回新表的头结点
    }

    public ListNode reverseList4(ListNode o1) {
        // 思想和方法二相同，只不过使用面向过程实现
        // 双指针实现
        if (o1 == null || o1.next == null) {
            // 如果链表为空或者链表中只有一个元素
            return o1;
        }

        ListNode n1 = null;
        while (o1 != null) {
            ListNode o2 = o1.next;
            o1.next = n1;
            n1 = o1;
            o1 = o2;
        }
        return n1;
    }
}
