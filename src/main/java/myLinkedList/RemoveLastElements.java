package myLinkedList;

public class RemoveLastElements {
    static int count = 0;

    public static void main(String[] args) {
        ListNode o5 = new ListNode(5, null);
        ListNode o4 = new ListNode(4, o5);
        ListNode o3 = new ListNode(3, o4);
        ListNode o2 = new ListNode(2, o3);
        ListNode o1 = new ListNode(1, o2);
        RemoveLastElements removeLastElements = new RemoveLastElements();
        ListNode p = removeLastElements.removeNthFromEnd2(o1, 1);
        System.out.println(p);
    }

    public ListNode removeNthFromEnd(ListNode p, int n) {
        if (p == null) {
            return null;
        }

        p.next = removeNthFromEnd(p.next, n);
        count++;
        if (count == n) {
            return removeNthFromEnd(p.next, n);
        }
        return p;
    }

    public ListNode removeNthFromEnd2(ListNode p, int n) {
        ListNode sListNode = new ListNode(-1, p);
        recursion(sListNode, n);
        return p;
    }

    public int recursion(ListNode p, int n) {
        if (p == null) {
            return 0;
        }
        int nth = recursion(p.next, n);
        System.out.println(p.val + " " + nth);
        if (nth == n) {
            p.next = p.next.next;
        }
        return nth + 1;
    }

    /*
    n=2
    p1
    p2
    s -> 1 -> 2 -> 3 -> 4 -> 5 -> null
         p2
    s -> 1 -> 2 -> 3 -> 4 -> 5 -> null
              p2
    s -> 1 -> 2 -> 3 -> 4 -> 5 -> null
    p1             p2
    s -> 1 -> 2 -> 3 -> 4 -> 5 -> null
                   p1             p2
    s -> 1 -> 2 -> 3 -> 4 -> 5 -> null              
     */
    public ListNode removeNthFromEnd3(ListNode p, int n) {
        ListNode s = new ListNode(-1, p);
        ListNode p1 = p;
        ListNode p2 = p;
        int count = 0;
        while (count < n + 1) {
            p2 = p2.next;
            count++;
        }
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return s.next;
    }
}
