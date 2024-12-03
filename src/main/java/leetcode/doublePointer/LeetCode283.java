package leetcode.doublePointer;

public class LeetCode283 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 0, 3, 12};
        new LeetCode283().moveZeroes(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * @param nums 给定的数组
     */
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }

        int p = 0;
        int q = 0;
        // 通过两个指针，p指向当前已经处理好的非零元素应该放置的位置，q用于遍历数组寻找非零元素
        while (q < nums.length) {
            if (nums[q] != 0) {
                // 当发现nums[q]不为0时，将其交换到前面合适的位置（即p指向的位置）
                swap(nums, p, q);
                p++;
            }
            q++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
