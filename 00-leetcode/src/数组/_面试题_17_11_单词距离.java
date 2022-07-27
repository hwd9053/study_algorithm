package 数组;

/**
 * https://leetcode.cn/problems/find-closest-lcci/
 */
public class _面试题_17_11_单词距离 {
    // 如果要反复执行的话，可以考虑用一个map，key为单词字符串，value为一个储存单词出现位置的链表或数组。
    public int findClosest(String[] words, String word1, String word2) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0, p = -1, q = -1; i < words.length; i++) {
            String word = words[i];
            if (word.equals(word1)) {
                p = i;
                if (q >= 0) ans = Math.min(Math.abs(p - q), ans);
                if (ans == 1) return ans;
            } else if (word.equals(word2)) {
                q = i;
                if (p >= 0) ans = Math.min(Math.abs(p - q), ans);
                if (ans == 1) return ans;
            }
        }
        return ans;
    }
}
