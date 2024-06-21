package search.cn.edu.ustb.search;


public class BinarySearchLeftMost {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(binarySearchLeftMost1(arr, 8));
        System.out.println(binarySearchLeftMost2(arr, 8));
        System.out.println(binarySearchRightMost(arr, 6));
    }

    /**
     * 这是一个查找最左侧或者说前任索引的算法，还未改进
     *
     * @param arr    待查找的数组
     * @param target 查找的目标值
     * @return 返回目标值的最左侧的索引
     */
    public static int binarySearchLeftMost1(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;
        int candidate = -1;
        while (i <= j) {
            int mid = (i + j) >>> 1;
            if (target < arr[mid]) {
                j = mid - 1;
            } else if (target > arr[mid]) {
                i = mid + 1;
            } else {
                candidate = mid;
                j = mid - 1;
            }
        }
        return candidate;
    }


    /**
     * 查找前任的算法
     *
     * @param arr    待查找的数组
     * @param target 查找的目标值
     * @return 返回一个>=target的最靠左的索引
     */
    public static int binarySearchLeftMost2(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            int mid = (i + j) >>> 1;
            if (target <= arr[mid]) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }

    /**
     * 查找后任的算法
     *
     * @param arr    待查找的数组
     * @param target 查找的目标值
     * @return 返回一个<= target的最靠右的索引
     */
    public static int binarySearchRightMost(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            int mid = (i + j) >>> 1;
            if (target >= arr[mid]) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i - 1;
    }
}
