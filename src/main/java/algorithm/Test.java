package algorithm;

public class Test {
    public static void main(String[] args) {
        //测试用例
        ListNode n15 = new ListNode(9, null);
        ListNode n14 = new ListNode(6, n15);
        ListNode n13 = new ListNode(5, n14);
        ListNode n12 = new ListNode(2, n13);
        ListNode n11 = new ListNode(1, n12);

        System.out.println(new Test().middleNode(n11));
    }

    public ListNode middleNode(ListNode head) {
        /*
        快慢指针法：其中慢指针一次走一步，快指针一次走两步
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