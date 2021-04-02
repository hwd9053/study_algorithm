package 刷题用包;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class _42_接雨水 {
    public int trap(int[] height) {
        if (height.length == 0) return 0;
        int li = 0, ri = height.length - 1;
        int lower = 0, lowerMax = 0, water = 0;

        while (li < ri) {
            lower = height[li] <= height[ri] ? height[li++] : height[ri--];
            lowerMax = Math.max(lower, lowerMax);
            water += lowerMax - lower;
        }
        return water;
    }
}
