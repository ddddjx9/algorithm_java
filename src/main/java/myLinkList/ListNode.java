package myLinkList;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int value, ListNode next) {
        super();
        this.val = value;
        this.next = next;
    }

    public ListNode() {

    }

    static class List {
        ListNode head;

        public List(ListNode head) {
            this.head = head;
        }

        public void addFirst(ListNode first) {
            first.next = head;
            head = first;
        }

        public ListNode removeFirst() {
            ListNode first = head;
            if (first != null) {
                head = first.next;
            }
            return first;
        }
    }
    // 方法一：创建一个新链表，从旧链表依次遍历拿到每一个节点，调用addFirst()方法依次添加到链表头部，这样链表就是倒序的

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
