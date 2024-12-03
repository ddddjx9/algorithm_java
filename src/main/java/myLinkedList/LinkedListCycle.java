package myLinkedList;

import myLinkedList.dataStructure.ListNode;

public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode n10 = new ListNode(10, null);
        ListNode n9 = new ListNode(9, n10);
        ListNode n8 = new ListNode(8, n9);
        ListNode n7 = new ListNode(7, n8);
        ListNode n6 = new ListNode(6, n7);
        ListNode n5 = new ListNode(5, n6);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        n10.next = n1;
        System.out.println(new LinkedListCycle().hasCycle(n1));
        System.out.println(new LinkedListCycle().detectCycle(n1));
    }

    /*
    LeetCode141:
    判断链表中是否存在环，使用弗洛伊德龟兔赛跑算法
    如果链表中存在环，那么在环上以不同速度前进的两个指针必定会在某个时刻相遇
    阶段一：
        乌龟一次走一步，兔子一次走两步
        当兔子能走到终点时，不存在环
        当兔子能追上乌龟时，可以判断存在环
    阶段二：
        从他们第一次相遇开始，乌龟回到起点，兔子保持原位不变
        乌龟和兔子都是一次走一步
        当再次相遇时，地点就是环的入口
     */
    public boolean hasCycle(ListNode head) {
        ListNode t = head;
        ListNode r = head;
        //防止出现空指针调用
        while (r != null && r.next != null) {
            t = t.next;
            r = r.next.next;
            if (r == t) return true;
        }
        return false;
    }

    /**
     * LeetCode142：
     * 检测是否存在环，并最终返回环的入口
     *
     * @param head 链表的头结点
     * @return 如果存在环的话，返回环的入口，如果不存在环的话，返回null
     */
    public ListNode detectCycle(ListNode head) {
        ListNode t = head;
        ListNode r = head;
        while (r != null && r.next != null) {
            t = t.next;
            r = r.next.next;
            if (t == r) {
                //检测出存在环，那么将乌龟放在原点位置，兔子代替乌龟的位置和走法。
                //当他们再次相遇的时候，相遇的节点就是环的入口
                t = head;
                while (t != r) {
                    r = r.next;
                    t = t.next;
                }
                return r;
            }
        }
        return null;
    }
}

