package algorithm;

public class Test {
    public static void main(String[] args) {
        //测试用例
        ListNode n15 = new ListNode(9, null);
        ListNode n14 = new ListNode(6, n15);
        ListNode n13 = new ListNode(5, n14);
        ListNode n12 = new ListNode(2, n13);
        ListNode n11 = new ListNode(1, n12);

        ListNode n25 = new ListNode(8, null);
        ListNode n24 = new ListNode(7, n25);
        ListNode n23 = new ListNode(4, n24);
        ListNode n22 = new ListNode(2, n23);

        System.out.println(n11);
        System.out.println(new Test().mergeTwoLists2(n11, n22));
    }

    public ListNode mergeTwoLists(ListNode p1, ListNode p2) {
        //非递归实现
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

    public ListNode mergeTwoLists2(ListNode p1, ListNode p2) {
        if (p1 == null) {
            return p2;
        }
        if (p2 == null) {
            return p1;
        }
        if (p1.val < p2.val) {
            p1.next = mergeTwoLists2(p1.next, p2);
            return p1;
        } else {
            p2.next = mergeTwoLists2(p1, p2.next);
            return p2;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode p = this;
        while (p != null) {
            sb.append(p.val);
            if (p.next != null) {
                sb.append(",");
            }
            p = p.next;
        }
        sb.append("]");
        return sb.toString();
    }
}