package priorityQueue.test;

/**
 * 再次尝试手搓小顶堆合并k个升序链表
 */
public class Test {
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
        System.out.println(new Test().mergeKLists(lists));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        MinHeap minHeap = new MinHeap(lists.length);
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        ListNode s = new ListNode(-1, null);
        ListNode head = s;
        while (!minHeap.isEmpty()) {
            ListNode min = minHeap.poll();
            head.next = min;
            head = min;
            if (min.next != null) {
                minHeap.offer(min.next);
            }
        }
        return s.next;
    }

    /**
     * 使用小顶堆实现合并多个有序链表为升序序列
     */
    public static class MinHeap {
        ListNode[] arr;
        int size;

        public MinHeap(int capacity) {
            this.arr = new ListNode[capacity];
        }

        public boolean offer(ListNode offered) {
            if (isFull()) {
                return false;
            }
            int child = size++;
            int parent = (child - 1) / 2;
            while (child > 0 && offered.val < arr[parent].val) {
                arr[child] = arr[parent];
                child = parent;
                parent = (parent - 1) / 2;
            }
            arr[child] = offered;
            return true;
        }

        public ListNode poll() {
            if (isEmpty()) {
                return null;
            }
            swap(0, size - 1);
            size--;
            ListNode min = arr[size];
            arr[size] = null;
            down(0);
            return min;
        }

        private void swap(int i, int j) {
            ListNode temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        private void down(int parent) {
            int left = 2 * parent + 1;
            int right = left + 1;
            int min = parent;
            if (left < size && arr[left].val < arr[min].val) {
                min = left;
            }
            if (right < size && arr[right].val < arr[min].val) {
                min = right;
            }
            if (min != parent) {
                swap(min, parent);
                down(min);
            }
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == arr.length;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            ListNode head = this;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            while (head != null) {
                if (head.next == null) {
                    sb.append(head.val).append("]");
                } else {
                    sb.append(head.val).append(", ");
                }
                head = head.next;
            }
            return sb.toString();
        }
    }
}
