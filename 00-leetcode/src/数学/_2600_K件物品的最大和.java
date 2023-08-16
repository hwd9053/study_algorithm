package 数学;

/**
 * https://leetcode.cn/problems/k-items-with-the-maximum-sum/description/
 */
public class _2600_K件物品的最大和 {
    // 水题
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        return k >= numOnes ? numOnes - (k >= numOnes + numZeros ? k - numOnes - numZeros : 0) : k;
    }
}
