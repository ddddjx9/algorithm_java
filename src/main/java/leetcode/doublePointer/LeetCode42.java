package leetcode.doublePointer;

public class LeetCode42 {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new LeetCode42().trap(height));
    }

    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     *
     * @param height 给定的高度数组
     * @return 返回能接到的雨水数
     */
    public int trap(int[] height) {
        // 1. 边界情况判断，如果传入的高度数组为null或者长度为0，说明不存在柱子，直接返回蓄水量为0
        if (height == null || height.length == 0) {
            return 0;
        }
        // 2. 初始化指向数组最左边柱子的索引，从0开始
        int left = 0;
        // 3. 初始化指向数组最右边柱子的索引，即数组长度减1
        int right = height.length - 1;
        // 4. 初始化记录左边已遍历柱子中的最大高度，初始值设为0，后续会不断更新
        int leftMax = 0;
        // 5. 初始化记录右边已遍历柱子中的最大高度，同样初始值设为0，后续也会不断更新
        int rightMax = 0;
        // 6. 初始化总的蓄水量为0，后续随着计算会累加
        int totalArea = 0;
        // 7. 开始循环，只要left指针还在right指针的左边（也就是还没遍历完整个数组），就持续循环
        while (left < right) {
            // 8. 更新左边已遍历柱子中的最大高度，取当前的leftMax和height[left]（当前左边指针指向柱子的高度）中较大的值作为新的leftMax
            leftMax = Math.max(leftMax, height[left]);
            // 9. 更新右边已遍历柱子中的最大高度，取当前的rightMax和height[right]（当前右边指针指向柱子的高度）中较大的值作为新的rightMax
            rightMax = Math.max(rightMax, height[right]);
            // 10. 判断左边已遍历的最大高度和右边已遍历的最大高度，如果左边最大高度小于右边最大高度
            if (leftMax < rightMax) {
                // 11. 计算当前left指针指向柱子处能接住的雨水量，就是用左边最大高度减去当前柱子的高度（如果差值大于0，表示可以接住雨水），并累加到totalArea中
                totalArea += leftMax - height[left];
                // 12. 将left指针向右移动一位，继续考察下一个柱子
                left++;
            } else {
                // 13. 如果左边最大高度大于等于右边最大高度，计算当前right指针指向柱子处能接住的雨水量，用右边最大高度减去当前柱子的高度（差值大于0可接住雨水），累加到totalArea中
                totalArea += rightMax - height[right];
                // 14. 将right指针向左移动一位，继续考察下一个柱子
                right--;
            }
        }
        // 15. 当left和right指针相遇，说明整个数组遍历完毕，返回总的蓄水量totalArea
        return totalArea;
    }
}
