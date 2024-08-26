package leetcode;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * </p>
 * <p>
 * 返回容器可以储存的最大水量。
 * </p>
 */
public class LeetCode11 {
    public static void main(String[] args) {
        System.out.println(new LeetCode11().maxArea(new int[]{1, 1}));
        System.out.println(new LeetCode11().maxAreaTwoPointer(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    /**
     * 暴力枚举 56/62
     *
     * @param height 给定的数组
     * @return 返回最大的矩形面积
     */
    public int maxArea(int[] height) {
        int maxArea = 0;

        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int row = j - i;
                int col = Math.min(height[i], height[j]);
                if (row * col > maxArea) {
                    maxArea = row * col;
                }
            }
        }

        return maxArea;
    }

    /**
     * 双指针算法解决暴力导致的超时问题
     *
     * @param height 所给的数组
     * @return 返回最大的矩形面积
     */
    public int maxAreaTwoPointer(int[] height) {
        int maxArea = 0;

        int left = 0;
        int right = height.length - 1;

        for (int i = 0; i < height.length - 1; i++) {
            while (left < right) {
                int row = right - left;
                int col = Math.min(height[left], height[right]);
                if (row * col > maxArea) {
                    maxArea = row * col;
                }

                if (height[left] > height[right]) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return maxArea;
    }
}
