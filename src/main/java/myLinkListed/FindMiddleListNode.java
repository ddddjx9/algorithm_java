package myLinkListed;

public class FindMiddleListNode {
    public static void main(String[] args) {
        ListNode n14 = new ListNode(8, null);
        ListNode n13 = new ListNode(6, n14);
        ListNode n12 = new ListNode(4, n13);
        ListNode n11 = new ListNode(1, n12);
        System.out.println(new FindMiddleListNode().middleNode(n11));
    }

    /**
     * LeetCode876快慢指针法查找链表的中间节点
     *
     * @param head 链表的头结点
     * @return 返回查找到的中间节点
     */
    public ListNode middleNode(ListNode head) {
        //查找时如果是偶数个节点，要求靠右的那个作为中间节点
        //快慢指针法
        //p1一次走一步
        //p2一次走两步
        /*
              p1    p2
        1  2  3  4  5  null
                 p1       p2
        1  2  3  4  5  6  null
         */
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }
}
