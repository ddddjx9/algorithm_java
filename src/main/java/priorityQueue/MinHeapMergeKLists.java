package priorityQueue;

import myLinkedList.dataStructure.ListNode;
import priorityQueue.dataStructure.MinHeap;

public class MinHeapMergeKLists {
    public static void main(String[] args) {
        ListNode n45 = new ListNode(7, null);
        ListNode n44 = new ListNode(3, n45);
        ListNode n43 = new ListNode(2, n44);
        ListNode n42 = new ListNode(1, n43);
        ListNode n41 = new ListNode(0, n42);

        ListNode n35 = new ListNode(9, null);
        ListNode n34 = new ListNode(5, n35);
        ListNode n33 = new ListNode(4, n34);
        ListNode n32 = new ListNode(2, n33);
        ListNode n31 = new ListNode(0, n32);

        ListNode n24 = new ListNode(7, null);
        ListNode n23 = new ListNode(6, n24);
        ListNode n22 = new ListNode(5, n23);
        ListNode n21 = new ListNode(3, n22);

        ListNode n14 = new ListNode(8, null);
        ListNode n13 = new ListNode(6, n14);
        ListNode n12 = new ListNode(4, n13);
        ListNode n11 = new ListNode(1, n12);
        ListNode[] lists = {n11, n21, n31, n41};
        System.out.println(new MinHeapMergeKLists().mergeKLists(lists));
    }

    /**
     * <p>
     * LeetNode21：合并多个有序链表
     * </p>
     * <p>
     * 将多个链表中的元素依次加入小顶堆
     * </p>
     * <p>
     * 每一轮，将每个链表的头部全部加入小顶堆
     * </p>
     * <p>
     * 一轮结束之后，将小顶堆的头部加入新的链表尾部即可
     * </p>
     */
    public ListNode mergeKLists(ListNode[] lists) {
        MinHeap heap = new MinHeap(lists.length);
        for (ListNode list : lists) {
            //将链表中的头姐带你加入到小顶堆
            if (list != null) {
                heap.offer(list);
            }
        }

        //不断从堆顶移除最小元素，加入新链表
        ListNode s = new ListNode(-1, null);
        ListNode head = s;
        while (!heap.isEmpty()) {
            ListNode min = heap.poll();
            head.next = min;
            head = min;

            if (min.next != null) {
                heap.offer(min.next);
            }
        }
        return s.next;
    }
}
