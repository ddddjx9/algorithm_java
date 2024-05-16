package myLinkedList;

public class OrderedLinkedListDeduplication82 {
    public static void main(String[] args) {
        //测试用例
        ListNode n5 = new ListNode(3, null);
        ListNode n4 = new ListNode(3, n5);
        ListNode n3 = new ListNode(2, n4);
        ListNode n2 = new ListNode(1, n3);
        ListNode n1 = new ListNode(1, n2);

        System.out.println(n1);
        System.out.println(new OrderedLinkedListDeduplication82().deduplicationList1(n1));
    }

    /*
    LeetCode 82:
    这次和上次不一样的是，重复元素全部去除，一个不留
     */
    public ListNode deduplicationList1(ListNode p) {
        /*
        递归函数负责返回，从当前节点开始，完成去重的链表
        1.如果当前节点与下一个节点重复，一直找到下一个不重复的节点，以它的返回结果为准
        2.如果不重复，返回当前节点，同时更新next
         */
        //递归实现
        if (p == null || p.next == null) return null;
        if (p.val == p.next.val) {
            //找到重复的第三个节点，从这个节点开始继续向后找
            ListNode x = p.next.next;
            //如果x的取值和重复的第一个节点的取值一样，说明没找到
            while (x != null && x.val == p.val) {
                x = x.next;
            }
            //等循环结束，这里的x就是与p不同的节点, 返回x之后的递归结果
            return deduplicationList1(x);
        } else {
            p.next = deduplicationList1(p.next);
            return p;
        }
    }

    //非递归实现
    public ListNode deduplicationList2(ListNode head) {
        /*
        使用三个指针来实现此问题
        p1 p2 p3
        s  1  1  1  2  3  null
        p1 p2    p3
        s  1  1  1  2  3  null
        p1 p2       p3
        s  1  1  1  2  3  null
        p1 p3 (p1.next=p3)
        s  2  3  null
        p1 p2 p3
        s  2  3  null
           p1 p2 p3
        s  2  3  null
         */
        if (head == null || head.next == null) {
            return head;
        }
        ListNode s = new ListNode(-1, head);
        ListNode p1 = s;
        ListNode p2, p3;
        while ((p2 = p1.next) != null && (p3 = p2.next) != null) {
            if (p2.val == p3.val) {
                while ((p3 = p3.next) != null && p3.val == p2.val) {

                }
                //此时p3已经找到了不重复的值
                p1.next = p3;
            } else {
                //p1移动后，下次再进入循环，p2,p3都会跟着移动
                p1 = p1.next;
            }
        }
        //返回最开始的哨兵的下一个节点，就是头结点
        return s.next;
    }
}
