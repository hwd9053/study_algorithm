package 数学;

/**
 * https://leetcode-cn.com/problems/implement-rand10-using-rand7/
 * https://leetcode-cn.com/problems/implement-rand10-using-rand7/solution/yong-rand7-shi-xian-rand10-by-leetcode-s-qbmd/
 */
public class _470_用Rand7实现_Rand10 {
    // 拒绝采样
    public int rand10() {
        int row, col, idx;
        do {
            row = rand7();
            col = rand7();
            idx = col + (row - 1) * 7;
        } while (idx > 40);

        return 1 + (idx - 1) % 10;
    }

    public int rand7() {
        return (int) (Math.random() * 7 + 1);
    }
}
