package myLinkedList;

import myLinkedList.dataStructure.ListNode;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode n5 = new ListNode(1, null);
        ListNode n4 = new ListNode(2, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        System.out.println(new PalindromeLinkedList().isPalindrome2(n1));
    }

    //LeetCode234回文链表
    //将后面的链表进行反转，反转后进行逐一比较，一一比较完，都相同，说明是回文链表
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middle = slow;

        ListNode n1 = null;
        while (middle != null) {
            ListNode o2 = middle.next;
            middle.next = n1;
            n1 = middle;
            middle = o2;
        }
        ListNode reverse = n1;

        while (reverse != null) {
            if (reverse.val != head.val) {
                return false;
            }
            reverse = reverse.next;
            head = head.next;
        }
        return true;
    }

    /**
     * 针对上述代码进行优化，将查找中间节点和翻转链表的循环放在一起，反转前半个链表
     *
     * @param head 链表头结点
     * @return 返回该链表是否为回文链表的真假情况
     */
    public boolean isPalindrome2(ListNode head) {
        ListNode n1 = null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode o1 = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            ListNode o2 = o1.next;
            o1.next = n1;
            n1 = o1;
            o1 = o2;
        }
//        System.out.println(n1);
//        System.out.println(slow);

        //这里我们发现代码的适用范围在偶数这里，如果是奇数，会少拷贝一个节点，所以
        //这里我们判断是否为奇数节点：如果fast不为null,一定是奇数节点
        if (fast != null) {
            //少拷贝一个节点，从下一个节点开始算
            slow = slow.next;
        }
        while (slow != null && n1 != null) {
            if (slow.val != n1.val) {
                return false;
            }
            slow = slow.next;
            n1 = n1.next;
        }
        return true;
    }
}
