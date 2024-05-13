package myLinkListed;

public class RemoveListElements {
    public static void main(String[] args) {
//		ListNode o7 = new ListNode(6, null);
//		ListNode o6 = new ListNode(5, o7);
//		ListNode o5 = new ListNode(4, o6);
//		ListNode o4 = new ListNode(3, o5);
//		ListNode o3 = new ListNode(6, o4);
//		ListNode o2 = new ListNode(2, o3);
//		ListNode o1 = new ListNode(1, o2);

        ListNode o4 = new ListNode(7, null);
        ListNode o3 = new ListNode(7, o4);
        ListNode o2 = new ListNode(7, o3);
        ListNode o1 = new ListNode(7, o2);

        RemoveListElements removeListElements = new RemoveListElements();
        ListNode newheadListNode = removeListElements.removeElements1(o1, 7);
        System.out.println(newheadListNode);
    }

    public ListNode removeElements2(ListNode head, int val) {
        ListNode sentiel = new ListNode(-1, head);
        ListNode p1 = sentiel;
        ListNode p2 = sentiel.next;
        while (p2 != null) {
            // 1->2->3->6->3->6
            // 如果值匹配上了
            if (p2.val == val) {
                // 跳过该节点
                p1.next = p2.next;
                p2 = p2.next;
            } else {
                // 没有匹配上，两个指针同时后移
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return sentiel.next;
    }

    public ListNode removeElements1(ListNode head, int val) {
        ListNode p = head;
        ListNode pnext = p.next;
        while (p != null) {
            if (p.next == null) {
                // 如果是最后节点，那就让上一个节点指向null
                p.next = null;
                p = p.next;
                if (p != null) {
                    pnext = p.next;
                }
                continue;
            }
            if (p.val == val) {
                // 如果是链表头结点能够匹配上，就断开头结点
                p.next = null;
                p = p.next;
                if (p != null) {
                    pnext = p.next;
                }
                continue;
            }
            if (pnext.val == val) {
                // 如果是中间节点，那就让中间节点跳过该节点
                p.next = pnext.next;
                p = p.next;
                if (p != null) {
                    pnext = p.next;
                }
            }
        }
        return head;
    }

    public ListNode removeElements3(ListNode p, int val) {
        //递归实现
        if (p == null) {
            return null;
        }
        if (p.val == val) {
            //如果回溯过程中匹配上了，就返回下一个节点的回溯结果
            //相当于将该节点跳过
            return removeElements3(p.next, val);
        } else {
            //将链表更新，否则返回的就是原来的链表
            p.next = removeElements3(p.next, val);
            return p;
        }
    }
}
