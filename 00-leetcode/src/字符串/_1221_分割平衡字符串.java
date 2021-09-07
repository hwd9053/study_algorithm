package 字符串;

/**
 * https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/
 */
public class _1221_分割平衡字符串 {
    public int balancedStringSplit(String s) {
        int ans = 0;
        char[] cs= s.toCharArray();
        int lc = 0, rc = 0;

        for (char c : cs) {
            if (c == 'L') {
                lc++;
            } else {
                rc++;
            }
            if (lc == rc) {
                ans++;
                lc = 0;
                rc = 0;
            }
        }

        return ans;
    }
}
