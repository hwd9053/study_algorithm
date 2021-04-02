package 刷题用包;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class _11_盛最多水的容器 {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int li = 0, ri = height.length - 1;

        while (li < ri) {
            int minH = Math.min(height[li], height[ri]);
            maxArea = Math.max(maxArea, minH * (ri - li));
            while (li < ri && height[li] <= minH) li++;
            while (li < ri && height[ri] <= minH) ri--;
        }

        return maxArea;
    }
}
