package 数组;

/**
 * https://leetcode-cn.com/problems/find-the-student-that-will-replace-the-chalk/
 */
public class _1894_找到需要补充粉笔的学生编号 {
    // 二分加前缀。虽然不用也没事，时间复杂度都是o(n)
    public int chalkReplacer(int[] chalk, int k) {
        int[] preSum = new int[chalk.length];

        preSum[0] = chalk[0];
        if (k < chalk[0]) return 0;
        int remain = k - chalk[0];

        // 构建前缀和数组
        for (int i = 1; i < chalk.length; i++) {
            preSum[i] = chalk[i] + preSum[i - 1];
            remain -= chalk[i];
            if (remain < 0) return i;
        }

        // 算出最后一次遍历时，还剩多少根粉笔
        remain = k % preSum[preSum.length - 1];

        // 对前缀和数组进行二分搜索。找第一个大于等于remain的坐标
        int l = 0, r = preSum.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (preSum[mid] < remain) {
                l = mid + 1;
            } else if (preSum[mid] > remain) {
                r = mid;
            } else {
                // 刚好相等时，下一个学生需要补充粉笔
                return mid + 1;
            }
        }

        return l;
    }
}
