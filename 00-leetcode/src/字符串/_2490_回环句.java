package 字符串;

/**
 * https://leetcode.cn/problems/circular-sentence/
 */
public class _2490_回环句 {
    public boolean isCircularSentence(String sentence) {
        char[] cs = sentence.toCharArray();
        int n = cs.length;
        if (cs[0] != cs[n - 1]) return false;

        for (int i = 1; i < n - 1; i++) {
            if (cs[i] == ' ' && cs[i - 1] != cs[i + 1]) return false;
        }

        return true;
    }
}
